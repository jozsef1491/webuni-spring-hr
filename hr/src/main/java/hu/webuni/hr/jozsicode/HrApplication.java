package hu.webuni.hr.jozsicode;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import hu.webuni.hr.jozsicode.model.Employee;
import hu.webuni.hr.jozsicode.model.Post;
import hu.webuni.hr.jozsicode.service.SalaryService;

@SpringBootApplication
public class HrApplication implements CommandLineRunner {

	@Autowired
	private SalaryService salaryService;
	
	public static void main(String[] args) {
		SpringApplication.run(HrApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println(salaryService.getFinalSalary(new Employee(12, "Jack",Post.DOORMAN,100_000,LocalDate.parse("2008-02-02"))));
		System.out.println(salaryService.getFinalSalary(new Employee(12, "Jill",Post.SALES,100_000,LocalDate.parse("2014-02-02"))));
		System.out.println(salaryService.getFinalSalary(new Employee(13, "Anna",Post.SALES,100_000,LocalDate.parse("2017-06-11"))));
		System.out.println(salaryService.getFinalSalary(new Employee(13, "Bela",Post.MECHANIC,100_000,LocalDate.parse("2019-04-06"))));
	}

}
