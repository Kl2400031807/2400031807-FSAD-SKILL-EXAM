package com.klef.fsad.exam;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Date;

public class ClientDemo {

 public static void main(String[] args) {

  SessionFactory sf = new Configuration().configure().buildSessionFactory();
  Session session = sf.openSession();
  Transaction tx = session.beginTransaction();

  // INSERT RECORD
  CustomerAccount c = new CustomerAccount("Akshaya","Savings Account",
          new Date(),
          "Active");

  session.save(c);
  System.out.println("Record Inserted");

  tx.commit();

  // UPDATE RECORD
  session.beginTransaction();

  CustomerAccount ca = session.get(CustomerAccount.class,1);
  ca.setName("Akshaya Datla");
  ca.setStatus("Updated");

  session.update(ca);

  session.getTransaction().commit();

  System.out.println("Record Updated");

  session.close();
  sf.close();
 }
}