package com.serialize.mapper;

import com.serialize.dto.PersonDto;
import com.serialize.entity.PersonEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {
    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDto personToPersonDto(PersonEntity personEntity);
}