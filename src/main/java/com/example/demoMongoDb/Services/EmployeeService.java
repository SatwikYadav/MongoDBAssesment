package com.example.demoMongoDb.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demoMongoDb.Model.Employee;
import com.example.demoMongoDb.Repository.EmployeeRepository;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository emprepo;
 	
	public List<Employee> listOfEmployees() {
		return emprepo.findAll();
	}


	public String createEmployee(String name, String departments, String reporting_manager, int age, String salary) {
		Employee employee = new Employee(name,departments,reporting_manager, age,salary);
		emprepo.save(employee);
		return ("New user created with id: " + employee.getName());
	}


	public String updateUser(String name, String department) {
		Employee employee = null; 
		for(Employee s:listOfEmployees()){  
		     if(s.getName().equals(name)){
		    	 s.setDepartments(department);
		    	 employee=s;
		    	 emprepo.save(employee);
		     }
		   }  
		return "UPDATED";
	}

	public String deleteEmployee(Employee employee)
    {
        emprepo.delete(employee);
        return "Employee deleted";
    }
	
}
