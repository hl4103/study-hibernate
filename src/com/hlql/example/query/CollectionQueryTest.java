package com.hlql.example.query;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.junit.Test;

import com.hlql.example.domain.Employee;
import com.hlql.example.domain.Project;
import com.hlql.util.HibernateUtil;

public class CollectionQueryTest {

	@Test
	public void test1() {
		Session session = HibernateUtil.getSession();
		
		List<Project> list = session.createQuery("Select p from Project p where p.employees.size > 0").list();
		
		session.close();

		for (Project p : list) {
			System.out.println(p.getName());
		}
	}

	@Test
	public void test2() {
		Session session = HibernateUtil.getSession();
		List<Object[]> list = session.createQuery("Select e.name,e.dept.name from Employee e").list();
		session.close();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
	}

	@Test
	public void test3() {
		Session session = HibernateUtil.getSession();
		String hql = "Select max(e.salary),avg(e.salary) from Employee e left JOIN e.dept d group by d";
		List<Object[]> list = session.createQuery(hql).list();
		session.close();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
	}

	@Test
	public void test4() {
		Session session = HibernateUtil.getSession();
		String hql = "Select max(e.salary),avg(e.salary) from Employee e left JOIN e.dept d group by d";
		List<Object[]> list = session.createQuery(hql).list();
		session.close();
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
	}

	// 查询出大于平均工资的员工信息
	@Test
	public void test5() {
		Session session = HibernateUtil.getSession();
		String hql = "Select e from Employee e where e.salary >= (select avg(o.salary) from Employee o)";
		List<Employee> list = session.createQuery(hql).list();
		session.close();
		for (Employee e : list) {
			System.out.println(e.getSalary());
		}
	}

}
