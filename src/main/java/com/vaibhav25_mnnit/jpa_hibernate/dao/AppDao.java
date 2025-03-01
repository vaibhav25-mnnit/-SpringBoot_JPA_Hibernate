package com.vaibhav25_mnnit.jpa_hibernate.dao;


import com.vaibhav25_mnnit.jpa_hibernate.entity.Course;
import com.vaibhav25_mnnit.jpa_hibernate.entity.Instructor;
import com.vaibhav25_mnnit.jpa_hibernate.entity.InstructorDetails;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetails findInstructorDetailsById(int id);

    void deleteInstructorDetailsById(int id);

    List<Course> findCoursesByInstructorId(int id);
}
