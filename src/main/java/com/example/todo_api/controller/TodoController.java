package com.example.todo_api.controller;

import com.example.todo_api.entity.Todo;
import com.example.todo_api.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodos() {
        return ResponseEntity.ok(todoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        Todo todo1 = todoService.createTodo(todo);
        return ResponseEntity.ok(todo1);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo, @PathVariable("id") int id) {
        todoService.updateTodo(todo, id);
        return ResponseEntity.ok(todo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable("id") int id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") int id) {
        return ResponseEntity.ok(todoService.getTodoById(id));
    }

    @GetMapping("/all-validated")
    public ResponseEntity<List<Todo>> getAllValidatedTodos() {
        return ResponseEntity.ok(todoService.findByValidated(true));
    }

    @GetMapping("/all-notValidated")
    public ResponseEntity<List<Todo>> getAllNotValidatedTodos() {
        return ResponseEntity.ok(todoService.findByValidated(false));
    }


}
