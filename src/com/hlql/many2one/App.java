package com.hlql.many2one;

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
		e2.setName("Tom");

		e1.setDept(d);
		e2.setDept(d);

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		
		session.save(d);
		session.save(e1);
		session.save(e2);
		
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * 1. 通过many方对象来获取one方对象，存在延迟加载情况，one方对象是一个代理对象
	 * 2. 此时one方可以通过if-null来判断，和load的延迟加载对象有冲突．实则不冲突．
	 * 3. 因为one方为代理对象（延迟加载对象），所以不能在session关闭之后获取one方的值．
	 */
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
