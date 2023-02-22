package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;

public interface ProjectService extends CrudSerice<ProjectDTO, String> {
    void complete(String Id);
}
