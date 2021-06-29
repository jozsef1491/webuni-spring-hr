package hu.webuni.hr.jozsicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.jozsicode.service.EmployeeService;
import hu.webuni.hr.jozsicode.service.SmartEmployeeService;

@Configuration
@Profile("smart")
public class SmartEmployeeConfiguration {

	
	@Bean
	public EmployeeService employeeService() {
		return new SmartEmployeeService();
	}
}
