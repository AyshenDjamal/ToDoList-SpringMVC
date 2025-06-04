package org.example.controller;

import jakarta.servlet.http.HttpSession;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public ModelAndView showLogin(){
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView doLogin(@RequestParam String email,
                                @RequestParam String password, HttpSession session){
        if(UserRepository.existsByEmailAndPassword(email, password)){
            Integer userID = UserRepository.getUserIdByEmail(email);
            session.setAttribute("userID", userID);
            return new ModelAndView("redirect:/home");
        }
        ModelAndView mv = new ModelAndView("login");
        mv.addObject("error", "Incorrect email or password. Please try again");
        return mv;
    }

}
