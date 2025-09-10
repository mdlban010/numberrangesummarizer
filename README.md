# Number Range Summarizer

This project implements a **Number Range Summarizer** in Java.  
It provides functionality to **collect integers from a string** and to **summarize consecutive numbers into ranges**.  
The implementation follows the `NumberRangeSummarizer` interface and is validated with **JUnit 5 tests**.

---

##  Project Structure
IMPACT/

    │── lib/ junit-platform-console-standalone-1.13.2.jar
    │── src/main/java/numberrangesummarizer/NumberRangeSummarizer.java
                ├── Solution.java
                ├── SolutionTest.java
    └── README.md
---

##  Setup Instructions

### 1. Requirements
- [Visual Studio Code](https://code.visualstudio.com/)  
- Install the **Java Extension Pack** (from Microsoft) in VS Code.  
  This includes:
  - Language Support for Java™
  - Debugger for Java
  - Test Runner for Java
  - Maven/Java dependency support

### 2. Clone or open the project
Open the project folder (`IMPACT/`) in VS Code.

### 3. Running the Tests
1. Open the **Testing** sidebar in VS Code (left toolbar → “flask” icon 🧪).  
2. VS Code will automatically detect JUnit 5 tests in `SolutionTest.java`.  
3. Click **Run Tests**.  
4. All tests should pass ✅.

Alternatively, you can run from the terminal:
```bash
javac -d out -cp "lib/*" src/main/java/numberrangesummarizer/*.java

java -jar lib/junit-platform-console-standalone-1.13.2.jar --class-path out --scan-class-path

Tests & Justification

The tests are implemented in SolutionTest.java using JUnit 5.
Tested two core methods in Solution:

1. collect(String input)

Why test?

This method parses a comma-separated string into a collection of integers. Errors here would break the summarizer.

Tests cover:

Null or blank input → returns empty collection

Valid integers with spaces → correctly trimmed and parsed

Invalid tokens (letters, empty tokens) → skipped safely

Handling of negatives and duplicates

2. summarizeCollection(Collection<Integer> input)

Why test?

This method is the heart of the application — it compresses sorted integers into ranges.

Tests cover:

Empty collection → returns empty string

Single element → returned as-is

Non-consecutive numbers → listed individually

Consecutive sequences → summarized as ranges (e.g., 1-5)

Handling of duplicates → they do not break summarization

Unsorted input → sorted before summarization

Negative ranges → supported (e.g., -2-2)

Large integers near Integer.MAX_VALUE → handled correctly

Different collection types (e.g., Set) → supported

Mixed isolated and ranged values → summarized correctly

These tests ensure both robustness (handling bad input) and correctness (expected range outputs).

 Expected Outcome
Running the test suite should result in all tests passing.

Example passing output in VS Code Test Explorer:

...
All 16 tests passed
 Notes
The project uses JUnit 5 (Jupiter) via the junit-platform-console-standalone jar.

Tests can be run directly in VS Code, no Maven/Gradle required.

The implementation is designed to handle messy user input gracefully while producing a clean summarized output.