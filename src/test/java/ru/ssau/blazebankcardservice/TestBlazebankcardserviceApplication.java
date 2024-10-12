package ru.ssau.blazebankcardservice;

import org.springframework.boot.SpringApplication;

public class TestBlazebankcardserviceApplication {

	public static void main(String[] args) {
		SpringApplication.from(BlazebankcardserviceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
