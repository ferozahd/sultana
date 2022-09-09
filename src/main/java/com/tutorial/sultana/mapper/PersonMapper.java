package com.tutorial.sultana.mapper;

import com.tutorial.sultana.entities.Persons;
import com.tutorial.sultana.moduls.person.PersonDetailsResponse;
import com.tutorial.sultana.moduls.person.PersonGetResources;
import com.tutorial.sultana.moduls.person.PostResource;
import com.tutorial.sultana.utils.VariableUtils;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {VariableUtils.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Named("personMapper")
public interface PersonMapper {
    @Named("toPerson")
    Persons toPerson(PostResource post);

    @Named("toGetResource")
    @Mapping(target = "identity", source = "id", qualifiedByName = {"VariableUtils", "objectIdToString"})
    PersonGetResources toGetResource(Persons persons);


    @Named("toDetailsResponse")
    @Mapping(target = "identity", source = "id", qualifiedByName = {"VariableUtils", "objectIdToString"})
    @Mapping(target = "father", ignore = true)
    @Mapping(target = "mother", ignore = true)
    @Mapping(target = "siblings", ignore = true)
    PersonDetailsResponse toDetailsResponse(Persons persons);
}
