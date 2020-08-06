package com.itheima.mm.listener;

import com.itheima.mm.common.GlobalConst;
import com.itheima.mm.pojo.User;
import com.itheima.mm.utils.JedisUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.io.File;
import java.util.Set;

/**
 * @author ：seanyang
 * @date ：Created in 2019/8/22
 * @description ：会话监听
 * @version: 1.0
 */
@Slf4j
@WebListener
public class MmSessionListener implements HttpSessionListener {
	@Override
	public void sessionCreated(HttpSessionEvent httpSessionEvent) {
		log.info("sessionCreated......");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
		log.info("sessionDestroyed......");
		HttpSession session = httpSessionEvent.getSession();
		// 清理图片
		clearImg(session);
	}
	// 清理图片
	private void clearImg(HttpSession session){
		User user = (User) session.getAttribute(GlobalConst.SESSION_KEY_USER);
		if (user != null) {
			log.info(user.getId()+ "---用户session销毁！");
			// 删除redis中关于用户未清除的图片信息
			String contexPath= session.getServletContext().getRealPath("/");
			String appName = session.getServletContext().getServletContextName();
			log.debug("contexPath:{},appName:{}",contexPath,appName);
			if (JedisUtils.isUsed()){
				// 获取key的值
				String redisKey = GlobalConst.REDIS_KEY_SET_UPLOAD_IMAGE.concat(user.getId()+"");
				Set<String> sets = JedisUtils.getResource().smembers(redisKey);
				for (String imgSavePath:sets){
					File file = new File(contexPath,imgSavePath);
					// 删除文件
					FileUtils.deleteQuietly(file);
					log.info("delete file:",file.getAbsolutePath());
					JedisUtils.getResource().srem(redisKey,imgSavePath);
				}
			}
		}
	}
}
