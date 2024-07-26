package com.example.todo_api.service;

import com.example.todo_api.dao.TodoRepository;
import com.example.todo_api.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }

    public Todo updateTodo(Todo todo, int id) {
        Todo oldTodo = getTodoById(id);
        oldTodo = todo;
        return todoRepository.save(oldTodo);
    }

    public void deleteTodoById(int id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> getAll() {
        return (List<Todo>) todoRepository.findAll();
    }

    public List<Todo> findByValidated(boolean validated) {
        return todoRepository.findByValidated(validated);
    }

}
