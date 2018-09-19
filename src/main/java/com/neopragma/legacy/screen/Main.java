package com.neopragma.legacy.screen;

import com.neopragma.legacy.dao.JobApplicantDao;
import com.neopragma.legacy.dao.JobApplicantDaoImpl;
import com.neopragma.legacy.entity.JobApplicant;

import java.util.Scanner;

/**
 * This class provides entry and exit to the application.
 * Accepts user input and pretends to save a job application to database.
 *
 * @author neopragma
 * @version 1.0.0
 */
public class Main {
    public static JobApplicantDao jobApplicantDao;

    public static void main(String[] args) {
        boolean done = false;
        Scanner scanner = new Scanner(System.in);
        String firstName = "";
        String middleName = "";
        String lastName = "";
        String ssn = "";
        String zipCode = "";
        jobApplicantDao = new JobApplicantDaoImpl();
        while (!done) {
            System.out.println("Please enter info about a job candidate or 'quit' to quit");
            System.out.println("First name?");
            firstName = scanner.nextLine();
            if (firstName.equals("quit")) {
                scanner.close();
                System.out.println("Bye-bye!");
                done = true;
                break;
            }
            System.out.println("Middle name?");
            middleName = scanner.nextLine();
            System.out.println("Last name?");
            lastName = scanner.nextLine();
            System.out.println("SSN?");
            ssn = scanner.nextLine();
            System.out.println("Zip Code?");
            zipCode = scanner.nextLine();
            saveJobApplicant(firstName, middleName, lastName, ssn, zipCode);
        }
    }

    private static void saveJobApplicant(String firstName, String middleName, String lastName, String ssn, String zipCode) {
        JobApplicant jobApplicant = new JobApplicant();
        jobApplicant.setName(firstName, middleName, lastName);
        jobApplicant.setSsn(ssn);
        jobApplicant.setAddress(zipCode);
        jobApplicantDao.save(jobApplicant);
    }
}
