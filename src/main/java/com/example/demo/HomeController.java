package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    TodolistRepository todolistRepository;

    @RequestMapping("/")
    public String listTodolists(Model model){
        model.addAttribute("todolists", todolistRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String todolistForm(Model model){
        model.addAttribute("todolist", new Todolist());
        return "todolistform";
    }
    @PostMapping("/process")
    public String processForm(@Valid Todolist todolist, BindingResult result){
        if (result.hasErrors()){
            return "todolistform";
        }
        todolistRepository.save(todolist);
        return "redirect:/";
    }
    @RequestMapping("/details/{id}")
    public String showTodolist(@PathVariable("id") long id, Model model){
        model.addAttribute("todolist", todolistRepository.findById(id).get());
        return "show";
    }
    @RequestMapping("/update/{id}")
    public String updateTodolist(@PathVariable("id") long id, Model model){
        model.addAttribute("todolist", todolistRepository.findById(id).get());
        return "todolistform";
    }
    @RequestMapping("/delete/{id}")
    public String delTodolist(@PathVariable("id") long id){
        todolistRepository.deleteById(id);
        return "redirect:/";
    }
}