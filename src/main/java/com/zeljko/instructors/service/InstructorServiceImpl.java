package com.zeljko.instructors.service;

import com.zeljko.instructors.entities.Instructor;
import com.zeljko.instructors.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InstructorServiceImpl implements InstructorService {

    private InstructorRepository instructorRepository;

    @Autowired
    public InstructorServiceImpl(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    @Override
    public List<Instructor> getAllInstructors() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    @Override
    public Instructor getInstructorById(int id) {
        return instructorRepository.findById(id).get();
    }

    @Override
    public void saveOrUpdate(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    @Override
    public void deleteInstructor(int id) {

        instructorRepository.deleteById(id);
    }
}