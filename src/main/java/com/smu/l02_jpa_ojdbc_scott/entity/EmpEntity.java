package com.smu.l02_jpa_ojdbc_scott.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
@Table(name = "EMP")
public class EmpEntity {
    @Id
    @Column(name = "EMPNO", nullable = false)
    private Short id;

    @Column(name = "ENAME", length = 10)
    private String ename;

    @Column(name = "JOB", length = 9)
    private String job;

    @Column(name = "MGR")
    private Short mgr;

    @Column(name = "HIREDATE")
    private LocalDate hiredate;

    @Column(name = "SAL", precision = 7, scale = 2)
    private BigDecimal sal;

    @Column(name = "COMM", precision = 7, scale = 2)
    private BigDecimal comm;

    //엔터티 자동완성시 fk가  Entity 로 대신 작성 => 필드로 작성
    @Column(name = "DEPTNO",insertable = false, updatable = false)
    //insertable = false, updatable = false : 참조키를 명시적으로 표현
    private Short deptno;

    //N 사원 : 1 부서 (사원입장에서 부서의 수)
    //FetchType
    //LAZY : 지연조회 (dept 를 조회하면 그때 조회[view,get,toString:지연조회의 트리거])
    //EAGER : 즉시조회 join
    @ManyToOne(fetch = FetchType.LAZY)//EAGER 즉시
    @JoinColumn(name = "DEPTNO") //Table DEPT.deptno
    //SELECT * FROM EMP e LEFT JOIN DEPT d ON e.deptno=d.deptno
    private DeptEntity dept;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @OnDelete(action = OnDeleteAction.RESTRICT)
//    @JoinColumn(name = "DEPTNO")
//    private DeptEntity dept;

}