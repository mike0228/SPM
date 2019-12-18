package cn.edu.njust.dev.ses.main.service;

import cn.edu.njust.dev.ses.main.dto.GradesEntryDTO;
import cn.edu.njust.dev.ses.main.dto.StudentDTO;
import cn.edu.njust.dev.ses.main.listener.SessionCollectionListener;
import cn.edu.njust.dev.ses.main.model.User;
import cn.edu.njust.dev.ses.main.util.TempStorageObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class ScheduledTasksService {
    @Scheduled(fixedRate = 5000000)
    public void clearUploadedData(){
        for(HttpSession session : SessionCollectionListener.getList()){
            User user = (User) session.getAttribute("logged_in_as");
            if(user != null){
                if(user.getType().equals("teacher")){
                    TempStorageObject tempStorageObject = (TempStorageObject<List<GradesEntryDTO>>) session.getAttribute("last_result_grades_import");
                    TempStorageObject tempStorageObject1 = (TempStorageObject<List<StudentDTO>>) session.getAttribute("last_result_student_import");
                    if(tempStorageObject != null && tempStorageObject.getCreationDate().getTime() - new Date().getTime() > 1000 * 3600){
                        session.removeAttribute("last_result_grades_import");
                    }
                    if(tempStorageObject1 != null && tempStorageObject1.getCreationDate().getTime() - new Date().getTime() > 1000 * 3600){
                        session.removeAttribute("last_result_student_import");
                    }
                }
                else if(user.getType().equals("associate")){
                    TempStorageObject tempStorageObject = (TempStorageObject<List<GradesEntryDTO>>) session.getAttribute("last_select_rank_import");
                    if(tempStorageObject != null && tempStorageObject.getCreationDate().getTime() - new Date().getTime() > 1000 * 3600){
                        session.removeAttribute("last_select_rank_import");
                    }
                }
            }
        }
    }
}
