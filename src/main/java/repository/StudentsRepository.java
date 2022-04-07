package repository;

import models.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentsRepository implements Irepository<Student,Integer>{
    private EntityManagerFactory entityManagerFactory;
    private final EntityManager entityManager;

    public StudentsRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("students");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Student entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Student entity) {
        entityManager.getTransaction().begin();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Student findById(Integer id ) {
        return entityManager.find(Student.class, id );
    }

    @Override
    public void delete(Student entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Student> findAll() {
        return entityManager.createQuery("from Student").getResultList();
    }

    @Override
    public void deleteAll() {
        List<Student> studentList = findAll();
        studentList.forEach(this::delete);
    }
}
