package com.hlql.one2many;

import java.util.Iterator;
import java.util.Set;

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
		e1.setName("Tom");

		Employee e2 = new Employee();
		e2.setName("Lucy");

		d.getEmps().add(e1);
		d.getEmps().add(e2);

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(d);
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 1. 存在延迟加载情况
	 * 2. 不能使用if-null来判断many方是否存在，只能用集合的size方法是否等于０来判断．
	 */
	@Test
	public void testGet() {
		Session session = HibernateUtil.getSession();
		Department d = (Department) session.get(Department.class, 1L);
		if (d.getEmps().size() == 0) {
			System.out.println("没有员工");
		} else {
			System.out.println("有员工");
		}
		Set s = d.getEmps();
		for (Iterator iterator = s.iterator(); iterator.hasNext();) {
			Employee emp = (Employee) iterator.next();
			System.out.println(emp.getName());
		}
		System.out.println(s);
		session.close();
	}

}
