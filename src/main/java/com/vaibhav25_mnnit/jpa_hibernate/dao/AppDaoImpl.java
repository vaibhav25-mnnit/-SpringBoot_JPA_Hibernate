package com.vaibhav25_mnnit.jpa_hibernate.dao;

import com.vaibhav25_mnnit.jpa_hibernate.entity.Instructor;
import com.vaibhav25_mnnit.jpa_hibernate.entity.InstructorDetails;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImpl  implements AppDao{

    private EntityManager entityManager;

    @Autowired
    public  AppDaoImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor theInstructor = findInstructorById(id);

        entityManager.remove(theInstructor);
    }

    @Override
    public InstructorDetails findInstructorDetailsById(int id)
    {
        return entityManager.find(InstructorDetails.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailsById(int id) {
        InstructorDetails instructorDetails = findInstructorDetailsById(id);

        entityManager.remove(instructorDetails);
    }

}
