package com.phlab.ticketmanagement.service;

import com.phlab.ticketmanagement.dao.ProjectDao;
import com.phlab.ticketmanagement.model.Project;
import org.hibernate.PropertyValueException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

import java.time.LocalDate;

/*
 * Author: phlab
 * Date: 24/02/21
 */
@ExtendWith(MockitoExtension.class)
public class ProjectServiceTest {

    @Mock
    private ProjectDao projectDao;
    @Captor
    ArgumentCaptor<Project> projectArgumentCaptor;

    private ProjectService underTest;

    @BeforeEach
    void setUp(){
        this.underTest = new ProjectService(projectDao);
    }

    @Test
    void shouldSaveProject(){
        //given
        Project projectToSave = new Project("Test project", LocalDate.now(), null);

        //when
        //underTest.addProject(projectToSave);
        underTest.addProject(projectToSave);

        //then
        then(projectDao).should().save(projectArgumentCaptor.capture());
        Project projectArgumentValue = projectArgumentCaptor.getValue();

        assertThat(projectArgumentValue).usingRecursiveComparison().isEqualTo(projectToSave);
    }

    @Test
    void shouldNotSaveProjectWithBlankName(){
        //given
        Project projectToSave = new Project("", LocalDate.now(), null);
        //Then
        assertThatThrownBy(() -> underTest.addProject(projectToSave))
                .hasMessageContaining("Project Name is obligatory")
                .isInstanceOf(ResponseStatusException.class);
    }

    @Test
    void shouldUpdateProject(){
        //given
        Long id = 1L;
        Project mockProject = new Project("Mock", LocalDate.now(), null);
        mockProject.setProjectId(id);
        Project toUpdate = new Project("New Project", LocalDate.now(), null);
        toUpdate.setProjectId(id);

        //when
        given(projectDao.getOne(id)).willReturn(mockProject);
        underTest.updateProject(id, toUpdate);

        //Then
        then(projectDao).should().save(projectArgumentCaptor.capture());
        Project projectCaptorValue = projectArgumentCaptor.getValue();

        assertThat(projectCaptorValue).usingRecursiveComparison().isEqualTo(toUpdate);

    }

    @Test
    void shouldNotUpdateProjectWithEmpryName(){
        //given
        Long id = 1L;
        Project toUpdate = new Project("", LocalDate.now(), null);
        toUpdate.setProjectId(id);
        //then
        assertThatThrownBy(() -> underTest.updateProject(1l, toUpdate))
                .hasMessageContaining("Project Name is obligatory")
                .isInstanceOf(ResponseStatusException.class);

    }

    @Test
    void shouldNotUpdateProjectWhenProjectNotFound(){
        //given
        Long id = 1L;
        Project mockProject = new Project("Mock", LocalDate.now(), null);
        mockProject.setProjectId(0l);
        Project toUpdate = new Project("New Project", LocalDate.now(), null);
        toUpdate.setProjectId(id);

        //when
        given(projectDao.getOne(id)).willReturn(mockProject);

        //then
        assertThatThrownBy(() -> underTest.updateProject(1l, toUpdate))
                .hasMessageContaining("Project not found")
                .isInstanceOf(ResponseStatusException.class);

    }
}
