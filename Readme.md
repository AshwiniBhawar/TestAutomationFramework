
# Test Automation Framework

This is a Java-based test automation framework. 

The framework leverages various libraries and tools to facilitate data-driver testing, logging, reporting, and integration with cloud-based testing platforms like lambdatest.

## Author

- Ashwini Bhawar
- EmailAddress: bhawar.ashwini@gmail.com
- [@LinkedIn](https://www.linkedin.com/in/ashwini-bhawar-421020b6/)


## 🔗 Links

[![portfolio](https://img.shields.io/badge/my_portfolio-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/AshwiniBhawar)

[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/ashwini-bhawar-421020b6/)


## 🚀 About Me
Hi, My Name is Ashwini Bhawar. I have 7 years of experience in Functional Manual and Automation Testing using Selenium WebDriver, RestAssured.
My major experties is in Java Programming Language.

## Prerequisite

Before running this framework, ensure the following software is installed on your system:

- **Java 17** - make sure java is installed and the Java_Home enviornment variable is set.

- **Maven** - Ensure Maven is installed and added to the system path.
Download Link: https://maven.apache.org/download.cgi

## Features

- Data-Driven Testing: Using OpenCSV, Apache POI, and Gson for reading test data from CSV and Excel files and JSON.
- Cross-Browser Testing: Supports running tests on different browsers.
- Headless Mode: Faster execution by running tests in headless mode.
- Cloud Testing: Integrated with LambdaTest to run tests on the cloud.
- Logging: Uses Log4j for detailed logs.
- Reporting: Generates detailed reports using Extent Reports.

## Technologies Used

- Java 11
- TestNG
- OpenCSV
- Gson
- Apache POI
- Faker
- LambdaTest
- Log4j
- Extent Reports

## Installation

Install my-project with npm

```bash
  npm install my-project
  cd my-project
```

## Setup Instructions

- **Clone the Repository:**

```bash
  git clone https://github.com/AshwiniBhawar/TestAutomationFramework.git

  cd Test-Automation-Framework
```
- **Running Tests on LambdaTest:**

```bash
     mvn test  -Dbrowser=chrome -DisLambdaTest=true -DisHeadless=false -X
```

- **Running Tests on Chrome browser on Local Machine in Headless Mode:**

```bash
     mvn test  -Dbrowser=chrome -DisLambdaTest=false -DisHeadless=true -X   
```

## Reports

After execution, a detailed HTML report will be generated at ./ExtentReport.html

The report contains information on test cases executed, passed, failed, and skipped, along with screenshots for failed tests.

## Logs
Logs are created during the test execution and stored in the ./logs/ directory.

## Integrated the project Github Actions

This automation framework is integrated with github actions. The tests will be executed at 11:30PM IST every single day.

The reports will be archieved in gh-pages branch You can view the html reports at : https://github.com/AshwiniBhawar/TestAutomationFramework/ExtentReport.html
