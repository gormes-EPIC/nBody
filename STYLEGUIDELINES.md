## Lab 2: nBody  Style Guide

### Comments

Recall that comments should be informative and minimal. An ideal comment is one or two lines and describes the functionality of the next block of code. This is very important for longer programs like this project.

### Efficiency

Sometimes, it may seem necessary to use a data structure to store some information. However, it is our goal as programmers to be as minimalistic as possible; if it is possible to avoid a data structure while maintaining efficient and readable code, it is good style to do so.

Another efficiency killer is the recomputation of identical values. Oftentimes in a loop, there will be an opportunity to use the same value in each iteration of the loop. It would be inefficient to recompute this value every time it needs to be used. Instead, it is good style to compute that value once outside the loop and store it in a variable, and then use that variable in the loop.

**Deadstores** are variables that are declared and initialized (some value is stored in them), but this value is never used again. Maintaining variables and data structures you don’t use is clearly a waste of memory. IntelliJ will warn you about deadstores (also if a data structure is written to but never read from), and you should make sure to eliminate these warnings to ensure you have no unused variables.

# Data Structures Style Guide

In this course, we will not only practice writing code but how to write good code. Learning how to write good code  
includes a number of stylistic conventions. As we move further into the course, the expectations for appropriate  
style and documentation will become more extensive as we continue to practice. It is expected that you keep the style  
guidelines introduced in previous assignments in mind during the current assignment. This document will include a  
generic introduction to aspects of style relevant to this class in addition to specifics regarding this assignment.

## Types of Style Guidelines

There are six main categories of guidelines to look out for during this course.

### Formatting

_IntelliJ will automatically reformat code for us, so we won't have to worry about it too much in  
this course._

Formatting refers to the way code is structured. This includes indentations, brackets, and whitespace. Using clear and  
consistent formatting throughout makes writing and reading code easier. It is even more important when multiple people  
are working on the same program. In IntelliJ, there are built-in formatting rules which you can apply by:

- Going in the _Code_ menu and selecting _Reformat Code_.
- Using the keyboard shortcut, which by default is Ctrl+Alt+L on Windows and Opt+Cmd+L on Mac.

### Comments

Comments are statements of code that are not executed by the compiler or interpreter. We use them to explain what  
different pieces of do. Regardless of the complexity of the program, commenting all of your work appriately is a good  habit to get into.

In general, your comments should:

- Be concise: only write as much as is necessary to convey relevant information
- Help the reader: write them with the intention of a third party using them to understand your code, especially if it  
  is not immediately obvious
- Break the code into smaller units: Comments help separate code at logical breaks like the beginning of a loop, a new  
  step in a larger calculation, or at the beginning of a function

Commenting can be used as part of an effective code writing strategy as well. Instead of commenting after the code is  
written, try commenting before writing the code. By breaking down your program logically into smaller chunks and then  
working on those small chunks individually, you can avoid some bugs and logical errors

#### Javadoc

Javadoc is a tool that generates Java code documentation in the HTML format from Java source code. The documentation is  
formed from Javadoc comments that are usually placed above classes, methods, or fields. There are specific comment  
formats used to generate Javadocs that we will discuss and use later in the course.

### Naming

Naming variables, constants, functions, and classes is key to writing good code. Names should help the reader understand  
what is going on in your program.

In general, names should be:

- Accurate and informative: Names should reflect the contents or purpose of the entity as much as possible
- Concise: Names should be as concise as possible without sacrificing the above bullet point too much. It's a balance.
- Consistent: Use consistent names and naming conventions throughout your programs. See the section below for more  
  information about Java-specific conventions.

#### Java Conventions

In Java there are a few different conventions programmers use.

- For variables and functions, we will typically use camelCase
- For constants, we use CAPS_SNAKE_CASES
- For files, we use UpperCamelCase

### Maintainability

Maintainable code is easy to work on, update, and change without the original author needing to be present.  
Maintainability is a broad catch-all category for other aspects of good code that make it easy for you and others on  
your team to work on and debug code.

### Efficiency

It is important to not only write code that is correct, but efficiently uses resources (primarily memory and time). We  
will talk about this more extensively later in the course, but is something to keep in mind. Efficient code is  
increasing important as we write code to handle larger and larger inputs.

### Concision

Your code should be as concise as possible without sacrificing readability. Just like with commenting, this is a  
balance.  
  
