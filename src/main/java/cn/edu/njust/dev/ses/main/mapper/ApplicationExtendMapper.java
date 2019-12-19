package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.ApplicationExample;
import cn.edu.njust.dev.ses.main.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApplicationExtendMapper {
    List<Student> getStudentBasedOnApplicationExample(ApplicationExample example);
}
