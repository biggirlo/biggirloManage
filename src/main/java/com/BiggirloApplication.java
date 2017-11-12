package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
@ServletComponentScan
public class BiggirloApplication  {

	public static void main(String[] args) {
		SpringApplication.run(BiggirloApplication.class, args);
	}
}
