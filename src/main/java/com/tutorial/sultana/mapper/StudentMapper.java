package com.tutorial.sultana.mapper;

import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.entities.Student;
import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.student.StudentGetResources;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Named("studentMapper")
public interface StudentMapper {

    @Named("toStudent")
    Student toStudent(StudentGetResources post);
    @Named("toGetResources")

    @Mapping(target = "id",ignore = true)
    StudentGetResources toStudentGetResources(Student student);

}
