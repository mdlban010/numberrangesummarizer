# Number Range Summarizer

Implementation of the `NumberRangeSummarizer` interface in Java.  
The summarizer collects integers from a comma-delimited string and outputs a compact string where consecutive sequences are collapsed into ranges.

---

## Example

```java
// Sample Input: "1,3,6,7,8,12,13,14,15,21,22,23,24,31
// Result: "1, 3, 6-8, 12-15, 21-24, 31"
 
```

---

## Project Layout

```
src/
 ├── main/java/numberrangesummarizer/
 │     ├── NumberRangeSummarizer.java   # Provided interface
 │     └── Solution.java                 # Implementation
 └── test/java/numberrangesummarizer/
       └── SolutionTest.java             # Unit tests (JUnit 5)
lib/                                      # JUnit jar(s)
```

---

## Prerequisites

- Java 17+ (Java 11 works as well)
- VS Code with:
  - **Extension Pack for Java**
  - **Test Runner for Java**
- [JUnit 5 standalone jar](https://search.maven.org/artifact/org.junit.platform/junit-platform-console-standalone/1.10.2/jar)  
  Save as `lib/junit-platform-console-standalone-1.10.2.jar`.

---

## Build

Compile the code and tests:

**Linux/macOS**
```bash
javac -cp ".:lib/*" \
  src/main/java/numberrangesummarizer/Solution.java \
  src/test/java/numberrangesummarizer/SolutionTest.java
```

**Windows**
```bash
javac -cp ".;lib/*" ^
  src\main\java\numberrangesummarizer\Solution.java ^
  src\test\java\numberrangesummarizer\SolutionTest.java
```

---

## Run Tests

**Linux/macOS**
```bash
java -jar lib/junit-platform-console-standalone-1.10.2.jar \
  --class-path "src/main/java:src/test/java" \
  --scan-class-path
```

**Windows**
```bash
java -jar lib\junit-platform-console-standalone-1.10.2.jar ^
  --class-path "src\main\java;src\test\java" ^
  --scan-class-path
```

---

## Run Tests in VS Code

If you installed **Test Runner for Java**, you’ll see `Run | Debug` above each `@Test` in `SolutionTest.java`.  
Click **Run Test** to execute directly inside VS Code.

---

## Notes

- Recompile (`javac`) after making changes.  
- Output formatting is currently `"1, 3, 6-8"` (comma + space). Adjust if strict CSV format is required.  
- For long-term maintenance, consider migrating to Maven or Gradle for dependency management.

---

## Author

Banele Mdluli
