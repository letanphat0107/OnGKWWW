package vn.edu.iuh.fit.repositories;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.enums.Role;

import java.util.List;

public class CandidateRepo {
    EntityManager em;
    EntityTransaction et;

    public CandidateRepo() {
        em = Persistence.createEntityManagerFactory("GKCan").createEntityManager();
        et = em.getTransaction();
    }

    public List<Candidate> findAll() {
        return em.createNamedQuery("Candidate.findAll", Candidate.class).getResultList();
    }

    public Candidate findById(int id) {
        return em.find(Candidate.class, id);
    }

    public List<Candidate> findDevByCompany(String company) {
        List<Candidate> lst = em.createNamedQuery("Candidate.findDevByCompany", Candidate.class).setParameter("companyName", company).getResultList();
        lst.forEach(candidate -> {
            System.out.println(candidate.getExperiences().get(0).getRole());
        });
        return lst;
    }
}
