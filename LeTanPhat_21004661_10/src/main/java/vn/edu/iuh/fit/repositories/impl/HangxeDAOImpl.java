package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Hangxe;
import vn.edu.iuh.fit.repositories.HangxeDAO;

import java.util.List;

public class HangxeDAOImpl implements HangxeDAO {
    private EntityManager em;
    private EntityTransaction et;

    public HangxeDAOImpl() {
        em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = em.getTransaction();
    }
    @Override
    public Hangxe findById(int id) {
        return em.find(Hangxe.class, id);
    }

    @Override
    public Hangxe findByTenHangXe(String hangXe) {
        String query = "SELECT h FROM Hangxe h WHERE h.tenhang LIKE :tenHangXe";
        return em.createQuery(query, Hangxe.class).setParameter("tenHangXe", "%" + hangXe + "%").getSingleResult();
    }

    @Override
    public List<Hangxe> findAll() {
        String query = "SELECT h FROM Hangxe h";
        return em.createQuery(query, Hangxe.class).getResultList();
    }
}
