package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.RoleDTO;
import com.cydeo.enums.Status;
import com.cydeo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImp extends AbstractMapService<ProjectDTO,String> implements ProjectService {
    @Override
    public ProjectDTO save(ProjectDTO object) {
        if(object.getProjectStatus() == null)
            object.setProjectStatus(Status.OPEN);
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void update(ProjectDTO object) {

        if(object.getProjectStatus() == null)
            object.setProjectStatus(findById(object.getProjectCode()).getProjectStatus());
        super.update(object.getProjectCode(), object);
    }

    @Override
    public void deleteById(String projectCode) {
        super.deleteById(projectCode);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public void complete(ProjectDTO project) {
        project.setProjectStatus(Status.COMPLETE);
        super.save(project.getProjectCode(),project);
    }
}
