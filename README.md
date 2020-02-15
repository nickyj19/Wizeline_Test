# Wizeline_Test

- Environments:
 1. macOSversion: Mojave - version 10.14.5.
 2. ChromeDriver version: Version 80.0.3987.106 (Official Build) (64-bit).
 3. Programming Language & Tools: Java, Eclipse IDE for Java Developers (Version: 2019-12 (4.14.0)).
 4. Others version like Junit... you can check on "pom.xml" file.
 5. Project Type: Maven Project.

- I created a BDD framework with the structure like below:
 1. Folder features contains all feature files.
 2. Folder objectRepository contains all object repositories for specific page.
 3. Folder pages contains all of pages.
 4. Folder resources contains chromedriver.exe file.
 5. Folder runner contains Runner class to run specific feature file and point to the step to run steps.
 6. Folder steps contains all of steps for specific page.
 7. Folder utility contains common actions like click(), getText().....

- Instruction:
 Step 1: Access to Runner class then right click -> Run as -> JUnit.
 Step 2: Observe the actions and results.
=> Scenario 1 to verify step 1 successfully at utest page will run first then it gonna run for 
   Scenario 2: invalid email with 2 examples data.
   
- My final testing results:
  1. 3 Scenarios (3 passed)
  2. 21 Steps (21 passed)
  3. 0m44.652s

