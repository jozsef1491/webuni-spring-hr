package hu.webuni.hr.jozsicode.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import hu.webuni.hr.jozsicode.service.DefaultEmployeeService;
import hu.webuni.hr.jozsicode.service.EmployeeService;

@Configuration
@Profile("!smart")
public class EmployeeConfiguration {

	
	
	@Bean
	public EmployeeService employeeService() {
		return new DefaultEmployeeService();
}
	
}
