package org.launchcode.spaday.controllers;

import org.launchcode.spaday.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("/add")
    public String displayAddUserForm() {
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, String verify, Errors errors) {
        model.addAttribute(new User());
        model.addAttribute("errors", errors);
        if(errors.hasErrors() ){
            model.addAttribute("error", "Passwords do not match");
            return "user/add";
        }
        if (user.getPassword().equals(verify)) {
           return "user/index";
        }
        return String.valueOf(user);
    }


}
