package com.itheima.mm.controller;

import com.itheima.framework.annotation.HmComponent;
import com.itheima.framework.annotation.HmRequestMapping;
import com.itheima.mm.base.BaseController;
import com.itheima.mm.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
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
 * @date ：Created in 2019/11/5
 * @description ：公共控制器
 * @version: 1.0
 */
@HmComponent
@Slf4j
public class CommonController extends BaseController {

	@HmRequestMapping("/common/upload")
	public void upload (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			// fileupload初始化
			DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
			ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
			// 通过servletFileUpload组件，获取表单列表数据(表单普通项数据和文件附件项数据)
			List<FileItem> fileItemList = servletFileUpload.parseRequest(request);
			List<Map<String,String>> resultList = new ArrayList<>();
			for (FileItem item:fileItemList){
				// 寻找文件项
				if(!item.isFormField()){
					// 获取上传的文件名   Lighthouse.jpg
					String fileName = item.getName();
					// 对文件名进行重命名,UUID+文件后缀(文件类型)
					String newFileName = UUID.randomUUID().toString().replace("-","");
					// 取文件后缀名
					String fileType = fileName.substring(fileName.lastIndexOf('.'));
					fileName = newFileName+fileType;
					System.out.println("fileName:"+fileName);
					// 保存哪里？ /img/upload
					// 找到tomcat运行绝对路径+从配置文件得到相对路径
					// 获取应用程序路径
					String contexPath= request.getSession().getServletContext().getRealPath("/");
					log.debug("contexPath:{}",contexPath);
					// 读取配置文件,获得上传图片的相对路径
					ResourceBundle resourceBundle = ResourceBundle.getBundle("app-config");
					String uploadDirPath= resourceBundle.getString("upload_path");
					// 读取文件数据，并存到Web资源目录
					// img/upload
					File uploadDir = new File(contexPath,uploadDirPath);
					// 构建本地存储的文件对象
					File uploadFile = new File(uploadDir,fileName);
					// 从上传的输入流读取数据，写入到文件输出流
					InputStream inputStream = item.getInputStream();
					FileOutputStream fos = new FileOutputStream(uploadFile);
					// 通过IO工具存入磁盘
					IOUtils.copy(inputStream,fos);
					// 静悄悄的关闭
					IOUtils.closeQuietly(inputStream);
					IOUtils.closeQuietly(fos);

					// 把路径返回给客户端
					// /img/upload/kl.jpg
					// 存入数据库的路径
					String saveDbPath = uploadFile.getAbsolutePath().replace(contexPath,"");
					Map<String,String> fileMap = new HashMap<>();
					fileMap.put(fileName,saveDbPath);
					resultList.add(fileMap);
				}
			}
			// 假设图片上传成功，返回图片路径
			//Map<String,String> fileMap = new HashMap<>();
			//fileMap.put("kl.jpg","/img/upload/kl.jpg");
			//resultList.add(fileMap);
			printResult(response,new Result(true,"上传成功",resultList));
		}catch(Exception re){
		    re.printStackTrace();
		    printResult(response,new Result(false,"上传失败！！！"));
		}
	}
}
