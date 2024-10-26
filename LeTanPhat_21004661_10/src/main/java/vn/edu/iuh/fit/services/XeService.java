package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.dtos.XeDTO;
import vn.edu.iuh.fit.entities.Hangxe;

import java.util.List;

public interface XeService {
    public List<XeDTO> getXeDTOs();
    public List<XeDTO> getXeDTOByTen(String tenXe);
    public boolean save(XeDTO xe);
    public boolean update(XeDTO xe);
    public boolean delete(int id);
    public XeDTO getOne(int id);

    public List<Hangxe> getAllHangXe();
}
