package cn.edu.njust.dev.ses.main.service;

import cn.edu.njust.dev.ses.main.mapper.GradesEntryMapper;
import cn.edu.njust.dev.ses.main.mapper.StudentMapper;
import cn.edu.njust.dev.ses.main.model.GradesEntry;
import cn.edu.njust.dev.ses.main.model.GradesEntryExample;
import cn.edu.njust.dev.ses.main.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    GradesEntryMapper gradesEntryMapper;

    public void insertStudentRecordAndUpdateGradesEntry(Student student){
        studentMapper.insertSelective(student);
        GradesEntryExample gradesEntryExample = new GradesEntryExample();
        gradesEntryExample.createCriteria().andIdNoEqualTo(student.getIdNo());
        GradesEntry gradesEntry = new GradesEntry();
        gradesEntry.setStudentId(student.getStudentId());
        gradesEntryMapper.updateByExampleSelective(gradesEntry, gradesEntryExample);
    }

}
