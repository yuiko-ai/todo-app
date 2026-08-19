package com.example.todo_app.controller;

import com.example.todo_app.entity.Todo;
import com.example.todo_app.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.model;
import odg.springframework.web.bind.annotation.*;

@Controller
public class TodoController{

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    // 一覧表示
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("todos", todoRepository.findAll());
        model.addAttribute("newTodo", new Todo());
        return "index";
    }

    
}