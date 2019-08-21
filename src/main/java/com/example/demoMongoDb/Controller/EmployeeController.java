package com.example.demoMongoDb.Controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demoMongoDb.Model.Employee;
import com.example.demoMongoDb.Services.EmployeeService;



@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService empservice;
	
	@GetMapping("/add")
	public String createEmployee(@RequestParam("name") String name, @RequestParam("department") String department,@RequestParam("reporting_manager") String reporting_manager, @RequestParam("age") int age, @RequestParam("salary") String salary)
	{
		return empservice.createEmployee(name,department,reporting_manager,age,salary);
	}
	
	@GetMapping("/listofemployees")
	public List<Employee> listUser()
	{
		return empservice.listOfEmployees();
	}
	
	
	@GetMapping("/put")
	public  String modifyUserbyId(@RequestParam("name") String name,@RequestParam("department") String department)
	{
		if(!name.equals("")) {
			return empservice.updateUser(name,department);
		}
		else {
			return "ERROR";
		}
	}
	
	
	@GetMapping("/delete")
    public String deleteUser(@RequestParam("name") String name)
    {
        if(name!=null)
        {
            for (Employee employee : empservice.listOfEmployees()) {
    
                if (employee.getName().equals(name)) {
                    empservice.deleteEmployee(employee);                
                }
            }
        }
        else
            return "Please enter the correct name";
        return "User deleted";
    }
	

}
