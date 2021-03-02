## Part VI: Static Analyzers

### Introduction to Static Analysis

What is a static analysis? Usually, static analysis means code review. In companies, especially in one project, colleagues will review your code manually. 

- In one word, static analysis is mostly informal manual-human reviews of code.
- Also called "code reviews" or "compile-time analysis".

During our experience in `JSoup` project, we fork our project into our own repository and pull request into the master. One or two of our collaborators will peer view the PR code, give it some advice or directly merge it into the master. 

There are best practices for the process of static analyzers.

1. Review small portions of code at a time
2. Record all feedback
3. Review code independently before gathering to discuss
4. Use checklists

### Importance of Static Analysis

After talking about the basic concepts of static analysis, we come to the question why we need static analysis.  Combined with its basic concepts, we concluded reasons of necessity of static analysis.

- Static analysis can help you find potential bugs early. Using static analysis, your code reviewers can help you find these bugs manually.
- Static analysis can help you stick to the same coding style or coding standard. Since more than one people are involved in one function or one line of code, the clarity of code will increase. In my opinion, to raise the possibility of merging code, you are not the only one who sees the code so that you need to make more comments and try to make the code neat and clear. 
- Static analysis can help team collaboration. Your team need to involve in the same project and be responsible for every line of code. To achieve that, your team members must discuss more often and share your ideas on code. 

### Tools for Static Analysis

We used two different static analyzers on our project `JSoup`.

The first one is **SpotBugs**. SpotBugs is a program that uses static analysis to find errors in Java code.

The second one is **Checkstyle**. Checkstyle is a development tool that helps programmers write Java code that meets coding standards. Sample coding standard: google coding style or sun check. 

### Results of Static Analysis by Spotbugs and Checkstyle.

Firstly, we used the checkstyle tool. I pressed the "Check Module" button and the result is as below. This used the sun checks method. 

![image.png](https://i.loli.net/2021/03/02/Gze3rEZkjBswlYg.png)

The following picture used the google checks method.

![image.png](https://i.loli.net/2021/03/02/8BWXQgynmVxivzf.png)

#### Deep dive into some errors

The first error I met with is `CustomImportError`. Actually it emphasised on the order of import, not an actual bug that you will see in the command line. 

The second error I met with is `Indentation`. It used 4 tabs instead of 2 tabs. 

The third error I met with is `RequiredEmptyLineBeforeBlockTagGroup`. It requires us to have an empty line before tag `@Return`. 

From my perspective, 



Next, we used the spotbugs tool. Different from the checkstyle tool, it is divided into folders and each java file, and it will spotlights the lines and functions or classes that has some type error or bugs. 

![image.png](https://i.loli.net/2021/03/02/kgB1MNfmAYuXLGK.png)



- Static Analyzers
  - First, describe the goals, purposes, and use of static analysis tools (i.e., static analyzers). 
  - Use two different static analyzers on your project (on the whole or on the same subset of the code for each tool). Options:
    - [Checkstyle](https://checkstyle.sourceforge.io/)
    - [FindBugs](http://findbugs.sourceforge.net/) or [SpotBugs](https://spotbugs.github.io/) (not both)
    - [Infer](https://fbinfer.com/)
    - [PMD](https://pmd.github.io/)
  - Show the aggregated numbers for the results. First separate out the results for each tool.
  - For each tool, dive into the warnings that they identify and describe in detail a few. Describe how they are or aren't actual problems in the code. 
  - Contrast the information that was provided by each tool. Did they provide information that overlaps in nature or are fundamentally different in their purposes? If they are similar, do they identify distinct warnings (i.e., does one identify warnings that the other does not, and vice versa)? Do they identify some of the same warnings, and if so, are the information provided by each tool of equal value? How so or how not?