package com.cydeo.service.Impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.TaskDTO;
import com.cydeo.dto.UserDTO;
import com.cydeo.entity.Status;
import com.cydeo.service.ProjectService;
import com.cydeo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO,String> implements ProjectService {

    TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO project) {
        if(project.getProjectStatus() == null){
            project.setProjectStatus(Status.OPEN);
        }
        return super.save(project.getProjectCode(), project);
    }

    @Override
    public ProjectDTO findById(String id) {
        return super.findById(id);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String id) {
        super.deleteById(id);
    }

    @Override
    public void update(ProjectDTO project) {

        if(project.getProjectStatus() == null){
            project.setProjectStatus(findById(project.getProjectCode()).getProjectStatus());
        }

        super.update(project.getProjectCode(), project);
    }

    @Override
    public void complete(String Id) {
        super.findById(Id).setProjectStatus(Status.COMPLETE);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        List<ProjectDTO> projectList =
                findAll().stream().filter(project ->
                                project.getAssignedManager().equals(manager))
                        .map(
                            project-> {

                                List<TaskDTO> taskList = taskService.findTaskByManager(manager);

                                int completedTaskCounts = (int)taskList.stream().filter(t ->  t.getProject().equals(project) && t.getTaskStatus() == Status.COMPLETE).count();

                                int unfinishedTaskCounts = (int)taskList.stream().filter(t ->  t.getProject().equals(project) && t.getTaskStatus() != Status.COMPLETE).count();

                                project.setUnfinishedTaskCounts(unfinishedTaskCounts);
                                project.setCompletedTaskCounts(completedTaskCounts);

                                return project;
                            }
                        ).collect(Collectors.toList());

        return projectList;
    }
}
