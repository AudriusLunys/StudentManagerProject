package studentmanager.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import studentmanager.domain.Module;
import studentmanager.utils.HibernateUtils;

public class ModuleDAO {
    private Transaction transaction = null;

    public void addModule(Module module) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.save(module);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }
    }

    public Module getModule (Integer id) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            Module module = session.find(Module.class, id);
            session.close();
            return module;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public void removeModule(Module module) {
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.delete(module);
            transaction.commit();
            session.close();

        } catch (Exception exception) {
            if (transaction != null) {
                transaction.rollback();
            }
            exception.printStackTrace();
        }

    }
    public void updateModule (Module module) {
        Transaction transaction = null;
        try {
            Session session = HibernateUtils.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.update(module);
            transaction.commit();
        } catch (Exception ex) {
            if(transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        }
    }

}