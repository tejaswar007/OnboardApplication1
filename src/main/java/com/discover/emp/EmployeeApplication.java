package com.discover.emp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class EmployeeApplication implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeApplication.class);
		
	@Autowired
	private Environment environment;

	public static void main(String[] args) {
		SpringApplication.run(EmployeeApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		if(environment!=null) {
			for(final String profile : environment.getActiveProfiles()) {
				logger.info("EmployeeApplication::run::profile::{}",profile);
			}
		}
	}
	

}
