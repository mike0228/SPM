package cn.edu.njust.dev.ses.main.service;

import cn.edu.njust.dev.ses.main.mapper.*;
import cn.edu.njust.dev.ses.main.model.*;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserSessionMapper userSessionMapper;
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private TeacherMapper teacherMapper;
    @Autowired
    private AccountExtendMapper accountExtendMapper;

    public User getUidByToken(String token){
        UserSessionExample example = new UserSessionExample();
        example.createCriteria().andTokenEqualTo(token);
        List<UserSession> list = userSessionMapper.selectByExample(example);
        if(list.isEmpty()) return null;
        UserSession session = list.get(0);
        if(session.getExpires().before(new Date())){
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

    public boolean logInAs(HttpSession request, User userInfo){
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountEqualTo(userInfo.getAccount().toLowerCase());

        List<User> users = userMapper.selectByExample(userExample);
        User targetUser = users.isEmpty() ? null : users.get(0);
        if(targetUser == null){
            targetUser = accountExtendMapper.findThroughID(userInfo.getAccount());
            if(targetUser == null){
                targetUser = tryToCreateAccountThroughID(userInfo.getAccount(), userInfo.getPassword());
                if(targetUser == null) return false;
            }
        }
        if(!targetUser.getPassword().equals(userInfo.getPassword())){
            return false;
        }
        request.setAttribute("logged_in_as", targetUser);
        if(targetUser.getType().equals("student")){
            StudentExample studentExample = new StudentExample();
            studentExample.createCriteria().andUidEqualTo(targetUser.getUid());
            request.setAttribute("student_info", studentMapper.selectByExample(studentExample));
        }else if(targetUser.getType().equals("teacher")){
            TeacherExample teacherExample = new TeacherExample();
            teacherExample.createCriteria().andUidEqualTo(targetUser.getUid());
            request.setAttribute("teacher_info", teacherMapper.selectByExample(teacherExample));
        }
        return true;
    }

    private User tryToCreateAccountThroughID(String id, String pwd){
        List<Student> result;
        StudentExample studentExample = new StudentExample();
        studentExample.createCriteria().andStudentIdEqualTo(id);
        result = studentMapper.selectByExample(studentExample);
        if(!result.isEmpty()){
            Student student = result.get(0);
            String idNo = student.getIdNo();
            String substring = idNo.substring(id.length() - 1 - 5, id.length() - 1);
            if(!substring.equals(pwd)) return null;
            User user = new User();
            user.setType("student");
            user.setAccount(student.getClassNo());
            user.setPassword(substring);
            userMapper.insertSelective(user);
            Student update = new Student();
            update.setUid(user.getUid());
            studentMapper.updateByExampleSelective(update, studentExample);
            return user;
        }
        return null;
    }
}
