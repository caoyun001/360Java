package com.itheima.code;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet(urlPatterns = "/code")
public class CodeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // 解决服务器给浏览器的数据中文乱码问题
            // response.setContentType("text/html;charset=utf-8");

            // 1 创建画布对象
            int width = 120;
            int height = 40;
            BufferedImage bufi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

            // 3 获取画笔
            Graphics g = bufi.getGraphics();

            // 4 修改背景色
            g.fillRect(0, 0, width, height);

            // 5 绘制边框
            g.setColor(Color.red);
            g.drawRect(0, 0, width-1, height-1);

            // 6 生成随机字符 且 显示
            // 6.1 准备数据
            String data = "ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnpqrstuvwxyz123456789";
            // 6.2 创建随机对象
            Random r = new Random();
            // 7.1 准备变量保存 生成的 随机字符
            String code = "";
            // 6.3 循环输出
            for (int i = 0; i < 4; i++) {
                // 6.3.2 设置字体
                g.setFont(new Font("楷体", Font.BOLD, 30));

                // 6.3.3 设置随机颜色
                g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));

                // 6.3.1 绘制字符
                char c = data.charAt(r.nextInt(data.length()));
                g.drawString(c + "", 10 + i * 30, 30);

                // 7.1 将生成的随机字符 保存到 随机字符串中
                code += c +"";
            }

            // 7 将生成的字符输出到控制台
            System.out.println(code);

            // 8 绘制干扰线
            for (int i = 0; i < 10; i++) {
                // 8.2 设置随机颜色
                g.setColor(new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255)));
                // 8.1 绘制干扰线
                g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
            }

            // 2 将画布输出到浏览器中
            ImageIO.write(bufi, "jpg", response.getOutputStream());

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
