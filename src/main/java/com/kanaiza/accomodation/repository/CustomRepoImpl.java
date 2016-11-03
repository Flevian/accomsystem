package com.kanaiza.accomodation.repository;

import com.kanaiza.accomodation.domain.enumeration.BedStatus;
import com.kanaiza.accomodation.domain.enumeration.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by kanaiza on 11/3/16.
 */
@Repository
@Transactional
public class CustomRepoImpl implements CustomRepo {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<String> getVacantBeds(String zoneCode, String gender) {

        String sql = "select number from bed a inner join room b " +
                "on a.room_id=b.id inner join block c on b.block_id=c.id " +
                "inner join hostel d on c.hostel_id=d.id inner join zone e on " +
                "d.zone_id=e.id where a.status:=bedStatus and c.gender:=gender and e.code:=zoneCode";

        Query query = entityManager.createNativeQuery(sql);

        query.setParameter("bedStatus" , BedStatus.AVAILABLE.toString());
        query.setParameter("gender" , Gender.valueOf(gender.toUpperCase()).ordinal());
        query.setParameter("zoneCode" , zoneCode);

        List<String> beds =  query.getResultList();

        return beds;
    }
}
