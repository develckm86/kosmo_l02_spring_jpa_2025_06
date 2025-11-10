package com.smu.l02_jpa_ojdbc_scott.repository;

import com.smu.l02_jpa_ojdbc_scott.entity.DeptEntity;
import com.smu.l02_jpa_ojdbc_scott.entity.EmpEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//빅팩토리
@SpringBootTest
class DeptRepositoryTest {
    @Autowired
    DeptRepository deptRepository;
    @Test
    void findAll() throws Exception{
        List<DeptEntity> depts=deptRepository.findAll();
        //System.out.println(depts);
        for(DeptEntity d: depts){
            System.out.println(d);
//            System.out.println(d.getEmps());
//            for(EmpEntity e: d.getEmps()){
//                System.out.println(e);
//            }
        }
    }

    @Test
    void findAllByOrderByIdDesc() {
        System.out.println(deptRepository.findAllByOrderByIdDesc());
    }

    @Test
    void findByLoc() {
        System.out.println(deptRepository.findByLoc("BOSTON"));
    }

    @Test
    void findByLocAndDname() {
        System.out.println(deptRepository.findByLocAndDname("BOSTON","OPERATIONS"));
    }
    @Test
    void save()throws SQLException {
        DeptEntity detpEntity = new DeptEntity();
        detpEntity.setId(99);
        detpEntity.setDname("test2");
        detpEntity.setLoc("SEOUL2");
        DeptEntity saveDetp=deptRepository.save(detpEntity);
        System.out.println(saveDetp);
//        System.out.println(deptRepository.findById(99));
        Optional<DeptEntity> deptOpt=deptRepository.findById(99);
        deptOpt.ifPresent(d->{
            System.out.println("deptOpt:"+d);
        });
    }
    @Test
    void getAll() throws Exception{
        System.out.println(deptRepository.getAll());
    }

    @Test
    void getByDname() {
        System.out.println(deptRepository.getByDname("ACCOUNTING"));
    }

    @Test
    void getSumById() {
        System.out.println(deptRepository.getSumById());
    }

    @Test
    void nativeGetByLoc() {
        System.out.println(deptRepository.nativeGetByLoc("BOSTON"));
    }
}