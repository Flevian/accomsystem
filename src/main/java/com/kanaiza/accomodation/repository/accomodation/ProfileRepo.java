package com.kanaiza.accomodation.repository.accomodation;

import com.kanaiza.accomodation.domain.accomodation.StudentProfile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProfileRepo extends JpaRepository<StudentProfile , Long> {
    Page<StudentProfile> findByStudentRegNo(String studentRegNo , Pageable pageable);
}
