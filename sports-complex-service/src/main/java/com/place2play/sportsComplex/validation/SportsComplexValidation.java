package com.place2play.sportsComplex.validation;

import com.place2play.sportsComplex.configuration.exception.CustomGeneralException;
import com.place2play.sportsComplex.model.dto.SportsComplexDTO;
import com.place2play.sportsComplex.repository.AccountComplexGroupRepository;
import com.place2play.sportsComplex.repository.SportsComplexRepository;
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
