package studentmanager.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import studentmanager.domain.Group;
import studentmanager.utils.HibernateUtils;

public class GroupDAO {
    private Transaction transaction = null;

    public void addGroup(Group group) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public Group getGroup (Integer id) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Group group = session.find(Group.class, id);
            session.close();
            return group;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void removeGroup (Group group) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(group);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }

    }
    public void updateGroup (Group group) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(group);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }
}

