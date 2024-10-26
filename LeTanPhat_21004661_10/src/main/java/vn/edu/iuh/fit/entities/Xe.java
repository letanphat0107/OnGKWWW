package vn.edu.iuh.fit.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "xe")
public class Xe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "maxe", nullable = false)
    private Integer id;

    @Size(max = 50)
    @Column(name = "tenxe", length = 50)
    private String tenxe;

    @Column(name = "giaxe")
    private Double giaxe;

    @Column(name = "namsanxuat")
    private Integer namsanxuat;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "mahangxe")
    private Hangxe mahangxe;

    public Xe() {
    }

    public Xe(String tenxe, Double giaxe, Integer namsanxuat) {
        this.tenxe = tenxe;
        this.giaxe = giaxe;
        this.namsanxuat = namsanxuat;
    }

    public Xe(Integer id, String tenxe, Double giaxe, Integer namsanxuat) {
        this.id = id;
        this.tenxe = tenxe;
        this.giaxe = giaxe;
        this.namsanxuat = namsanxuat;
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

    public Hangxe getMahangxe() {
        return mahangxe;
    }

    public void setMahangxe(Hangxe mahangxe) {
        this.mahangxe = mahangxe;
    }

}