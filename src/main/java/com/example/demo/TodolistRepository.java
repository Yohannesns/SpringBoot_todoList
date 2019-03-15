package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface TodolistRepository extends CrudRepository<Todolist, Long>{

}