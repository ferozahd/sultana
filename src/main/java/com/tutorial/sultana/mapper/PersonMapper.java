package com.tutorial.sultana.mapper;

import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.moduls.PostResource;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Named("personMapper")
public interface PersonMapper {
    @Named(("toPerson"))
    Persons toPerson(PostResource post);
}
