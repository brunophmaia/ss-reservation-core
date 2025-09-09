package com.place2play.sportsComplex.repository;

import com.place2play.sportsComplex.entity.SportsComplex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SportsComplexRepository extends JpaRepository<SportsComplex, Long> {

    @Query("SELECT COUNT(sc) " +
            "FROM SportsComplex sc " +
            "JOIN AccountComplexGroup acg ON sc.id = acg.sportsComplex.id " +
            "WHERE acg.accountAdmin.id = :accountAdminId " +
            "AND UPPER(TRIM(sc.name)) = UPPER(TRIM(:name))")
    int countSportsComplexByAdminAndName(@Param("accountAdminId") Long accountAdminId, @Param("name") String name);
}
