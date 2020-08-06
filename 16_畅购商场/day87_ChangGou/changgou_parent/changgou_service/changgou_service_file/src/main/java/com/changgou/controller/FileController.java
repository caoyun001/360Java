package com.changgou.controller;

import com.changgou.entity.Result;
import com.changgou.entity.StatusCode;
import com.changgou.util.FastDFSClient;
import com.changgou.util.FastDFSFile;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/file")
public class FileController {


    @PostMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile file){
        try {
            //1.获取文件的名称
            String orgName = file.getOriginalFilename();

            //2.获取文件的后缀
            int index = orgName.lastIndexOf(".");
            String extName = orgName.substring(index);

            //3.获取文件的内容
            byte[] content = file.getBytes();

            //4.构建文件对象
            FastDFSFile fastDFSFile = new FastDFSFile(orgName, content, extName);

            //5.执行上传
            String[] uploadResult = FastDFSClient.upload(fastDFSFile);
            String groupName = uploadResult[0];//获取远程文件的组名
            String remoteFilePath = uploadResult[1];//获取远程文件的路径
            
            //6.拿到上传结果拼接URL
            String url = FastDFSClient.getTrackerUrl() + groupName + "/" + remoteFilePath;

            //TODO 此处应该添加存储文件路径到DB的操作

            return new Result(true, StatusCode.OK, "上传文件成功", url);
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, StatusCode.ERROR, "上传文件失败");
        }

    }


    @GetMapping("/download")
    public ResponseEntity<byte[]> download(){
        String groupName = "group1";
        String remoteFilePath = "M00/00/00/wKjIgF4K63CADCL4AAExLnOmmB845..jpg";
        byte[] content = FastDFSClient.downFile2(groupName, remoteFilePath);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            headers.setContentDispositionFormData("attachment", new String("黑马程序员.jpg".getBytes("UTF-8"),"iso8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(content, headers, HttpStatus.CREATED);
    }


    @PostMapping("/remove")
    public Result removeFile(){
        String groupName = "group1";
        String remoteFilePath = "M00/00/00/wKjIgF4K63CADCL4AAExLnOmmB845..jpg";
        try {
            FastDFSClient.deleteFile(groupName, remoteFilePath);
            return new Result(true, StatusCode.OK, "文件删除成功");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false, StatusCode.ERROR, "文件删除失败");
        }
    }

}
