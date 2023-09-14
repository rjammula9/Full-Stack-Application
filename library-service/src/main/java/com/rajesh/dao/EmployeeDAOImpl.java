package com.rajesh.dao;

import com.rajesh.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> getAllEmployees() {
        Session currentSession = sessionFactory.getCurrentSession();
       List<Employee> bb = currentSession.createQuery("FROM Employee", Employee.class).getResultList();
        System.out.println("dao "+bb);
        return bb;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Employee.class, id);
    }

    @Override
    public void addEmployee(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        Session currentSession = sessionFactory.getCurrentSession();
        Employee employee = currentSession.get(Employee.class, id);
        if (employee != null) {
            currentSession.delete(employee);
        }
    }
}
