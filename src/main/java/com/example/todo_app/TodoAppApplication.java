package com.example.todo_app;

import com.example.todo_app.entity.Todo;
import com.example.todo_app.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodoAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(TodoAppApplication.class, args);
    }

    // アプリ起動時に自動で初期データをDBに登録する仕組み
    @Bean
    public CommandLineRunner initData(TodoRepository repository) {
        return (args) -> {
            // テスト用データを3件登録してみる
            repository.save(new Todo("Javaの勉強をする", false));
            repository.save(new Todo("Spring Bootを動かす", true));
            repository.save(new Todo("ToDoアプリを完成させる", false));
        };
    }
}