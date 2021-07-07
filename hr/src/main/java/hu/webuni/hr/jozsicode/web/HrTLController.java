package hu.webuni.hr.jozsicode.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import hu.webuni.hr.jozsicode.dto.EmployeeDto;
import hu.webuni.hr.jozsicode.model.Employee;
import hu.webuni.hr.jozsicode.model.Post;



@Controller
public class HrTLController {
	
	private List<EmployeeDto> allEmployees = new ArrayList<>();
	
	{
		allEmployees.add(new EmployeeDto(12, "Jack",Post.SALES,100_000, LocalDate.parse("2008-02-02")));
		allEmployees.add(new EmployeeDto(13, "Jill",Post.SALES,100_000, LocalDate.parse("2014-02-02")));
	
	}
	
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	
	@GetMapping("/employees")
	public String listEmployees(Map<String, Object> model) {
		model.put("employees", allEmployees);
		model.put("newEmployee", new EmployeeDto());
		return "employees";
	}
	
	@PostMapping("/employees")
	public String addEmployee(EmployeeDto employee) {
		allEmployees.add(employee);
		return "redirect:employees";
	}
	
}
