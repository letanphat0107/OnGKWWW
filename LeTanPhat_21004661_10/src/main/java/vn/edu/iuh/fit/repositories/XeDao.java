package vn.edu.iuh.fit.repositories;

import vn.edu.iuh.fit.entities.Xe;

import java.util.List;

public interface XeDao {
    public Xe findById(int id);
    public List<Xe> findByTenXe(String tenXe);
    public List<Xe> findByGiaXe(double giaXe);
    public List<Xe> findAll();
    public boolean save(Xe xe);
    public boolean update(Xe xe);
    public boolean delete(int id);
}
