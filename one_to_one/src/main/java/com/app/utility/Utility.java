package com.app.utility;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.app.entity.Ceo;
import com.app.entity.Company;

public class Utility {
	public static SessionFactory sf()
	 {
		Properties p=new Properties();
		p.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
		p.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/one_to_one_hibernate");
		p.setProperty("hibernate.connection.username", "root");
		p.setProperty("hibernate.connection.password", "root");
		p.setProperty("hibernate.connection.dialect", "org.hibernate.dialect.MySQLDialect");
		
		Configuration con=new Configuration();
		con.setProperties(p);
		con.addAnnotatedClass(Company.class);
		con.addAnnotatedClass(Ceo.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder();
		builder.applySettings(con.getProperties());
		ServiceRegistry sr=builder.build();
		return con.buildSessionFactory(sr);
	}

}
