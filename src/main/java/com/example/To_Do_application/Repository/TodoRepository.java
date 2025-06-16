package com.example.To_Do_application.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import com.example.To_Do_application.Model.Todo;
import com.example.To_Do_application.Model.Todo.Priority;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByCompleted(boolean completed);
    List<Todo> findByPriority(Priority priority);
public default List<Todo> getAllTodos() {
    return findAll().stream()
        .filter(todo -> !todo.isDeleted())
        .collect(java.util.stream.Collectors.toList());
}

}
