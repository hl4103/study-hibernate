package com.hlql.many2many;

import org.hibernate.Session;
import org.junit.Test;

import com.hlql.util.HibernateUtil;

public class App {

	@Test
	public void testSave() {
		Student s1 = new Student();
		s1.setName("Tom");

		Student s2 = new Student();
		s2.setName("Lucy");

		Teacher t1 = new Teacher();
		t1.setName("张三");

		Teacher t2 = new Teacher();
		t2.setName("李四");
		
		s1.getTeachers().add(t1);
		s1.getTeachers().add(t2);
		s2.getTeachers().add(t1);
		s2.getTeachers().add(t2);

		t1.getStudents().add(s1);
		t1.getStudents().add(s2);
		t2.getStudents().add(s1);
		t2.getStudents().add(s2);


		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(t1);
		session.save(t2);
		session.save(s1);
		session.save(s2);
		session.getTransaction().commit();
		session.close();

	}

}
