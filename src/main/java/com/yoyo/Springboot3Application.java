package com.yoyo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan//开启了对servlet组件（包含了Filter）的支持
@SpringBootApplication
public class Springboot3Application {

    public static void main(String[] args) {
        SpringApplication.run(Springboot3Application.class, args);
    }

}
