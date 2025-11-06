package com.smu.l02_jpa_ojdbc_scott.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

//spring-jpa (jpa 객체를 관리하는 팩토리가 따로 존재)
@Entity
@Table(name = "DEPT")
public class DetpEntity {
    @Id
    @Column(name = "deptno")
    private int id;
    private String dname;
    private String loc;

    @Override
    public String toString() {
        return "DetpEntity{" +
                "id=" + id +
                ", dname='" + dname + '\'' +
                ", loc='" + loc + '\'' +
                "}\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }
}
