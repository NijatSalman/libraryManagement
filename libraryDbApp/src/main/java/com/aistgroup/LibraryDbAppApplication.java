package com.aistgroup;

import com.aistgroup.entity.Book;
import com.aistgroup.entity.User;
import com.aistgroup.service.inter.BookReservationServiceInter;
import com.aistgroup.service.inter.BookServiceInter;
import com.aistgroup.service.inter.GroupUserServiceInter;
import com.aistgroup.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class LibraryDbAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryDbAppApplication.class, args);
	}


	@Bean
	public CommandLineRunner run(){
		CommandLineRunner clr=new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

			}
		};
		return  clr;
	}

}
