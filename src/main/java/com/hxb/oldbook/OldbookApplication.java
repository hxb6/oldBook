package com.hxb.oldbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hxb.oldbook.mapper")
public class OldbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(OldbookApplication.class, args);
	}
}
