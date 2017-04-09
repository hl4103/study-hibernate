package com.hlql.object_state;

import org.hibernate.Session;
import org.junit.Test;

import com.hlql.oid.Person;
import com.hlql.util.HibernateUtil;

public class ObjectState {

	@Test
	public void testTransient() throws Exception {
		Person p = new Person();
		p.setName("xxx");
		// save方法之前p对象就处于临时状态
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(p); // 临时状态－－－＞持久化状态．
		// 持久化状态
		session.getTransaction().commit();
		session.close();
		// 游离状态．
	}

	@Test
	public void test2() throws Exception {

	}

	@Test
	public void test3() throws Exception {

	}

}
