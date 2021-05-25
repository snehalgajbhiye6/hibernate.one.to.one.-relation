package com.app.client;

import java.util.List;
import java.util.Scanner;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.entity.Ceo;
import com.app.entity.Company;
import com.app.utility.Utility;

public class Client {
	Scanner sc=new Scanner(System.in);
	public void save() {
		Session session=Utility.sf().openSession();
		Transaction tr=session.beginTransaction();
		System.out.println("How many ceo do you know");
		int numOfCeo=sc.nextInt();
		for(int i=0;i<numOfCeo;i++) {
			Ceo ceo=new Ceo();
			System.out.println("Enter ceo name ");
			ceo.setName(sc.next());
			
			Company c=new Company();
			System.out.println("Enter company name");
			c.setCname(sc.next());
			
			ceo.setCom(c);
			c.setCeo(ceo);
			
			session.save(c);
			}
			tr.commit();
			if(tr.wasCommitted())
				System.out.println("Saved succesfully");
			else
				System.out.println("Failed ");
		
	}
	
	public void selectAll() {
		Session session=Utility.sf().openSession();
		List<Ceo> list=session.createCriteria(Ceo.class).list();
		for(Ceo ceo:list) {
			System.out.println(ceo);
			System.out.println(" "+ ceo.getCom());
		}
	}
	
	public void update() {
		Session session=Utility.sf().openSession();
		System.out.println("Which row do you want to update");
		int id=sc.nextInt();
		Ceo c=(Ceo) session.get(Ceo.class, id);
		System.out.println("Enter ceo 	name");
		c.setName(sc.next());
		
		System.out.println("Enter company name");
		c.getCom().setCname(sc.next());
		session.update(c);
		session.beginTransaction().commit();
		 Boolean flag=Boolean.TRUE;
		 if(flag)
			 System.out.println("success");
		 else
			 System.out.println("failed");
		
	}
	
	public void delete() {
		Session session=Utility.sf().openSession();
		System.out.println("Which row do you want to delete");
		int id=sc.nextInt();
		Ceo c=(Ceo) session.get(Ceo.class, id);
		 Boolean flag=Boolean.TRUE;
		 session.delete(c);
		 session.beginTransaction().commit();
		 if(flag)
			 System.out.println("success");
		 else
			 System.out.println("failed");
	}
	public static void main(String[] args) {
		Client c=new Client();
		//c.save();
		//c.selectAll();
		//c.update();
		c.delete();
	}

}
