package vn.edu.iuh.fit.services.impl;

import vn.edu.iuh.fit.dtos.XeDTO;
import vn.edu.iuh.fit.entities.Hangxe;
import vn.edu.iuh.fit.entities.Xe;
import vn.edu.iuh.fit.repositories.HangxeDAO;
import vn.edu.iuh.fit.repositories.XeDao;
import vn.edu.iuh.fit.repositories.impl.HangxeDAOImpl;
import vn.edu.iuh.fit.repositories.impl.XeDAOImpl;
import vn.edu.iuh.fit.services.XeService;

import java.util.ArrayList;
import java.util.List;

public class XeServiceImpl implements XeService {
    private final XeDao xeDao;
    private final HangxeDAO hangxeDAO;

    public XeServiceImpl() {
        this.xeDao = new XeDAOImpl();
        this.hangxeDAO = new HangxeDAOImpl();
    }
    @Override
    public List<XeDTO> getXeDTOs() {
        List<XeDTO> xeDTOs = new ArrayList<>();
        xeDao.findAll().forEach(xe -> {
            Hangxe hangxe = hangxeDAO.findById(xe.getMahangxe().getId());
            xeDTOs.add(new XeDTO(xe.getId(), xe.getTenxe(), xe.getGiaxe(), xe.getNamsanxuat(), hangxe.getTenhang()));
        });
        return xeDTOs;
    }

    @Override
    public List<XeDTO> getXeDTOByTen(String tenXe) {
        List<XeDTO> xeDTOs = new ArrayList<>();
        xeDao.findByTenXe(tenXe).forEach(xe -> {
            Hangxe hangxe = hangxeDAO.findById(xe.getMahangxe().getId());
            xeDTOs.add(new XeDTO(xe.getId(), xe.getTenxe(), xe.getGiaxe(), xe.getNamsanxuat(), hangxe.getTenhang()));
        });
        return xeDTOs;
    }

    @Override
    public boolean save(XeDTO xe) {
        Hangxe hangxe = hangxeDAO.findByTenHangXe(xe.getTenhangxe());
        Xe xeEntity = new Xe(xe.getTenxe(), xe.getGiaxe(), xe.getNamsanxuat());
        xeEntity.setMahangxe(hangxe);
        return xeDao.save(xeEntity);
    }

    @Override
    public boolean update(XeDTO xe) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public XeDTO getOne(int id) {
        Xe xe = xeDao.findById(id);
        if (xe != null) {
            Hangxe hangxe = hangxeDAO.findById(xe.getMahangxe().getId());
            return new XeDTO(xe.getId(), xe.getTenxe(), xe.getGiaxe(), xe.getNamsanxuat(), hangxe.getTenhang());
        }
        return null;
    }

    @Override
    public List<Hangxe> getAllHangXe() {
        return hangxeDAO.findAll();
    }

}
