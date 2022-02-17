package com.axonactive.jpa.entities.mapper;

import com.axonactive.jpa.controller.request.ProjectRequest;
import com.axonactive.jpa.entities.Project;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.InheritConfiguration;

@Mapper
public interface ProjectMapper {
    Project projectRequestToProject(ProjectRequest projectRequest);

    @InheritConfiguration
    void projectRequestINtoProject(ProjectRequest projecrRequest, @MappingTarget Project project);
}