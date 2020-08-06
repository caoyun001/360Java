package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.common.GlobalConst;
import com.itheima.mm.entity.Result;
import com.itheima.mm.pojo.User;
import com.itheima.mm.utils.JedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/17
 * @description ：公共控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class CommonController extends BaseController {

	static {
		// 初始化Jedis工具类
		JedisUtils.init(ResourceBundle.getBundle("jedis"));
		log.info("init jedis...");
	}

	@HmRequestMapping("/common/upload")
	public void upload(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			//创建磁盘工厂对象
			DiskFileItemFactory itemFactory = new DiskFileItemFactory();
			//创建Servlet的上传解析对象,构造方法中,传递磁盘工厂对象
			ServletFileUpload fileUpload = new ServletFileUpload(itemFactory);
			/*
			 * fileUpload调用方法 parseRequest,解析request对象
			 * 页面可能提交很多内容 文本框,文件,菜单,复选框 是为FileItem对象
			 * 返回集合,存储的文件项对象
			 */
			List<FileItem> list = fileUpload.parseRequest(request);
			List<Map<String,String>> resultList = new ArrayList<>();
			for(FileItem item : list){
				//判断普通项还是附件项,
				if(!item.isFormField()){
					// 获取上传的文件名   Lighthouse.jpg
					String fileName = item.getName();
					// 对文件名进行重命名,UUID+文件后缀(文件类型)
					String newFileName = UUID.randomUUID().toString().replace("-","");
					String fileType = fileName.substring(fileName.lastIndexOf('.'));
					fileName = newFileName+fileType;
					// 获取应用程序路径
					String contexPath= request.getSession().getServletContext().getRealPath("/");
					log.debug("contexPath:{}",contexPath);
					// 读取配置文件,获得上传图片的相对路径
					ResourceBundle resourceBundle = ResourceBundle.getBundle("app-config");
					String uploadDirPath= resourceBundle.getString("upload_path");
					// 读取文件数据，并存到Web资源目录
					File uploadDir = new File(contexPath,uploadDirPath);
					// 构建本地存储的文件对象
					File uploadFile = new File(uploadDir,fileName);
					// 从上传文件项获取字节输入流，然后保存到指定的上传目录下
					InputStream inputStream = item.getInputStream();
					FileOutputStream fos = new FileOutputStream(uploadFile);
					// 通过IO工具存入磁盘
					IOUtils.copy(inputStream,fos);
					// 关闭流
					IOUtils.closeQuietly(fos);
					IOUtils.closeQuietly(inputStream);
					// 存入数据库的路径
					String saveDbPath = uploadFile.getAbsolutePath().replace(contexPath,"");
					Map mapResult = new HashMap();
					// 以上传的文件组件名为key,数据库保存的相对路径为value
					mapResult.put(item.getFieldName(),saveDbPath);
					resultList.add(mapResult);
					// 存入redis,Session失效时执行
					if(JedisUtils.isUsed()){
						User user= getSessionUser(request,GlobalConst.SESSION_KEY_USER);
						Integer userId = user!=null?user.getId():1;
						String saveKey = GlobalConst.REDIS_KEY_SET_UPLOAD_IMAGE.concat(userId+"");
						JedisUtils.getResource().sadd(saveKey,saveDbPath);
						log.info("redis save key:{} value:{}",saveKey,saveDbPath);
					}
				}
			}
			printResult(response,new Result(true,"上传成功",resultList));
		}catch (Exception ex){
			ex.printStackTrace();
			printResult(response,new Result(false,"上传失败,"+ex.getMessage()));
		}
	}
}
