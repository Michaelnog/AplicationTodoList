package com.michael.aplicationTodoList.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.michael.aplicationTodoList.models.TaskModel;



public interface TaskRepository extends JpaRepository<TaskModel,UUID> {
    List<TaskModel> findByIdUser(UUID idUser);
    

    

    
}
