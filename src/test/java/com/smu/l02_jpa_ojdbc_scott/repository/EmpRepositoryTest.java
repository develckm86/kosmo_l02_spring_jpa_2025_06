package com.smu.l02_jpa_ojdbc_scott.repository;

import com.smu.l02_jpa_ojdbc_scott.entity.EmpEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest //스프링 테스트 필수
class EmpRepositoryTest {
    @Autowired
    private EmpRepository empRepository;
    @Test
    void findAll() throws Exception{
        System.out.println(empRepository.findAll());
    }
    @Test
    void findById() throws Exception{
        Optional<EmpEntity> empOpt=empRepository.findById((short)5555);
        System.out.println(empOpt.isPresent());
//        empOpt.ifPresent((emp)->{
//            System.out.println(emp);
//        });
        empOpt.ifPresentOrElse(System.out::println,()->{
            System.out.println("5555 사원 없음");
        });
    }
    @Test
    void deleteById() throws Exception{
        //삭제 전에 존재하는 지 확인 후 삭제
        empRepository.deleteById((short)5555);
    }
}