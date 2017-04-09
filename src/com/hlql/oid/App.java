package com.hlql.oid;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.junit.Before;
import org.junit.Test;

import com.hlql.util.HibernateUtil;

public class App {

	@Before
	public void test() {
		Person person = new Person();
		person.setName("Tom");
		Session session = HibernateUtil.getSession();
		session.beginTransaction();
		session.save(person);
		session.getTransaction().commit();
		session.close();
	}

	/**
	 * get和load方法的区别
	 * 1. get会立刻发送select语句，load不会立刻发送，当使用到该对象的非OID属性时才会发送select语句，延迟加载．
	 * 2. load方法返回的对象永远不为null,即使在数据库中不存在，所以不能使用if-null的方式来判断，而get则可以为null.
	 * 3. load方法会创建代理对象．由javassist-3.18.1-GA.jar生成
	 * 4. 代理对象必须在session关闭之前创建出来.
	 * 		session关闭之后，数据库断开了，此后就不能执行sql.
	 * 		结论：延迟加载对象，必须在session关闭之前，先初始化一下
	 */
	@Test
	public void testa() {
		Session session = HibernateUtil.getSession();
		//		Person person = (Person) session.get(Person.class, 1L);
		Person person = (Person) session.load(Person.class, 1L);
		Hibernate.initialize(person); // 初始化延迟加载对象
		session.close();
		System.out.println(person);
	}

}
