# Refactoring notes

Summary of code smells and remediations. The JobApplicant class has several issues. It is tightly coupled with multiple responsibilities. I will start with trivial ones first and walk my way through various smells.

Smell 1: The JobApplicant instance variables are placed arcoss the class. Rearranging to the top of the class to improve readability.

Smell 2: Incomplete class level comment in JobApplicant class.

Smell 3: Violation of single responsibility. The application is started and stopped through JobApplicant. This not a concern of job applicant class. Let's separate.

Smell 4: Violation of single responsibility. The job application save operation is performed within the class. This is concern of a data access layer. The domain entity should not worry about db operations. This could be a good time to introduce separate packages.

Smell 5: Separation of concerns: The job applicant currently handles several name related aspects. This can be separated into a Name. Lets start with tests.

Smell 6: Separation of concerns: The job applicant currently handles ssn formatting and validations. This is not a concern of job application class.

Smell 7: Several hard coded error codes in SSN validation and formatting. Time to make them constants.

Smell 8: Hard coded error codes in name validation. They can use some constants.