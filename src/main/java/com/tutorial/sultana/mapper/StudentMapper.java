package com.tutorial.sultana.mapper;

import com.tutorial.sultana.entities.Student;
import com.tutorial.sultana.moduls.PostStudent;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Named("studentMapper")
public interface StudentMapper {
    @Named("toStudent")
    Student toStudent(PostStudent post);
}
