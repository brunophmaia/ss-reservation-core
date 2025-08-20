package com.ss_reservation.ss_reservation_core.sportsComplex.service;

import com.ss_reservation.ss_reservation_core.sportsComplex.entity.AccountComplexGroup;
import com.ss_reservation.ss_reservation_core.sportsComplex.entity.SportsComplex;
import com.ss_reservation.ss_reservation_core.sportsComplex.mapper.SportsComplexMapper;
import com.ss_reservation.ss_reservation_core.sportsComplex.model.SportsComplexDTO;
import com.ss_reservation.ss_reservation_core.sportsComplex.repository.AccountComplexGroupRepository;
import com.ss_reservation.ss_reservation_core.sportsComplex.repository.SportsComplexRepository;
import com.ss_reservation.ss_reservation_core.sportsComplex.validation.SportsComplexValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SportsComplexService {

    @Autowired
    SportsComplexRepository sportsComplexRepository;

    @Autowired
    AccountComplexGroupRepository accountComplexGroupRepository;

    @Autowired
    private ApplicationContext context;

    @Transactional
    public void create(SportsComplexDTO sportsComplexDTO) {

        Long userId = (Long) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        SportsComplexValidation sportsComplexValidation = context.getBean(SportsComplexValidation.class);
        sportsComplexValidation.checkSportsComplex(sportsComplexDTO, userId);

        SportsComplex sportsComplex = SportsComplexMapper.INSTANCE.toEntity(sportsComplexDTO);
        sportsComplex.setCreateUserId(userId);
        sportsComplex.setUpdateUserId(userId);
        sportsComplexRepository.save(sportsComplex);

        AccountComplexGroup accountComplexGroup = new AccountComplexGroup();
        accountComplexGroup.setAccountId(userId);
        accountComplexGroup.setAccountAdminId(userId);
        accountComplexGroup.setSportsComplexId(sportsComplex.getId());
        accountComplexGroup.setCreateUserId(userId);
        accountComplexGroup.setUpdateUserId(userId);
        accountComplexGroupRepository.save(accountComplexGroup);
    }
}
