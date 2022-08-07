package com.tutorial.sultana.service.impl;

import com.tutorial.sultana.entities.Student;
import com.tutorial.sultana.exceptions.DateNotFoundException;
import com.tutorial.sultana.exceptions.InvalidConversion;
import com.tutorial.sultana.mapper.StudentMapper;
import com.tutorial.sultana.moduls.student.StudentGetResources;
import com.tutorial.sultana.repo.StudentRep;
import com.tutorial.sultana.service.StudentService;
import com.tutorial.sultana.utils.VariableUtils;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRep studentRepo;
    private final StudentMapper studentMapper;
    @Override
    public StudentGetResources create(StudentGetResources post) {

        Student student =studentMapper.toStudent(post);
        studentRepo.save(student);
        return studentMapper.toStudentGetResources(student);
    }

    @Override
    public List<StudentGetResources> findAll() {
        return studentRepo.findAll().stream().map(student ->
                studentMapper.toStudentGetResources(student)
        ).collect(Collectors.toList());
    }

    @Override
    public StudentGetResources getOne(String id) {



        Optional<Student> student=studentRepo.findById(VariableUtils.toObjectId(id));
        if (student.isPresent()){
            return studentMapper.toStudentGetResources(student.get());
        }
        throw new DateNotFoundException("persons not available");
    }
}
