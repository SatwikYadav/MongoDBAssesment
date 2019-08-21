package com.example.demoMongoDb.Model;

import org.springframework.data.annotation.Id;

public class Employee {

	@Id
	private String Name;
	private String Departments;
	private String reporting_manager;
	private int Age;
	private String Salary;
	
	public Employee( String name, String departments, String reporting_manager, int age,String salary) {
		super();
		Name = name;
		Departments = departments;
		this.reporting_manager = reporting_manager;
		Age = age;
		Salary = salary;
	}

	public Employee() {
	}
	

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDepartments() {
		return Departments;
	}

	public void setDepartments(String departments) {
		Departments = departments;
	}

	public String getReporting_manager() {
		return reporting_manager;
	}

	public void setReporting_manager(String reporting_manager) {
		this.reporting_manager = reporting_manager;
	}

	public int getAge() {
		return Age;
	}

	public void setAge(int age) {
		Age = age;
	}

	public String getSalary() {
		return Salary;
	}

	public void setSalary(String salary) {
		Salary = salary;
	}

	
	
}
