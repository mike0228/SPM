package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.User;

import java.util.List;

public interface AccountExtendMapper {
    User findThroughID(String id_no);
}
