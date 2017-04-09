package com.hlql.many2oneone2many;

import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.hlql.util.HibernateUtil;

public class App {

	@Before
	public void testSave() {
		Department d = new Department();
		d.setName("开发");

		Employee e1 = new Employee();
		e1.setName("Tom3");

		Employee e2 = new Employee();
		e2.setName("Tom4");

		e1.setDept(d);
		e2.setDept(d);

		d.getEmps().add(e1);
		d.getEmps().add(e2);

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(d);
		// cascade属性
		//		session.save(e1);
		//		session.save(e2);
		
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void testGet() {
		Session session = HibernateUtil.getSession();
		Employee e1 = (Employee) session.get(Employee.class, 1L);
		Department dept = e1.getDept();
		System.out.println(e1.getName());
		System.out.println(dept.getName());
		session.close();
	}

}
