package hu.webuni.hr.jozsicode.service;

import org.springframework.stereotype.Service;

import hu.webuni.hr.jozsicode.model.Employee;

@Service
public class SalaryService {

	private EmployeeService employeeService;

	public SalaryService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	public int getFinalSalary(Employee employee) {
		return (int) (((employeeService.getPayRaisePercent(employee)/100.0)+1.0)*((long)employee.getPayment()));
	}

}
