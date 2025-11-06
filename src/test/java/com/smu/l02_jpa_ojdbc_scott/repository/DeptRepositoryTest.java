package com.smu.l02_jpa_ojdbc_scott.repository;

import com.smu.l02_jpa_ojdbc_scott.entity.DetpEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

//빅팩토리
@SpringBootTest
class DeptRepositoryTest {
    @Autowired
    DeptRepository deptRepository;
    @Test
    void findAll() throws Exception{
        List<DetpEntity> depts=deptRepository.findAll();
        System.out.println(depts);
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
        DetpEntity detpEntity = new DetpEntity();
        detpEntity.setId(99);
        detpEntity.setDname("test2");
        detpEntity.setLoc("SEOUL2");
        DetpEntity saveDetp=deptRepository.save(detpEntity);
        System.out.println(saveDetp);
//        System.out.println(deptRepository.findById(99));
        Optional<DetpEntity> deptOpt=deptRepository.findById(99);
        deptOpt.ifPresent(d->{
            System.out.println("deptOpt:"+d);
        });
    }


}