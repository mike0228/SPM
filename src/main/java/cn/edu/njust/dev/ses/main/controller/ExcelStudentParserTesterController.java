package cn.edu.njust.dev.ses.main.controller;

import cn.edu.njust.dev.ses.main.dto.GradesEntryDTO;
import cn.edu.njust.dev.ses.main.dto.StudentDTO;
import cn.edu.njust.dev.ses.main.mapper.UserMapper;
import cn.edu.njust.dev.ses.main.model.GradesEntry;
import cn.edu.njust.dev.ses.main.util.excelparser.ExcelUniversalParser;
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

    public ExcelStudentParserTesterController(UserMapper userMapper) {
        this.userMapper = userMapper;
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
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException ignored) {
        }
        return result;
    }
    @PostMapping("/importer/grades")
    @ResponseBody
    public List<GradesEntryDTO> importGradesEntryList(HttpServletRequest request, @RequestParam("xsl-file") MultipartFile file){
        List<GradesEntryDTO> result = null;
        try{
            InputStream in = file.getInputStream();
            ExcelUniversalParser<GradesEntryDTO> eup = new ExcelUniversalParser<>();
            result = eup.parseFrom(in, GradesEntryDTO.class);
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (InstantiationException | InvocationTargetException | NoSuchMethodException | IllegalAccessException ignored) {
        }
        return result;
    }
}
