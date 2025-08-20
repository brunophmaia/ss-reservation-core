package com.ss_reservation.ss_reservation_core.sportsComplex.mapper;

import com.ss_reservation.ss_reservation_core.sportsComplex.entity.SportsComplex;
import com.ss_reservation.ss_reservation_core.sportsComplex.model.SportsComplexDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SportsComplexMapper {
    SportsComplexMapper INSTANCE = Mappers.getMapper(SportsComplexMapper.class);

    SportsComplex toEntity(SportsComplexDTO accountDTO);
}