package com.cydeo.service.Impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Status;
import com.cydeo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {



    @Override
    public TaskDTO save(TaskDTO taskDTO) {

        if (taskDTO.getId() == null) {
            taskDTO.setId(UUID.randomUUID().getMostSignificantBits());
        }

        if(taskDTO.getTaskStatus() == null){
            taskDTO.setTaskStatus(Status.OPEN);
        }

        if(taskDTO.getAssignedDate() == null){
            taskDTO.setAssignedDate(LocalDate.now());
        }
        if(taskDTO.getProject().getProjectCode() == null){
            taskDTO.getProject().setProjectCode(findById(taskDTO.getId()).getProject().getProjectCode());
        }

        return super.save(taskDTO.getId(), taskDTO);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(TaskDTO task) {
        if(task.getTaskStatus() == null){
            task.setTaskStatus(findById(task.getId()).getTaskStatus());
        }

        super.update(task.getId(), task);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void updateWithId(TaskDTO task, Long id) {
        if(task.getId() == null){
            task.setId(id);
        }
        if(task.getTaskStatus() == null){
            task.setTaskStatus(findById(task.getId()).getTaskStatus());
        }
        if(task.getAssignedDate() == null){
            task.setAssignedDate(LocalDate.now());
        }
        if(task.getProject() == null){
            task.setProject(findById(id).getProject());
        }
        if(task.getUser() == null){
            task.setUser(findById(id).getUser());
        }

        super.update(task.getId(), task);
    }

    @Override
    public List<TaskDTO> findTaskByManager(UserDTO manager) {
        return findAll().stream().filter(taskDTO -> taskDTO.getUser().equals(manager)).collect(Collectors.toList());
    }
}

