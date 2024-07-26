package com.example.todo_api.dao;

import com.example.todo_api.entity.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
    List<Todo> findByValidated(boolean validated);
}
