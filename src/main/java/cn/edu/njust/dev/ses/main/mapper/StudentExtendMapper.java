package cn.edu.njust.dev.ses.main.mapper;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentExtendMapper {
    List<String> getAllAvailableInstitutes();
}
