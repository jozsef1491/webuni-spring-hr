package hu.webuni.hr.jozsicode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hu.webuni.hr.jozsicode.config.HrConfigProperties;
import hu.webuni.hr.jozsicode.model.Employee;

@Service
public class DefaultEmployeeService implements EmployeeService {

	@Autowired
	HrConfigProperties config;
	
	
	@Override
	public int getPayRaisePercent(Employee employee) {
		return config.getEmployeeRaisedPay().getDef().getPercent();
	}

}
