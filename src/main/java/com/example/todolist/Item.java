package com.example.todolist;

public class Item {
    private Long id;
    private String description;

    public Item(Long id, String description){
        this.id = id;
        this.description = description;
    }

    public Long getId(){
        return id;
    }
    public String getDescription(){
        return description;
    }
}
