package org.task5.student_management_system.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.task5.student_management_system.model.Student;
import org.sqlite.hibernate.dialect.SQLiteDialect;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class StudentDAO {

    private final SessionFactory sessionFactory;

    public StudentDAO() {
        try {
            System.out.println("Creating Hibernate SessionFactory...");
            this.sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Student.class)
                    .buildSessionFactory();
            System.out.println("Hibernate SessionFactory created successfully.");
        } catch (Exception e) {
            System.err.println("Error creating Hibernate SessionFactory: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error creating Hibernate SessionFactory", e);
        }
    }


    public void addStudent(Student student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateStudent(Student student) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteStudent(int studentId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Student student = getStudentById(studentId);
            if (student != null) {
                session.delete(student);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Student getStudentById(int studentId) {
        try (Session session = sessionFactory.openSession()) {
            return session.find(Student.class, studentId);
        }
    }

    public List<Student> getAllStudents() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Student", Student.class).list();
        }
    }

    public void closeSession() {
        sessionFactory.close();
    }
}
