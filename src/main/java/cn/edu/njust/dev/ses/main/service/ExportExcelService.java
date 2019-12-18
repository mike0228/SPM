package cn.edu.njust.dev.ses.main.service;

import com.haue.jobonline.dao.CompetitionSignUpDao;
import com.haue.jobonline.entity.CompetitionSignUp;
import com.haue.jobonline.service.SignUpService;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ExportExcel {
    @Resource
    private CompetitionSignUpDao competitionSignUpDao;
    public List<Map<String, Object>> createExcelRecord(List<CompetitionSignUp> competitionSignUps) {
        List<Map<String, Object>> listmap = new ArrayList<Map<String, Object>>();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sheetName", "sheet1");
        listmap.add(map);
        for (int j = 0; j < competitionSignUps.size(); j++) {
            CompetitionSignUp competitionSignUp=competitionSignUps.get(j);
            Map<String, Object> mapValue = new HashMap<String, Object>();
//            String keys[]    =     {"studentNumber","studentName","studentSex","studentSpecialy","studentClass","time"};//map中的key
            mapValue.put("studentNumber", competitionSignUp.getStudent().getStudentSchoolNum());
            mapValue.put("studentName",competitionSignUp.getStudent().getStudentName());
            mapValue.put("studentSex",competitionSignUp.getStudent().getStudentSex());
            mapValue.put("studentSpecialy",competitionSignUp.getStudent().getStudentSpecialty());
            mapValue.put("studentClass",competitionSignUp.getStudent().getStudentClass());
            mapValue.put("time",competitionSignUp.getSignTime());
            listmap.add(mapValue);
        }
        return listmap;
    }


}

