package studentmanager.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import studentmanager.domain.Faculty;

import studentmanager.utils.HibernateUtils;

import java.util.List;

public class FacultyDAO {

    private Transaction transaction = null;

    public void addFaculty(Faculty faculty) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(faculty);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public Faculty getFaculty (Integer id) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Faculty faculty = session.find(Faculty.class, id);
            session.close();
            return faculty;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void removeFaculty (Faculty faculty) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(faculty);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }

    }
    public void updateFaculty (Faculty faculty) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(faculty);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

    public List<Faculty> getFacultyList (){
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            List<Faculty> faculties = session.createQuery("from Faculty",Faculty.class).list();
            return faculties;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
