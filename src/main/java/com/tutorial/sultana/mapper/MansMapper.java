package com.tutorial.sultana.mapper;

import com.tutorial.sultana.entities.Mans;
import com.tutorial.sultana.moduls.PostMan;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(uses = {}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Named("mansMapper")
public interface MansMapper {
    @Named("toMans")
    Mans toMans(PostMan post);
}
