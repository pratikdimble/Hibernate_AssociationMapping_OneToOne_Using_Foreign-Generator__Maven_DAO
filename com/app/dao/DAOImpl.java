package com.app.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.model.HallTicket;
import com.app.model.Student;
import com.app.utility.HibernateUtil;

public class DAOImpl implements DAO {

	@Override
	public void saveDataUsingHallTicket() {
		// TODO Auto-generated method stub
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
			Transaction tx=null;
		//create the objects
				Student stud1=new Student();
				Student stud2=new Student();
					stud1.setStudName("Ganesh");
					stud2.setStudName("Sandip");

				
				HallTicket hall1=new HallTicket();
				HallTicket hall2=new HallTicket();
					hall1.setTicketId(333);hall1.setExam("AIEEE");
					hall2.setTicketId(777);hall2.setExam("AMCAT");
					
			

				//save objs (parent to child)
					stud1.setHall(hall1);hall1.setStud(stud1);
					stud2.setHall(hall2);hall2.setStud(stud2);
					try {
						tx=ses.beginTransaction();
						ses.save(hall1);
						ses.save(hall2);

						tx.commit();
						System.out.println("\n\n\t\tObjects saved Successfully");
						
					} catch (Exception e2) {
						tx.rollback();
						e2.printStackTrace();
						System.out.println("\n\n\t\tObjects not saved Successfully");
					}
						//close the session
					HibernateUtil.closeSession(ses);

	}//save data using hall ticket

	@Override
	public void saveDataUsingStudent() {
		// TODO Auto-generated method stub
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
			Transaction tx=null;
		//create the objects
				Student stud1=new Student();
				Student stud2=new Student();
					stud1.setStudName("Pratik");
					stud2.setStudName("Rohit");

				
				HallTicket hall1=new HallTicket();
				HallTicket hall2=new HallTicket();
					hall1.setTicketId(555);hall1.setExam("GATE");
					hall2.setTicketId(999);hall2.setExam("CAT");
					
			

				//save objs (parent to child)
					stud1.setHall(hall1);hall1.setStud(stud1);
					stud2.setHall(hall2);hall2.setStud(stud2);
					try {
						tx=ses.beginTransaction();
						ses.save(stud1);
						ses.save(stud2);

						tx.commit();
						System.out.println("\n\n\t\tObjects saved Successfully");
						
					} catch (Exception e2) {
						tx.rollback();
						e2.printStackTrace();
						System.out.println("\n\n\t\tObjects not saved Successfully");
					}
						//close the session
					HibernateUtil.closeSession(ses);
	}//save data using student
	@Override
	public void loadDataUsingStudent() {
		Session ses=null;
		//get the session
		ses=HibernateUtil.getSession();
		//prepare the query
			Query q=ses.createQuery("from Student");
			
			//execute the list
			List<Student> list=q.list();
			for(Student stud:list) {
				System.out.println("\t\tParent:: "+stud);
				HallTicket hall=stud.getHall();
				System.out.println("\t\tChild:: "+hall);
			}
			//close the session
			HibernateUtil.closeSession(ses);
	}//loadDataUsingStudent
@Override
public void loadDataUsingHallTicket() {
	Session ses=null;
	//get the session
	ses=HibernateUtil.getSession();
	//prepare the query
		Query q=ses.createQuery("from HallTicket");
		
		//execute the list
		List<HallTicket> list=q.list();
		for(HallTicket hall:list) {
			System.out.println("\t\tChild:: "+hall);
			Student stud=hall.getStud();
			System.out.println("\t\tParent:: "+stud);
		}
		//close the session
		HibernateUtil.closeSession(ses);
	
}//loadDataUsingHallTicket


}//class
