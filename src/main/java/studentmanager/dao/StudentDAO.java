package studentmanager.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import studentmanager.domain.Student;
import studentmanager.utils.HibernateUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StudentDAO {

    private Transaction transaction = null;

    public void addStudent(Student student) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public Student getStudent(Integer id) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Student student = session.find(Student.class, id);
            session.close();
            return student;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void removeStudent(Student student) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(student);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }

    }

    public void updateStudent(Student student) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }


     public void listStudents(){
         Transaction transaction = null;
         try {
             Session session = HibernateUtils.getSessionFactory().openSession();
             transaction = session.beginTransaction();
             List students = session.createQuery("FROM Student").list();
             for (Iterator iterator = students.iterator(); iterator.hasNext();){
                 Student student = (Student) iterator.next();
                 System.out.print("First Name: " + student.getFirstName());
                 System.out.print("Last Name: " + student.getLastName());
             }
             transaction.commit();
         }  catch (Exception ex) {
             if (transaction != null) {
                 transaction.rollback();
             }
             ex.printStackTrace();
         }
    }

}



