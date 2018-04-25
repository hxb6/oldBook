package com.hxb.oldBook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.hxb.oldBook.mapper")
public class OldbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(OldbookApplication.class, args);
	}
}
