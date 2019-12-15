package cn.edu.njust.dev.ses.main.service;

import cn.edu.njust.dev.ses.main.mapper.GradesEntryMapper;
import cn.edu.njust.dev.ses.main.model.GradesEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class StudentService {
    final
    GradesEntryMapper gradesEntryMapper;

    public StudentService(GradesEntryMapper gradesEntryMapper) {
        this.gradesEntryMapper = gradesEntryMapper;
    }

    public void insert(int student_id, int grades) {

    }

    public void uploadEntryGrades(int student_id, int grades) {
        GradesEntry gradesEntry = new GradesEntry();
        gradesEntry.setEid(student_id);
        gradesEntry.setGid(student_id);
        gradesEntry.setUid(student_id);
        gradesEntry.setGrades(grades);
        gradesEntry.setIsApproved(false);
        gradesEntry.setMaxGrades(grades);
        gradesEntryMapper.insert(gradesEntry);
    }
}
