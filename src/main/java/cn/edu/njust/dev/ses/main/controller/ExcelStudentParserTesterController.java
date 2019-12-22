package cn.edu.njust.dev.ses.main.controller;

import cn.edu.njust.dev.ses.main.dto.DistributionShowcaseDTO;
import cn.edu.njust.dev.ses.main.dto.StatsDTO;
import cn.edu.njust.dev.ses.main.dto.StudentDTO;
import cn.edu.njust.dev.ses.main.mapper.GradesEntryAdvancedMapper;
import cn.edu.njust.dev.ses.main.mapper.StudentExtendMapper;
import cn.edu.njust.dev.ses.main.mapper.UserMapper;
import cn.edu.njust.dev.ses.main.model.DetailedGradesEntryExample;
import cn.edu.njust.dev.ses.main.util.excelparser.ExcelUniversalParser;
import org.jetbrains.annotations.TestOnly;
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
import java.util.List;

@Controller
@TestOnly
public class ExcelStudentParserTesterController {
    private final UserMapper userMapper;
    private final GradesEntryAdvancedMapper gradesEntryAdvancedMapper;
    private final StudentExtendMapper studentExtendMapper;

    public ExcelStudentParserTesterController(UserMapper userMapper, GradesEntryAdvancedMapper gradesEntryAdvancedMapper, StudentExtendMapper studentExtendMapper) {
        this.userMapper = userMapper;
        this.gradesEntryAdvancedMapper = gradesEntryAdvancedMapper;
        this.studentExtendMapper = studentExtendMapper;
    }


    @GetMapping("/test/test_student")
    public String test(){
        return "test-xslx-upload";
    }
    @ResponseBody
    @GetMapping("/test/test-mapper")
    public List<DistributionShowcaseDTO> test3(){
        DetailedGradesEntryExample example = new DetailedGradesEntryExample();
        return gradesEntryAdvancedMapper.getGradesDistributionByExample(example);
    }
    @ResponseBody
    @GetMapping("/test/test-mapper2")
    public List<StatsDTO> test4(){
        return gradesEntryAdvancedMapper.countByDetailedExampleWithGroupByCCFEvent(new DetailedGradesEntryExample());
    }
    @ResponseBody
    @GetMapping("/test/test-mapper3")
    public List<String> test5(){
        return studentExtendMapper.getAllAvailableInstitutes();
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
}
