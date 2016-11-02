package com.kanaiza.accomodation.service.accomodation;

import com.kanaiza.accomodation.domain.accomodation.Damage;
import com.kanaiza.accomodation.domain.accomodation.Disciplinary;

/**
 * Created by kanaiza on 10/29/16.
 */
public interface DisciplineService {
    public Disciplinary create(Disciplinary disciplinary);
    public Disciplinary update(Disciplinary disciplinary);
}
