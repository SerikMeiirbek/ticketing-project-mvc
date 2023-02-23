package com.cydeo.service;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.service.CrudSerice;

import java.util.List;
import java.util.UUID;

public interface TaskService extends CrudSerice<TaskDTO, Long> {
    void updateWithId(TaskDTO taskDTO, Long id);
    List<TaskDTO> findTaskByManager(UserDTO manager);
}
