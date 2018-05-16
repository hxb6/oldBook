package com.hxb.oldBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@MapperScan("com.hxb.oldBook.mapper")
public class OldbookApplication {

    public static void main(String[] args) {
        SpringApplication.run(OldbookApplication.class, args);
    }
}
