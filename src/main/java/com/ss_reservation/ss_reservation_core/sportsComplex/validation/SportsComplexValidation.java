package com.ss_reservation.ss_reservation_core.sportsComplex.validation;

import com.ss_reservation.ss_reservation_core.common.exception.CustomGeneralException;
import com.ss_reservation.ss_reservation_core.sportsComplex.model.SportsComplexDTO;
import com.ss_reservation.ss_reservation_core.sportsComplex.repository.AccountComplexGroupRepository;
import com.ss_reservation.ss_reservation_core.sportsComplex.repository.SportsComplexRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class SportsComplexValidation {

    @Autowired
    private SportsComplexRepository sportsComplexRepository;

    @Autowired
    private AccountComplexGroupRepository accountComplexGroupRepository;

    public void checkSportsComplex(SportsComplexDTO sportsComplexDTO, Long userAdminId){

        if(sportsComplexDTO.checkNullRequiredFields()){
            throw new CustomGeneralException("sportsComplex.checkFields");
        }

        if(sportsComplexRepository.countSportsComplexByAdminAndName(userAdminId, sportsComplexDTO.getName().trim().toUpperCase()) > 0) {
            throw new CustomGeneralException("sportsComplex.nameInUse", getListNameInInUse(sportsComplexDTO.getName()));
        }
    }

    private static List<String> getListNameInInUse(String name) {
        List<String> names = new ArrayList<String>();
        names.add(name);
        return names;
    }
}
