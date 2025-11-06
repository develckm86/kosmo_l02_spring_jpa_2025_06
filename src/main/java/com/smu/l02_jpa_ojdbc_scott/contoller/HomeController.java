package com.smu.l02_jpa_ojdbc_scott.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//컴포넌트스캐너 : 스프링이 처음 생성된 패키지 하위에 존재하는 컨포넌트를 자동으로 찾아서 관리
//==Singleton
@Controller //컴포넌트(스프링 빈 팩토리(공장)에서 관리하는 객체의 타입)
public class HomeController {
    //스프링 빈팩토리에 생성된 객체를 주입받기
    @Autowired
    private DataSource dataSource; //Conn =new DataSource()
    //객체 지향 문법  => 객체가 필요하면 생성 : 일반적인 흐름
    //객체 지향 문법  => 만들어진 객체 주입  : 제어가 역전 (Inversion of Control , Dependency Injection )

    @GetMapping("/")
    public String index() throws SQLException { //500상태

//        Connection conn=dataSource.getConnection();
//        System.out.println(conn);
//        Statement stmt=conn.createStatement();
//        ResultSet rs=stmt.executeQuery("SELECT * FROM EMP");
//        while (rs.next()){
//            System.out.println(rs.getString(1)+" | "+rs.getString(2)+" | "+rs.getString(3));
//        }
        return "index";
    }
}
