package Control;

import jakarta.transaction.Transactional;
import java.util.List;
import model.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeController {

    public void create(Employee em) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the employee objects
            session.persist(em);
            // commit transaction
            transaction.commit();
            session.close();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Employee getById(int id) {
        Transaction transaction = null;
        Employee em = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // Get employee with the given id
            em = session.byId(Employee.class).getReference(id);
            Hibernate.initialize(em);
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return em;
    }

    public List<Employee> getAll() {
        Transaction transaction = null;
        List<Employee> ems = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            ems = session.createQuery("FROM Employee", Employee.class).getResultList();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return ems;
    }

    public void update(int id, float salary) {
        Transaction transaction = null;
        Employee em = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            em = session.get(Employee.class, id);
            if (em == null) {
                System.out.println("The given employee wasn't found :c");
            } else {
                em.setSalary(salary);//update salary
                transaction.commit();
                System.out.println("EMployee updated succesfully!! :)");
            }
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Employee em = session.get(Employee.class, id);

            if (em == null) {
                System.out.println("The given employee wasn't found :c");
            } else {
                session.remove(em);
                transaction.commit();
                System.out.println("Employee deleted from db succesfully!! :)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
