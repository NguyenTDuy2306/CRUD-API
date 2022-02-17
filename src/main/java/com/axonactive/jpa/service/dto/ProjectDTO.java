package com.axonactive.jpa.service.dto;

import lombok.Getter;
import lombok.Setter;

import javax.ws.rs.GET;

@Setter
@Getter
public class ProjectDTO {
    private  int id;
    private String name;
    private String area;
}
