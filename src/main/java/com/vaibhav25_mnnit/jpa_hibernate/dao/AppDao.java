package com.vaibhav25_mnnit.jpa_hibernate.dao;


import com.vaibhav25_mnnit.jpa_hibernate.entity.Instructor;
import org.springframework.stereotype.Repository;


public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);
}
