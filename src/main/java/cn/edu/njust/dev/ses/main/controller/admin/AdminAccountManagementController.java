package cn.edu.njust.dev.ses.main.controller.admin;

import cn.edu.njust.dev.ses.main.dto.ResultDTO;
import cn.edu.njust.dev.ses.main.mapper.TeacherMapper;
import cn.edu.njust.dev.ses.main.mapper.UserMapper;
import cn.edu.njust.dev.ses.main.model.Teacher;
import cn.edu.njust.dev.ses.main.model.User;
import cn.edu.njust.dev.ses.main.model.UserExample;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class AdminAccountManagementController {
    private final TeacherMapper teacherMapper;
    private final UserMapper userMapper;

    public AdminAccountManagementController(TeacherMapper teacherMapper, UserMapper userMapper) {
        this.teacherMapper = teacherMapper;
        this.userMapper = userMapper;
    }

    @ResponseBody
    @RequestMapping("/api/json/create_admin_account")
    public ResultDTO createAdminAccount(HttpSession session, @RequestParam String name, @RequestParam String password, @RequestParam String type, @RequestParam(required = false) String teacherName, @RequestParam(required = false) String teacherWorkId){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null|| !sessionUser.getType().equals("associate")){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        User user = new User(null, name, password, type);
        switch(type){
            case "teacher":
                if(StringUtils.isAnyBlank(teacherName, teacherWorkId)){
                    return ResultDTO.errorOf(0, "提供参数“teacherName”和“teacherWorkId”");
                }
                userMapper.insertSelective(user);
                Teacher teacher = new Teacher(user.getUid(), teacherWorkId, teacherName);
                teacherMapper.insert(teacher);
                return ResultDTO.okOf();
            case "associate":
                userMapper.insertSelective(user);
                return ResultDTO.okOf();
            default:
                return ResultDTO.errorOf(0, "“type”仅能是“teacher”或“associate”");
        }
    }

    @ResponseBody
    @RequestMapping("/api/json/obtain_all_accounts")
    public ResultDTO listAllAccounts(HttpSession session, @RequestParam(required = false) String type,
                                     @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null|| !sessionUser.getType().equals("associate")){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        if(type != null && !StringUtils.equalsAny(type, "teacher", "student", "associate")){
            return ResultDTO.errorOf(0, "“type”仅能是“student”、“teacher”或“associate”");
        }

        RowBounds rowBounds = page != null && limit != null ? new RowBounds(limit * (page - 1), limit) : new RowBounds();
        UserExample userExample = new UserExample();
        if(type != null){
            userExample.createCriteria().andTypeEqualTo(type);
        }
        List<User> userList = userMapper.selectByExampleWithRowbounds(userExample, rowBounds);
        for(User user: userList){
            user.setPassword("");
        }
        return ResultDTO.okOf(userList, userMapper.countByExample(userExample));
    }

    @ResponseBody
    @RequestMapping("/api/json/delete_accounts")
    public ResultDTO deleteAccount(HttpSession session, @RequestParam List<Integer> uid){
        User sessionUser = (User) session.getAttribute("logged_in_as");
        Teacher teacherInfo = (Teacher) session.getAttribute("teacher_info");
        if(sessionUser == null|| teacherInfo == null|| !sessionUser.getType().equals("associate")){
            return ResultDTO.errorOf(0, "用户未登录或用户类型不正确。");
        }
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUidIn(uid);

        int count = userMapper.deleteByExample(userExample);
        return count == uid.size()? ResultDTO.okOf(): ResultDTO.errorOf(0, "找不到部分或全部 UID。仅删除了找到的 UID。");
    }
}
