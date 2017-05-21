package cn.cincout.cavia.cloud.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class AccountWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountWebApplication.class, args);
	}

	@Autowired
	private Environment environment;
}
