package cn.edu.njust.dev.ses.main.controller.admin;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.dto.StudentDTO;
import cn.edu.njust.dev.ses.main.mapper.ApplicationMapper;
import cn.edu.njust.dev.ses.main.mapper.CCFEventMapper;
import cn.edu.njust.dev.ses.main.mapper.GradesEntryMapper;
import cn.edu.njust.dev.ses.main.mapper.StudentMapper;
import cn.edu.njust.dev.ses.main.model.Student;
import cn.edu.njust.dev.ses.main.model.Teacher;
import cn.edu.njust.dev.ses.main.model.User;
import cn.edu.njust.dev.ses.main.util.TempStorageObject;
import cn.edu.njust.dev.ses.main.util.excelparser.ExcelUniversalParser;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Controller
public class AdminImporterController {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CCFEventMapper ccfEventMapper;
    @Autowired
    ApplicationMapper applicationMapper;
    @Autowired
    GradesEntryMapper gradesEntryMapper;

    @ResponseBody
    @RequestMapping("/api/json/import_student_via_excel")
    public ResultDTO importStudentThroughExcel(HttpSession session, @RequestParam MultipartFile file){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        List<StudentDTO> result = null;
        try{
            InputStream in = file.getInputStream();
            ExcelUniversalParser<StudentDTO> eup = new ExcelUniversalParser<>();
            result = eup.parseFrom(in, StudentDTO.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return ResultDTO.errorOf(0, String.format("发生异常（%s）", ex.getClass()), ex.getLocalizedMessage());
        }
        TempStorageObject<List<StudentDTO>> tempStorageObject = new TempStorageObject<>();
        tempStorageObject.setData(result);

        tempStorageObject.setId(RandomUtils.nextInt());
        session.setAttribute("last_result", tempStorageObject);
        return ResultDTO.okOf(result);
    }

    @ResponseBody
    @RequestMapping("/api/json/confirm_student_import")
    public ResultDTO confirmStudentImport(HttpSession session, @RequestParam Integer confirmId){
        //TODO
        return null;
    }
}
