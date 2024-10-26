package vn.edu.iuh.fit.repositories.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.XeDao;

import java.util.List;

public class XeDAOImpl implements XeDao {
    private EntityManager em;
    private EntityTransaction et;

    public XeDAOImpl() {
        em = Persistence.createEntityManagerFactory("JPA_MariaDB").createEntityManager();
        et = em.getTransaction();
    }

    @Override
    public Xe findById(int id) {
        return em.find(Xe.class, id);
    }

    @Override
    public List<Xe> findByTenXe(String tenXe) {
        String query = "SELECT x FROM Xe x WHERE x.tenxe LIKE :tenXe";
        return em.createQuery(query, Xe.class).setParameter("tenXe", "%" + tenXe + "%").getResultList();
    }

    @Override
    public List<Xe> findByGiaXe(double giaXe) {
        return List.of();
    }

    @Override
    public List<Xe> findAll() {
        String query = "SELECT x FROM Xe x";
        return em.createQuery(query, Xe.class).getResultList();
    }

    @Override
    public boolean save(Xe xe) {
        try {
            et.begin();
            em.persist(xe);
            et.commit();
            return true;
        } catch (Exception e) {
            et.rollback();
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Xe xe) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
