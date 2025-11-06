package com.smu.l02_jpa_ojdbc_scott.repository;

import com.smu.l02_jpa_ojdbc_scott.entity.DetpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//CrudRepositroy : 심플
//JpaRepositrory : 구체적 (패징)
@Repository
public interface DeptRepository extends JpaRepository<DetpEntity,Integer> {
    //메소드 쿼리
    List<DetpEntity> findAllByOrderByIdDesc();
    //loc 부서위치 부서를 조회 SELECT * FROM dept WHERE loc=?
    List<DetpEntity> findByLoc(String loc);
    //부서이름과 부서위치가 같은  SELECT * FROM dept WHERE loc=? AND dname=?
    List<DetpEntity> findByLocAndDname(String loc, String dname);



}
