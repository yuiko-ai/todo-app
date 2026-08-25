package com.example.todo_app.controller;

import com.example.todo_app.entity.Todo;
import com.example.todo_app.repository.TodoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "index";
    }

    // 追加
    @PostMapping("/add")
    public String addTodo(@RequestParam("title") String title){
        Todo newTodo = new Todo(title, false); 

        todoRepository.save(newTodo);

        return "redirect:/";
    }

    // 更新
    @PostMapping("toggle/{id}")
    public String toggleTodo(@PathVariable("id") Long id){
        // System.out.println("=== toggleTodoが呼ばれました！ 受け取ったID: " + id + " ===");
        todoRepository.findById(id).ifPresent(todo -> {
            todo.setCompleted(!todo.isCompleted());
            todoRepository.save(todo);
        });
        return "redirect:/";
    }

    // 削除
    @PostMapping("delete/{id}")
    public String deleteTodo(@PathVariable("id") Long id){
        todoRepository.findById(id).ifPresent(todo -> {
            todoRepository.deleteById(id);
        });

        return "redirect:/";
    }
}