package com.example.To_Do_application.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.example.To_Do_application.Repository.TodoRepository;
import com.example.To_Do_application.Model.Todo;
import com.example.To_Do_application.Model.Todo.Priority;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<Todo> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public Todo updateTodo(Long id, Todo updatedTodo) {
        return todoRepository.findById(id).map(todo -> {
            todo.setTitle(updatedTodo.getTitle());
            todo.setDescription(updatedTodo.getDescription());
            todo.setCompleted(updatedTodo.isCompleted());
            return todoRepository.save(todo);
        }).orElseThrow(() -> new RuntimeException("Todo not found"));
    }

    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

    public List<Todo> getByCompleted(boolean completed) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByCompleted'");
    }

    public List<Todo> getByPriority(Priority priority) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByPriority'");
    }

    public List<Todo> getByUserId(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getByUserId'");
    }
    public Page<Todo> getAllTodos(org.springframework.data.domain.Pageable pageable) {
        return todoRepository.findAll(pageable);
    }

}
