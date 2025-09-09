package com.place2play.sportsComplex.service;

import com.place2play.sportsComplex.entity.AccountComplexGroup;
import com.place2play.sportsComplex.entity.SportsComplex;
import com.place2play.sportsComplex.model.dto.SportsComplexDTO;
import com.place2play.sportsComplex.model.mapper.SportsComplexMapper;
import com.place2play.sportsComplex.repository.AccountComplexGroupRepository;
import com.place2play.sportsComplex.repository.SportsComplexRepository;
import com.place2play.sportsComplex.validation.SportsComplexValidation;
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
