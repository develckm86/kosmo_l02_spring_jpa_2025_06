package com.smu.l02_jpa_ojdbc_scott.repository;

import com.smu.l02_jpa_ojdbc_scott.entity.DeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//CrudRepositroy : 심플
//JpaRepositrory : 구체적 (패징)
@Repository
public interface DeptRepository extends JpaRepository<DeptEntity,Integer> {
    //메소드 쿼리
    List<DeptEntity> findAllByOrderByIdDesc();
    //loc 부서위치 부서를 조회 SELECT * FROM dept WHERE loc=?
    List<DeptEntity> findByLoc(String loc);
    //부서이름과 부서위치가 같은  SELECT * FROM dept WHERE loc=? AND dname=?
    List<DeptEntity> findByLocAndDname(String loc, String dname);
    //* 와일드카드 sql
    //JPQL : 엔터티(자바객체) 기반 쿼리
    //findAll => @query
    @Query(value = "SELECT d FROM DeptEntity d ORDER BY d.id ASC")
    List<DeptEntity> getAll();
    //JPQL prepareStatement  :변수명
    @Query(value = "SELECT d FROM DeptEntity d WHERE d.dname=:dname")
    List<DeptEntity> getByDname(@Param(value = "dname") String  name);

    @Query(value = "SELECT SUM(d.id) FROM DeptEntity d")
    int getSumById();
    //DBA DB튜닝 => JPQL에서 제공되지 않는 각 데이터베이스 전용 쿼리 (페이징)
    @Query(nativeQuery = true, value = "SELECT * FROM DEPT WHERE LOC=:loc")
    List<DeptEntity> nativeGetByLoc(String loc);
}
