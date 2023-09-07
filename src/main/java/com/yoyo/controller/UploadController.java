package com.yoyo.controller;


import com.yoyo.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;

@Slf4j//记录日志
@RestController
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, MultipartFile image) throws Exception{
        log.info("文件上传：{}, {}, {}",username,age, image);

        //获取文件名
        String originalFilename=image.getOriginalFilename();
        //构造唯一文件名（不能重复）:利用uuid
        int index=originalFilename.lastIndexOf(".");//最后一个点的位置
        String extname = originalFilename.substring(index);//得到.后缀名
        String newFileName = UUID.randomUUID().toString()+extname;

        // 在application.properties设置最大文件大小

        //将文件存储在服务器的磁盘目录中 指定路径
        image.transferTo(new File("F:\\project\\Java\\springboot3Image\\"+newFileName));
        return Result.success();

    }
}
