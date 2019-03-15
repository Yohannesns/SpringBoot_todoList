package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    TodolistRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Todolist todolist = new Todolist("drive", "Going to car");
        repository.save(todolist);

        todolist = new Todolist("eat", " going to restaurant");
        repository.save(todolist);

        todolist = new Todolist("Study", "go to library");
        repository.save(todolist);
    }
}