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

Smell 9: Separation of concerns. The address related activities can be separated from job applicant.

Smell 10: Reviewing the Address, it can further refactored to separate city sate lookup from address class.

Smell 11: Separation of concerns. The city state look up doesn't have to be part of address or city state domain. That could be a separate utility service.

Smell 12: Integration tests are bundled with unit tests. The city state look up service makes a remote call to get information. This need to be separated from unit tests. Fix maven build provision to exclude integration tests. Introduced test doubles for unit tests

Smell 13: Checked exceptions in CityStateLookup are tightly coupled requiring the callers to handle exception. This is a maintenance issue that changes to the lookup service interface such as making a db call may require a new set of exceptions handling. Introduce an unchecked exception wrapper and document.

Smell 14: Incompatible Maven plugin for JDK 9 and 10 versions. The current cobertura-maven-plugin fails to build using Java versions greater than JDK8. See https://github.com/mojohaus/cobertura-maven-plugin/issues/30 Disabling the Cobertura for now to make command line build work. To do: Add a technical debt items to implement a code coverage tool.
