package com.rajesh.dao;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rajesh.model.Student;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getAllStudents() {
        Session currentSession = sessionFactory.getCurrentSession();
       List<Student> bb = currentSession.createQuery("FROM Student", Student.class).getResultList();
        System.out.println("dao "+bb);
        return bb;
    }

    @Override
    public Student getStudentById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Student.class, id);
    }

    @Override
    public void addStudent(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(student);
    }

    @Override
    public void deleteStudent(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student student= currentSession.get(Student.class, id);
        if (student != null) {
            currentSession.delete(student);
        }
    }
}
