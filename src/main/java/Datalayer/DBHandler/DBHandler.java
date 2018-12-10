package Datalayer.DBHandler;

import Businesslayer.Entities.UserEntity;
import Datalayer.IDBHandler.IDBHandler;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBHandler implements IDBHandler{

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("TestPU");

    public DBHandler() {
    }

    public void addUser(UserEntity user) {

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }catch(Exception e){
            em.getTransaction().rollback();
        }finally {
            em.close();
        }

    }
}
