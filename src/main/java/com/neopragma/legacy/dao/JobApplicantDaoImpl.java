package com.neopragma.legacy.dao;

import com.neopragma.legacy.entity.JobApplicant;

/**
 * Persistence implementation for JobApplication entity. Currently supports save.
 * TODO retrieve, delete operations
 *
 * @author neopragma
 * @version 1.0
 */

public class JobApplicantDaoImpl implements JobApplicantDao {
    @Override
    public void save(JobApplicant jobApplicant) {
        //TODO save information to a database
        System.out.println("Saving to database: " + jobApplicant.formatLastNameFirst());
    }
}
