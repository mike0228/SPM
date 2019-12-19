package cn.edu.njust.dev.ses.main.controller.student;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.mapper.StudentMapper;
import cn.edu.njust.dev.ses.main.mapper.UserMapper;
import cn.edu.njust.dev.ses.main.model.Student;
import cn.edu.njust.dev.ses.main.model.StudentExample;
import cn.edu.njust.dev.ses.main.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

public class StudentAccountManagementController {
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping("/api/json/change_userinfo")
    @ResponseBody
    public ResultDTO changeUserInfo(HttpSession session, @RequestParam String phoneNo, @RequestParam String profession, @RequestParam String classNo){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Student studentInfo = (Student) session.getAttribute("student_info");
        if(sessionUser == null|| studentInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentIdEqualTo(studentInfo.getStudentId());

        Student student = new Student();
        student.setPhoneNo(phoneNo);
        student.setProfession(profession);
        student.setClassNo(classNo);

        int result = studentMapper.updateByExampleSelective(student, studentExample);
        return result > 0? ResultDTO.okOf(): ResultDTO.errorOf(0, "找不到账户，请尝试重新登录。");
    }
}
