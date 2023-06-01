package com.dxc.dao1;

import java.util.List;

import com.dxc.model1.Employee;

public interface EmployeeDao1 {
	public int saveEmployee(String empName,int empage,double empsalary);
	public List<Employee> getAllEmployee();
	public void updateEmployee(int empid,int empage);
	public void updateEmployee1(int empid,double empsalary);
	public void deleteEmployee(int empid);
	Employee getEmployee(int empid);
}
