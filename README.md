# Planetarium Testing Project  

Welcome to the Planetarium Testing Project repository! This project is part of my Test Automation Engineer training with Revature. It focuses on testing a Planetarium application, ensuring the functionality and reliability of key features such as user authentication, planetary management, and privacy controls.  

## Table of Contents  
- [Project Overview](#project-overview)  
- [Features Tested](#features-tested)  
- [Tools and Technologies](#tools-and-technologies)  
- [Installation and Setup](#installation-and-setup)  
- [Usage](#usage)  
- [Bug Fixes](#bug-fixes)    

## Project Overview  

The Planetarium Testing Project is an automation testing suite designed to verify and validate the functionality of the Planetarium application. This includes ensuring the security and efficiency of key workflows such as login, registration, and the addition/deletion of planets and moons.  

## Features Tested  

1. **User Authentication**:  
   - Testing login and registration functionalities for valid and invalid inputs.  

2. **Planet Management**:  
   - Adding and deleting planets.  
   - Ensuring accurate validation for planet details.  

3. **Moon Management**:  
   - Adding and deleting moons.  
   - Testing moon visibility and ensuring privacy settings prevent unauthorized access.  

4. **File Upload Validation**:  
   - Verifying the file upload feature accepts only valid file types and provides appropriate error messages.  

## Tools and Technologies  

- **Programming Language**: Java  
- **Automation Framework**: Selenium  
- **Behavior-Driven Development (BDD)**: Cucumber  
- **Project Management**: JIRA  
- **Other Tools**: Maven, JUnit  

## Installation and Setup  

1. Clone this repository to your local machine:  
   ```bash
   git clone https://github.com/drijal/Planetarium.git
   ```  

2. Navigate to the project directory:  
   ```bash
   cd Planetarium
   ```  

3. Install dependencies using Maven:  
   ```bash
   mvn clean install
   ```  

4. Run the `planetarium.jar` file in Git Bash to start the Planetarium application backend:  
   ```bash
   java -jar planetarium.jar
   ```   

## Usage  

Run the test suite using the test runner file   
View test results in the console or in the generated reports (e.g., Cucumber HTML reports).  

## Bug Report  

During the project, I identified the following bugs:  
1. **Incorrect Browser Alerts**: Fixed alert messages triggered incorrectly for valid actions.  
2. **File Upload Issues**: Resolved issues with the file upload feature not accepting valid file types.  
3. **Privacy Violation**: Prevented users from viewing moons that were not their own.  


