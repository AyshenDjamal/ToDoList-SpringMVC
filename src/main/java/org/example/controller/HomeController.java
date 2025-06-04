package org.example.controller;

import jakarta.servlet.http.HttpSession;
import org.example.model.TaskModel;
import org.example.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public ModelAndView showHome(HttpSession session) {
        Integer userID = (Integer) session.getAttribute("userID");
        if (userID == null) {
            return new ModelAndView("home");
        }

        List<TaskModel> taskModelList = TaskRepository.getTasksByUserId(userID);
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("tasks", taskModelList);
        return mv;
    }

    @PostMapping("/home")
    public ModelAndView doHome(@RequestParam String description,
                               @RequestParam String deadline, HttpSession session){
        Integer userID = (Integer) session.getAttribute("userID");
        if(userID == null){
            return new ModelAndView("redirect:/login");
        }
        TaskModel taskModel = new TaskModel(description, deadline, userID);
        TaskRepository.insertTasks(taskModel);
       // session.setAttribute("task", description);
        return new ModelAndView("redirect:/home");
    }

}
