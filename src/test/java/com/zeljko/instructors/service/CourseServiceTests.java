package com.zeljko.instructors.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.zeljko.instructors.entities.Course;
import com.zeljko.instructors.repository.CourseRepository;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(MockitoJUnitRunner.class)
public class CourseServiceTests {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseServiceImpl courseService;

  /*  @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }
*/
    @Test
    public void getAllCourses(){
        List<Course> courseList = new ArrayList<>();
        courseList.add(new Course(1,"c", LocalDate.of(2018,11,21),LocalDate.of(2019,10,17)));
        courseList.add(new Course(2,"c+", LocalDate.of(2017,10,15),LocalDate.of(2018,11,23)));
        when(courseRepository.findAll()).thenReturn(courseList);

        List<Course> result = Lists.newArrayList(courseService.getAllCourses());
        assertEquals(2, result.size());
    }

    @Test
    public void deleteCourse(){
        courseService.deleteCourse(3);
        verify(courseRepository, times(1)).deleteById(3);
    }

}