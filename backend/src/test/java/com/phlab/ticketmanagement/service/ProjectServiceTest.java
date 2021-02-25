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
        projectDao.save(projectToSave);

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
}
