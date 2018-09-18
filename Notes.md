# Refactoring notes

Summary of code smells and remediations. The JobApplicant class has several issues. It is tightly coupled with multiple responsibilities. I will start with trivial ones first and walk my way through various smells.

Smell 1: The JobApplicant instance variables are placed arcoss the class. Rearranging to the top of the class to improve readability.
---
Smell 2: Incomplete class level comment in JobApplicant class.
