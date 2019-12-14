package cn.edu.njust.dev.ses.main.mapper;

import cn.edu.njust.dev.ses.main.model.User;

public interface AccountExtendMapper {
    User findThroughID(String id_no);
}
