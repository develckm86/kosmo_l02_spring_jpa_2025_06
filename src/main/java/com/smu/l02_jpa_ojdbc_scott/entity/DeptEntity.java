package com.smu.l02_jpa_ojdbc_scott.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

//lombok : 개발툴의 확장프로그램 get,set,constructor equals toString 과 같은 bean관련된 함수 자동구현
//spring-jpa (jpa 객체를 관리하는 팩토리가 따로 존재)
@Getter@Setter@ToString
//@Data
@Entity
@Table(name = "DEPT")
public class DeptEntity {
    @Id
    @Column(name = "deptno")
    private int id;
    @Column(name = "dname")
    private String dname;
    @Column(name = "loc")
    private String loc;

    //부서 : 사원 = 1 : N
    //List, LinkHashSet
    @OneToMany(mappedBy = "dept", fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<EmpEntity> emps;
//    private List<Entity> emps=new ArrayList<>(); //[]
}
