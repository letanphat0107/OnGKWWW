package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "hangxe")
public class Hangxe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MAHANGXE", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "TENHANG", length = 50)
    private String tenhang;

    @Size(max = 50)
    @Column(name = "QUOCGIA", length = 50)
    private String quocgia;

    @Size(max = 50)
    @Column(name = "MOTA", length = 50)
    private String mota;

    public Hangxe() {
    }

    public Hangxe(Integer id, String tenhang, String quocgia, String mota) {
        this.id = id;
        this.tenhang = tenhang;
        this.quocgia = quocgia;
        this.mota = mota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenhang() {
        return tenhang;
    }

    public void setTenhang(String tenhang) {
        this.tenhang = tenhang;
    }

    public String getQuocgia() {
        return quocgia;
    }

    public void setQuocgia(String quocgia) {
        this.quocgia = quocgia;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

}