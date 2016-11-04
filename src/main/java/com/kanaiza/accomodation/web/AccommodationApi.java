package com.kanaiza.accomodation.web;

import com.kanaiza.accomodation.domain.accomodation.Bed;
import com.kanaiza.accomodation.domain.enumeration.BedStatus;
import com.kanaiza.accomodation.service.accomodation.BedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kanaiza on 11/2/16.
 */
@RestController
@RequestMapping(value = "/api")
public class AccommodationApi {

    @Autowired
    BedService bedService;

    @RequestMapping(value = "/beds" , method = RequestMethod.GET , produces = "application/json")
    @ResponseBody public List<String> getAllBeds(@RequestParam("bedStatus") String bedStatus ,
                                   @RequestParam("zoneCode") String zoneCode){

        List<Bed> beds = bedService.findByStatusAndZoneCode(BedStatus.valueOf(bedStatus.toUpperCase()), zoneCode);

        List<String> bedNumbers = new ArrayList<>();

        if (!beds.isEmpty()){

            for (int i = 0 ; i < beds.size() ; i ++ ){
                bedNumbers.add(beds.get(i).getNumber());
            }

            return bedNumbers;
        }else {

            return Arrays.asList("No records found");
        }

    }
}
