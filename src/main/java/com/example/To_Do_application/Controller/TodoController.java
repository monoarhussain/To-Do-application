package com.example.To_Do_application.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import com.example.To_Do_application.Service.TodoService;
import com.example.To_Do_application.Model.Todo;
import com.example.To_Do_application.Model.Todo.Priority;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.createTodo(todo);
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
    @GetMapping("/filter")
    public List<Todo> filterByCompletion(@RequestParam boolean completed) {
        return todoService.getByCompleted(completed);
    }

    @GetMapping("/priority")
    public List<Todo> filterByPriority(@RequestParam Priority priority) {
        return todoService.getByPriority(priority);
    }
    @GetMapping("/user/{userId}")
    public List<Todo> getTodosByUser(@PathVariable String userId) {
        return todoService.getByUserId(userId);
    }
    @GetMapping("/paged")
    public Page<Todo> getPagedTodos(@RequestParam int page,
                                    @RequestParam int size,
                                    @RequestParam String sortBy) {
        return todoService.getAllTodos(PageRequest.of(page, size, Sort.by(sortBy)));
    }


}
