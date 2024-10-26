package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.Hangxe;

import java.util.List;

public interface HangxeDAO {
    public Hangxe findById(int id);
    public Hangxe findByTenHangXe(String hangXe);
    public List<Hangxe> findAll();
}
