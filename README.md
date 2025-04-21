## CS 320 Portfolio – Reflection

Ensuring Functionality and Security

I initiate each feature development with a pair of JUnit tests: one verifying the validity of input and the other confirming the invalidity of input. By driving development through tests, I guarantee that each requirement is evidenced by executable code rather than solely relying on documentation. I maintain code coverage above eighty percent and incorporate SpotBugs and GitHub Dependabot scans into the pipeline, ensuring that security warnings are detected before code merges.

Interpreting User Needs

I translate each user story into test cases that explicitly describe the desired behavior. For instance, “A phone number must contain exactly ten digits” is represented by a passing test utilizing `5551237890` and a failing test employing `12345abcde`. This test-driven approach compels me to clarify edge cases early and provides prompt feedback when a subsequent modification violates the original requirement.

Approach to Software Design

I adhere to an iterative, test-then-code cycle:

1. Write the Smallest Failing Test: Express a requirement by writing the smallest failing test.
2. Implement the Minimum Necessary Code: Implement just enough code to make the test pass.
3. Refactor for Readability and Reuse: Refactor while the green test suite ensures the code’s safety.

This cycle maintains small functions, promotes single responsibility, and prevents speculative features. When a class exceeds what a unit test can comfortably cover, I extract new classes and connect them through clear interfaces, resulting in code that is easily understandable and maintainable over time.
