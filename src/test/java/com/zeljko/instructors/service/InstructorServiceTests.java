package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.Course;
import com.zeljko.instructors.entities.Instructor;
import com.zeljko.instructors.repository.CourseRepository;
import com.zeljko.instructors.repository.InstructorRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
//import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class InstructorServiceTests {

    @Mock
    private InstructorRepository instructorRepository;

    @InjectMocks
    private InstructorServiceImpl instructorService;
/*
    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }*/
    @Test
    public void getAllInstructors(){
        List<Instructor> instructorList = new ArrayList<>();
        instructorList.add(new Instructor(1, "pera", "peric", LocalDate.of(1995,11,23), "pobedina 10 nis", "064 2312345", "pera@gmail.com"));
        instructorList.add(new Instructor(2, "mare", "maric", LocalDate.of(1980,10,12),"dusanova 12 nis", "063 1112234", "mare@gmail.com"));
        when(instructorRepository.findAll()).thenReturn(instructorList);

        List<Instructor> result = Lists.newArrayList(instructorService.getAllInstructors());
        assertEquals(2, result.size());
    }

    @Test
    public void deleteInstructor(){
        instructorService.deleteInstructor(3);
        verify(instructorRepository, times(1)).deleteById(3);
    }

}