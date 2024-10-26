package vn.edu.iuh.fit.dtos;

public class XeDTO {
    private Integer id;
    private String tenxe;
    private Double giaxe;
    private Integer namsanxuat;
    private String tenhangxe;

    public XeDTO() {
    }

    public XeDTO(int id, String tenxe, Double giaxe, Integer namsanxuat, String tenhangxe) {
        this.tenxe = tenxe;
        this.giaxe = giaxe;
        this.namsanxuat = namsanxuat;
        this.tenhangxe = tenhangxe;
        this.id = id;

    }

    public XeDTO(String tenxe, Double giaxe, Integer namsanxuat, String tenhangxe) {
        this.tenxe = tenxe;
        this.giaxe = giaxe;
        this.namsanxuat = namsanxuat;
        this.tenhangxe = tenhangxe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenxe() {
        return tenxe;
    }

    public void setTenxe(String tenxe) {
        this.tenxe = tenxe;
    }

    public Double getGiaxe() {
        return giaxe;
    }

    public void setGiaxe(Double giaxe) {
        this.giaxe = giaxe;
    }

    public Integer getNamsanxuat() {
        return namsanxuat;
    }

    public void setNamsanxuat(Integer namsanxuat) {
        this.namsanxuat = namsanxuat;
    }

    public String getTenhangxe() {
        return tenhangxe;
    }

    public void setTenhangxe(String tenhangxe) {
        this.tenhangxe = tenhangxe;
    }

    @Override
    public String toString() {
        return "XeDTO{" + "id=" + id + ", tenxe=" + tenxe + ", giaxe=" + giaxe + ", namsanxuat=" + namsanxuat + ", mahangxe=" + tenhangxe + '}';
    }
}
