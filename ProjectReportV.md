## Part V: Testable Design

### Introduction to Testable Design

What is testable design? The basic value proposition of testable design is to be able to test code better. As Roy Osherove said[1], testable design is “a given piece of code should be easy and quick to write a unit test against.”

#### Guidelines for Testable Design

After talking about the concept of testable design, you might still have question on how to make a testable design. There are some rules to follow as below. 

- In testable design, we need to avoid complex `private` methods. The reason for this rule is quite clear. In Java, we cannot test with `private` methods. Under this circumstance, when there are some complex `private` methods, we cannot test with them.
- In testable design, we need to avoid `static` methods. The reason for this rule is also Java's definitions. In Java, `static` method operate on the class instead of the object. 
- In testable design, we need to be careful to hardcode in `new`. If so, object cannot be stubbed. 
- In testable design, we need to avoid logic in constructors. 

### Introduction to Mocking

- Testable Design (20 points)
  - First, describe some aspects and goals for what makes a testable design (20%)
  - Find an example in the code of an implementation that would make a certain kind of testing difficult or impossible. Document that code in your report and describe what would be prevented with that code. Describe how you would advise to fix that code. Implement a new version of that code with the newer design. (This can be as a dummy method that does not break the existing code). (40%)
  - Write a test case that executes the new, more testable code in a way that tests the newly testable functionality. (40%)
- Mocking (20 points)
  - Describe mocking and its utility. (20%)
  - Find a feature that could be mocked (that is not already) and would be good to be tested with mocking. Document this feature and how mocking would allow for a type of behavior checking not afforded without mocking. (40%)
  - Write a test case using Mockito that uses mocking to test that feature. (40%)

## Reference

[1] https://livebook.manning.com/book/effective-unit-testing/chapter-7/8