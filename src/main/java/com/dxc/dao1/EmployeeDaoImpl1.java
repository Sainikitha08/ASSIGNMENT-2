package com.dxc.dao1;

import com.dxc.model1.Employee;
import com.dxc.util1.HibernateUtil1;

import java.util.List;

import org.hibernate.Session;


public class EmployeeDaoImpl1 {
	public int saveEmployee(String empname,int empage,double empsalary) {
		Employee employee = new Employee();
		employee.setEmpname(empname);
		employee.setEmpage(empage);
		employee.setEmpsalary(empsalary);
        Session session = HibernateUtil1.getSessionFactory().openSession();
		session.beginTransaction();
		int empid=(Integer)session.save(employee);
		session.getTransaction().commit();
		session.close();
		
		return empid;
	}
    public List<Employee> getAllEmployees() {
    	Session session = HibernateUtil1.getSessionFactory().openSession();
    	session.beginTransaction();
    	@SuppressWarnings("unchecked")
		List<Employee> empList = (List<Employee>) session.createQuery("FROM Employee e ORDER BY e.employeeName ASC").list();
		session.getTransaction().commit();
		session.close();

		return empList;
	}
    public void updateEmployee(int empid, int empage) {
    	Session session = HibernateUtil1.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, empid);
		employee.setEmpage(empage);
		// session.update(student);//no need to call update manually as it will be
		// updated automatically on transaction close
		session.getTransaction().commit();
		session.close();
	}
    public void updateEmployee(int empid, double empsalary) {
    	Session session = HibernateUtil1.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, empid);
		employee.setEmpsalary(empsalary);
		// session.update(student);//no need to call update manually as it will be
		// updated automatically on transaction close
		session.getTransaction().commit();
		session.close();	
	}
    public void deleteEmployee(int empid) {
    	Session session = HibernateUtil1.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, empid);
		session.delete(employee);
		session.getTransaction().commit();
		session.close();
    }
    public Employee getEmployee(int empid) {
    	Session session = HibernateUtil1.getSessionFactory().openSession();
		session.beginTransaction();
		Employee employee = (Employee) session.get(Employee.class, empid);
//		session.delete(employee);
		session.getTransaction().commit();
		session.close();
		return employee;
	}

}
