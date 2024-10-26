package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Candidate;
import vn.edu.iuh.fit.repositories.CandidateRepo;

import java.util.List;

public class CandidateService {
    private final CandidateRepo candidateRepo;

    public CandidateService() {
        candidateRepo = new CandidateRepo();
    }

    public List<Candidate> findAll() {
        return candidateRepo.findAll();
    }

    public Candidate findById(int id) {
        return candidateRepo.findById(id);
    }

    public List<Candidate> findDevByCompany(String company) {
        return candidateRepo.findDevByCompany(company);
    }
}
