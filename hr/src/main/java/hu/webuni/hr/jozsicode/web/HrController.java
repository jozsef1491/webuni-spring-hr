package hu.webuni.hr.jozsicode.web;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.webuni.hr.jozsicode.dto.EmployeeDto;
import hu.webuni.hr.jozsicode.model.Post;


@RestController
@RequestMapping("/api/employees")
public class HrController {

	
private Map<Long, EmployeeDto> allEmployees = new HashMap<>();
	
	{
		allEmployees.put(1L, new EmployeeDto(1, "Alfred",Post.SALES,100, LocalDate.parse("2008-02-02")));
		allEmployees.put(2L, new EmployeeDto(2, "Bill",Post.MECHANIC,200, LocalDate.parse("2014-02-02")));
	
	}
	
	@GetMapping
	public List<EmployeeDto> getAll() {
		return new ArrayList(allEmployees.values());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EmployeeDto> getById(@PathVariable long id) {
		EmployeeDto employeeDto = allEmployees.get(id);
		if(employeeDto!=null)
			return ResponseEntity.ok(employeeDto);
		else
			return ResponseEntity.notFound().build();
	}
	
	
	@PostMapping
	public EmployeeDto createEmployee(@RequestBody EmployeeDto employeetDto) {
		allEmployees.put(employeetDto.getId(), employeetDto);
		return employeetDto;
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<EmployeeDto> modifyEmployee(@PathVariable long id, @RequestBody EmployeeDto employeeDto) {
		if(!allEmployees.containsKey(id)) {
			return ResponseEntity.notFound().build();
		}
		employeeDto.setId(id);
		allEmployees.put(id, employeeDto);
		return ResponseEntity.ok(employeeDto);
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable long id) {
		allEmployees.remove(id);
	}
	
	@GetMapping("/highSalary/{limit}")
	public List<EmployeeDto> getEmployeesWithHighSalary(@PathVariable long limit) {
		List<EmployeeDto> list1=new ArrayList<EmployeeDto>(allEmployees.values());
		List<EmployeeDto> resultList=new ArrayList<>();
		for (int i=0; i<list1.size(); i++) {
			if(list1.get(i).getPayment()>limit) {
				resultList.add(list1.get(i));
			}
		}
		return resultList;
	}
	
	
	
	
}
