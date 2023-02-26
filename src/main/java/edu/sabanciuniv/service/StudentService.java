package edu.sabanciuniv.service;

import edu.sabanciuniv.model.Student;
import edu.sabanciuniv.repository.CrudRepository;
import edu.sabanciuniv.utility.EntityManagerUtils;
import jakarta.persistence.EntityManager;

import java.util.List;

public class StudentService implements CrudRepository<Student> {
    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.createQuery("SELECT c FROM Student c", Student.class).getResultList();
    }

    @Override
    public Student find(int id) {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student Student) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(Student);
            entityManager.getTransaction().commit();
            System.out.println("Student is saved!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void delete(Student Student) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            entityManager.getTransaction().begin();
            entityManager.remove(Student);
            entityManager.getTransaction().commit();
            System.out.println("Student is deleted!");
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void update(Student object, int id) {

    }
}
