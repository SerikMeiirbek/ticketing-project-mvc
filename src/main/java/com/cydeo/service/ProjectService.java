package com.cydeo.service;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.dto.UserDTO;

import java.util.List;

public interface ProjectService extends CrudSerice<ProjectDTO, String> {
    void complete(String Id);
    List<ProjectDTO> getCountedListOfProjectDTO(UserDTO user);
}
