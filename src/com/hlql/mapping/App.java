package com.hlql.mapping;

import java.util.Set;

import org.hibernate.Session;
import org.junit.Test;

import com.hlql.util.HibernateUtil;

public class App {

	@Test
	public void test() {
		User u = new User();
		u.setName("Tom");
		u.getEmailSet().add("A");
		u.getEmailSet().add("B");
		u.getEmailSet().add("C");

		u.getEmailList().add("b");
		u.getEmailList().add("a");
		u.getEmailList().add("c");

		u.getEmailBag().add("C");
		u.getEmailBag().add("D");
		u.getEmailBag().add("E");

		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(u);
		session.getTransaction().commit();
		session.close();
	}

	@Test
	public void test1() {
		Session session = HibernateUtil.getSession();
		User u = (User) session.get(User.class, 1L);
		System.out.println(u.getName());
		Set<String> set = u.getEmailSet();
		System.out.println(set.getClass());
		session.close();
	}

}
