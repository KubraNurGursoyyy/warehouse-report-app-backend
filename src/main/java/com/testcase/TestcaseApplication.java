package com.testcase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@CrossOrigin

@SpringBootApplication
public class TestcaseApplication {

	public static void main(String[] args) throws SQLException {

		try{
			Connection connection = DriverManager.getConnection("jdbc:postgresql://ec2-63-35-156-160.eu-west-1.compute.amazonaws.com:5432/dd2ep9p1oq9io3","shmlgrwdsajukv","9b3959c28c4ca81709480b8d833d5c8ecdf0b59cbe7502a86f43d926ad2d72f8");
			System.out.println("Bağlantı başarılı");
		}catch (Exception e){
			System.out.println(e.getMessage());
		}

		SpringApplication.run(TestcaseApplication.class, args);
	}

}
