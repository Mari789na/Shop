package com.example.springsecurityapplication.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springsecurityapplication.models.Person;
import com.example.springsecurityapplication.repositories.PersonRepository;

@Controller
public class ListController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/admin/user/list")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String getUsers(Model model) {
        List<Person> users = personRepository.findAll();
        model.addAttribute("users", users);
        return "list";
    }

}