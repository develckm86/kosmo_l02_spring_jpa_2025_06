package com.smu.l02_jpa_ojdbc_scott.contoller;

import com.smu.l02_jpa_ojdbc_scott.entity.EmpEntity;
import com.smu.l02_jpa_ojdbc_scott.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpController {
    //@Autowired
    private final EmpRepository empRepository;
    //@Autowired
    public EmpController(EmpRepository empRepository){ //생성자 주입(final)
        this.empRepository = empRepository;
    }

    @GetMapping("/list.do")
    public String list(Model model){
        List<EmpEntity> emps=empRepository.findAll();
        model.addAttribute("emps",emps);
        //** emps[0].getDetpt()  : 오류 (Proxy 대리 객체가 호출)
        return "/emp/list";
    }
}
