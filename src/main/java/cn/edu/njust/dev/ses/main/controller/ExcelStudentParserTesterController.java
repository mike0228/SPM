package cn.edu.njust.dev.ses.main.controller;

import cn.edu.njust.dev.ses.main.dto.StudentDTO;
import cn.edu.njust.dev.ses.main.mapper.StudentMapper;
import cn.edu.njust.dev.ses.main.mapper.UserMapper;
import cn.edu.njust.dev.ses.main.model.Student;
import cn.edu.njust.dev.ses.main.util.excelparser.ExcelUniversalParser;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

@Controller
public class ExcelStudentParserTesterController {
    private final UserMapper userMapper;
    private final StudentMapper studentMapper;

    public ExcelStudentParserTesterController(UserMapper userMapper, StudentMapper studentMapper) {
        this.userMapper = userMapper;
        this.studentMapper = studentMapper;
    }


    @GetMapping("/test/test_student")
    public String test(){
        return "test-xslx-upload";
    }
    @GetMapping("/test/test_student2")
    public String test2(){
        return "test-xslx-upload";
    }
    @PostMapping("/importer/student")
    @ResponseBody
    public List<StudentDTO> importStudentList(HttpServletRequest request, @RequestParam("xsl-file") MultipartFile file){
        List<StudentDTO> result = null;
        try{
            InputStream in = file.getInputStream();
            ExcelUniversalParser<StudentDTO> eup = new ExcelUniversalParser<>();
            result = eup.parseFrom(in, StudentDTO.class);
            for(StudentDTO item: result){
                Student student = new Student();
                BeanUtils.copyProperties(item, student);
                studentMapper.insertSelective(student);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException ignored) {
        }
        return result;
    }
}
