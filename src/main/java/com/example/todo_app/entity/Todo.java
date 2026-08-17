package com.example.todo_app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "todos")
public class Todo{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    // id
    private long id;
    
    // タイトル
    private String title;

    // 完了フラグ 初期値は未完了(false)
    private Boolean completed = false; 

    // コンストラクタ
    pubulic Todo(){
    }

    public Todo(String title, Boolean completed){
        this.title = title;
        this.completed = completed;
    }

    // ゲッターとセッター
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}