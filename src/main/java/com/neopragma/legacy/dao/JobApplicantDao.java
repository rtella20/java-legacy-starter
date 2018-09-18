package com.neopragma.legacy.dao;

import com.neopragma.legacy.entity.JobApplicant;

/**
 * Persistence interface for JobApplication entity. Currently supports save.
 * TODO retrieve, delete operations
 *
 * @author neopragma
 * @version 1.0
 */
public interface JobApplicantDao {
    public void save(JobApplicant jobApplicant);
}
