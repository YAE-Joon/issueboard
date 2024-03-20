package board.issue.controller;

import board.issue.entity.Users;
import board.issue.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String login(){
        return"users/login";
    }

    @GetMapping("/addUser")
    public String addUser(@ModelAttribute("users") Users users){
        return"users/addUser";
    }

    @PostMapping("/addUser")
    public String save(@Valid @ModelAttribute Users users, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/users/addUser";
        }else{
            userService.join(users);
            return "redirect:/";
        }
    }



}
