package com.place2play.sportsComplex.model.mapper;

import com.place2play.sportsComplex.entity.SportsComplex;
import com.place2play.sportsComplex.model.dto.SportsComplexDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SportsComplexMapper {
    SportsComplexMapper INSTANCE = Mappers.getMapper(SportsComplexMapper.class);

    SportsComplex toEntity(SportsComplexDTO accountDTO);
}