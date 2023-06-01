package com.dxc.client;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dxc.dao1.EmployeeDaoImpl1;
import com.dxc.model1.Employee;
public class ClientDemo {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
        EmployeeDaoImpl1 dao = new EmployeeDaoImpl1();
		
		List<Integer> arr= new ArrayList<Integer>();
		while(true) {
			System.out.println("Enter 1. To Save an data to DB");
			System.out.println("Enter 2. To obtain the list of Employees");
			System.out.println("Enter 3. To Update the Employee details");
			System.out.println("Enter 4. To Delete an Employee");
			System.out.println("Enter 5. To Exit");
			
			System.out.println();
			System.out.print("Enter your option: ");
			int option = scanner.nextInt();
			scanner.nextLine();
			
			System.out.println();
			switch(option) {
			case 1:
			{	
					System.out.println("Enter the employee details: ");
					System.out.print("Enter the employeeName: ");
					String empName = scanner.nextLine();
					System.out.print("Enter the employeeAge: ");
					int empAge = scanner.nextInt();
					System.out.print("Enter the employeeSalary: ");
					double empSalary = scanner.nextDouble();
					int empId = dao.saveEmployee(empName, empAge, empSalary);
					arr.add(empId);
//					for(Integer i : arr) {
//						System.out.println(i + " ");
//					}
//					System.out.println(arr);
					
					System.out.println();
					System.out.println("Employee saved successfully with id  " + empId);
					System.out.println();
					break;
			}		
			case 2:
			{		
					
					List<Employee> empList = dao.getAllEmployees();
					
					System.out.println();
					System.out.println(" list of all Employees : ");
					System.out.println();
					
					for(Employee emp: empList) {
						System.out.println(emp);
					}
					
					System.out.println();
					System.out.println();
					break;
					
			}	
			case 3:
			{
					System.out.println("select  an Id from the list:");
					System.out.println(arr);
					
					System.out.print("Enter the id :");
					int empId = scanner.nextInt();
					
					System.out.print("do you want to update Age / Salary (1 / 2) ?: ");
					int ch = scanner.nextInt();
					scanner.nextLine();
					
					switch(ch) {
					case 1:
					{
						System.out.print("Enter the new age: ");
						int age = scanner.nextInt();
						
						dao.updateEmployee(empId, age);
						Employee emp = dao.getEmployee(empId);
						
						System.out.println();
						System.out.println("Updated Successfully!");
						System.out.println("Updated Employee Info: "+ emp);
						System.out.println();
						break;
					}
					
					case 2:
					{
						System.out.print("Enter the new salary: ");
						double salary = scanner.nextDouble();
						
						dao.updateEmployee(empId, salary);
						Employee emp = dao.getEmployee(empId);
						
						System.out.println();
						System.out.println("Updated Successfully!");
						System.out.println("Updated Employee Info: "+ emp);
						System.out.println();
						break;
					}
				}
					break;
			}
			case 4:
			{
				
					System.out.println(arr);
					
					System.out.print("Select the employeeId which you want to delete: ");
					int empId = scanner.nextInt();
					
					Employee emp = dao.getEmployee(empId);
					
					System.out.println();
					System.out.println("Showing emp details : "+ emp);
					System.out.print("Do you want to delete ( Y / N) ? : ");
					
					scanner.nextLine();
					
					String input = scanner.nextLine();
					
					System.out.println(input);
					
					if(input.equalsIgnoreCase("Y") == true) {
						dao.deleteEmployee(empId);
						System.out.println("Object Deleted Successfully!");
						System.out.println();
					} else {
						System.out.println("Operation Cancelled!");
						System.out.println();
					}
					
					break;
			
			}
			case 5:	
				scanner.close();
				System.out.println("Came out of the loop!");
				System.exit(0);
				
		default:
				System.out.println("Try Again");
				System.out.println();
				break;
	}
			
			
		}
		
		
	}

}
