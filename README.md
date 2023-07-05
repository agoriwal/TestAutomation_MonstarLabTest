[![SeleniumHQ](http://www.seleniumhq.org/images/big-logo.png)](http://www.seleniumhq.org/)
# Selenium-Cucumber BDD Automation Framework

The purpose of the project is to display BDD framework for mall.cz website using combination of leading edge tools like Selenium and Cucumber

## Tools & Technologies

* JDK 20 (make sure Java class path is set)
* Automation tools : Selenium Web Driver and Cucumber
* Project Setup : Apache Maven (make sure .m2 class path is set)
* IntelliJ/Eclipse IDE
* IntelliJ/Eclipse Plugin
    * Maven
    * Cucumber-java
    * Gherkin
* Object Repository Design Pattern : Page Object Model
* CI/CD : Jenkins pipeline

### Way to configure Maven (Windows OS)
<details>
  <summary>Click to view instructions</summary>

1. Download Maven .zip file for Windows from [here](https://maven.apache.org/download.cgi)
2. Extract the .zip folder to default location which is C:\Program Files
3. Go to Environment Variables in System properties Advanced tab
4. Create new MAVEN_HOME variable and point it to folder where maven is in Program Files in C:\
5. In System variable find PATH click on edit button. In "Edit environment variable" dialog click on new button and add Maven bin (%MAVEN_HOME%\bin) to PATH, click on OK button and save the changes
6. To verify Maven is installed, type:
```
mvn --version
```
</details>

## Project Structure

![img.png](img.png)

**src.main.java**:- It is used to declare enums and interfaces

**src.main.java.enums**:- It has two classes which are Browsers (contains browser information) and OS (contains operating system details)

**src.main.java.interfaces**:- It has one interface name iConfigReader which contains abstract methods and implemented in ConfigFileReader class in Utils package

**src.test.java**:- It contains .feature files, step definitions, page objects, runners, helper, utils, Driver Handler and Hooks classes.

**src.test.java.base**:- It contains DriverHandler class which is used to initialise a browser and close browser.

**src.test.java.base**:- It contains WaitHelper class which consists methods used to handle Synchronization in test execution.

**src.test.java.pageObjects**:- It has to do application related pages and pages contains object repository, actions to perform on objects.

**src.test.java.runner**:- This packages has the class which run the feature files accordingly to the test cases. In this package we can call the feature files.
                           Runner class call the cucumber feature file by adding @CucumberOptions annotation (which is used to configuration for feature file).

**src.test.java.steps**:- This package contains StepDefinition file according to feature file. It has methods as steps in the file, in that we have to write code for implementation.

**src.test.java.utils**:- It contains class to perform utility functions.

**sec.test.java.resources.features**:- In this package you can create all the feature files which has steps to be followed in Automation script.

configs : - This folder contains .properties files.

drivers :- This folder contains driver executable files like chromedriver, geckodriver, etc.

reports :- ExtentReport generated after test execution.

![img_1.png](img_1.png)

* Pom.xml :- It will include all dependencies and download automatically in its repository.

# How to setup and run the project :-
We are you Maven as build tool, so it has pom.xml file. This file has all the configuration of the project. We have all the libraries in that .xml file. Following are the steps to run the project.

## How to configure the project :-
In terminal:
```
https://github.com/agoriwal/TestAutomation_MonstarLabTest.git
```

* Import project :- First you have to import the project in Eclipse/IntelliJ IDE. Select project setup path for build.
* Open IDE > go to file > click on import link.
* Project Path :- You have to select proper project path. Project path should be your project location where .setting and pom.xml file exist. Import existing maven project an click on next button.
* Select the root directory the project is and Click Finish.

In terminal, change directory to the location of cloned project folder and run below Maven commands :-

```
mvn clean
```
To run the test
```
mvn clean verify
```
* After test execution is completed you will find report in target folder (/target/cucumber-html-reports)
    Open overview-features.html in the browser.

![img_2.png](img_2.png)![img_3.png](img_3.png)


