package cn.edu.njust.dev.ses.main.service;

import cn.edu.njust.dev.ses.main.mapper.UserMapper;
import cn.edu.njust.dev.ses.main.mapper.UserSessionMapper;
import cn.edu.njust.dev.ses.main.model.User;
import cn.edu.njust.dev.ses.main.model.UserSession;
import cn.edu.njust.dev.ses.main.model.UserSessionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserSessionMapper userSessionMapper;

    public User getUidByToken(String token){
        UserSessionExample example = new UserSessionExample();
        example.createCriteria().andTokenEqualTo(token);
        List<UserSession> list = userSessionMapper.selectByExample(example);
        if(list.isEmpty()) return null;
        UserSession session = list.get(0);
        if(session.getExpires().after(new Date())){
            userSessionMapper.deleteByPrimaryKey(session.getSessionId());
            return null;
        }
        return userMapper.selectByPrimaryKey(session.getUid());
    }

    public void invalidateToken(String token){
        UserSessionExample example = new UserSessionExample();
        example.createCriteria().andTokenEqualTo(token);
        userSessionMapper.deleteByExample(example);
    }
    public void invalidateAllTokensFor(Integer uid){
        UserSessionExample example = new UserSessionExample();
        example.createCriteria().andUidEqualTo(uid);
        userSessionMapper.deleteByExample(example);
    }
    public void registerToken(UserSession token){
        userSessionMapper.insertSelective(token);
    }
}
