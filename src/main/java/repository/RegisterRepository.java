package repository;

import models.Register;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class RegisterRepository implements Irepository<Register,Integer>{
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public RegisterRepository() {
        entityManagerFactory = Persistence.createEntityManagerFactory("students");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void save(Register entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Register entity) {
        entityManager.getTransaction().begin();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public Register findById(Integer id ) {
        return entityManager.find(Register.class, id );
    }

    @Override
    public void delete(Register entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Register> findAll() {
        return entityManager.createQuery("from Register").getResultList();
    }

    @Override
    public void deleteAll() {
        List<Register> registerList = findAll();
        registerList.forEach(this::delete);
    }
}
