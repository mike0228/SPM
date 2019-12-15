package cn.edu.njust.dev.ses.main.controller;

import cn.edu.njust.dev.ses.main.dto.GradesEntryDTO;
import cn.edu.njust.dev.ses.main.service.InspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InspectController {
    @Autowired
    private InspectService inspectService;

    @GetMapping("/test-read-gradesentry")
    public String inspect(Model model){
        List<GradesEntryDTO> gradesEntryDTOS = inspectService.GetByIsApproved();
        model.addAttribute("grandesentry",gradesEntryDTOS);
        return "test-read-gradesentry";
    }
}