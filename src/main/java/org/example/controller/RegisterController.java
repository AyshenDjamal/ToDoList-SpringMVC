package org.example.controller;

import jakarta.servlet.http.HttpSession;
import org.example.model.UserModel;
import org.example.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {



    @GetMapping("/")
    public ModelAndView showRegister(){
        return new ModelAndView("register");
    }

    @PostMapping("/register")
    public ModelAndView doRegister(@RequestParam String fullName,
                                   @RequestParam String email,
                                   @RequestParam String password, HttpSession session){
        UserModel userModel = new UserModel(fullName, email, password);

        if (UserRepository.existsByEmail(email)){
            ModelAndView mv = new ModelAndView("register");
            mv.addObject("error", "This account already exists. Please log in");
            return mv;
        }

        UserRepository.insertUser(userModel);
        session.setAttribute("user", fullName);
        return new ModelAndView("redirect:/login");
    }

}
