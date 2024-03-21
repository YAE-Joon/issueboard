package board.issue.controller;

import board.issue.entity.Users;
import board.issue.entity.dto.UsersDTO;
import board.issue.service.UserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @GetMapping("/login")
    public String loginDTO(@ModelAttribute("usersDTO")UsersDTO user){
        return"users/login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("usersDTO")UsersDTO user, BindingResult bindingResult, HttpServletResponse response){
        if(bindingResult.hasErrors()){
            return "users/login";
        }
        Users loginUser = userService.login(user.getUserId(), user.getPassword());
        if(loginUser==null){
            bindingResult.reject("loginFail","아이디 또는 비밀번호가 일치하지 않습니다.");
            return "users/login";
        }
        Cookie idCookie = new Cookie("id", String.valueOf(loginUser.getId()));
        response.addCookie(idCookie);

        return "redirect:/";
    }


    @PostMapping("/logout")
    public String logout(HttpServletResponse response,String id){
        Cookie cookie = new Cookie("id",null);
        cookie.setMaxAge(0);
        response.addCookie(cookie);
        return "redirect:/";
    }
    @GetMapping("/home")
    public String homeLogin(@CookieValue(name ="id",required = false)Long id, Model model){
        if(id==null){
            return "home";
        }
        Users loginUser = userService.findById(id);
        if(loginUser==null){
            return "home";
        }else{
            model.addAttribute("users",loginUser);
            return "loginHome";
        }
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
