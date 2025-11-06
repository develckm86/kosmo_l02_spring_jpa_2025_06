package com.smu.l02_jpa_ojdbc_scott.contoller;

import com.smu.l02_jpa_ojdbc_scott.entity.DetpEntity;
import com.smu.l02_jpa_ojdbc_scott.repository.DeptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DeptController {
    @Autowired
    private DeptRepository deptRepository;

    @GetMapping("/list.do")
    public String list(Model model){
        List<DetpEntity> depts=deptRepository.findAll();
        model.addAttribute("depts",depts);
        return "/dept/list";
    }
}
