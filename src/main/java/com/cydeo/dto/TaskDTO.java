package com.cydeo.dto;

import com.cydeo.entity.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO {


    private Long id;
    private ProjectDTO project;
    private UserDTO user;
    private String taskSubject;
    private String taskDetail;
    private Status taskStatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate assignedDate;



}
