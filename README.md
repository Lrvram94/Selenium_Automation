# Selenium Automation Project

A Selenium WebDriver automation framework using Java and Page Object Model (POM) design pattern.

## Project Structure

```
Selenium_Project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/          # Page Object classes
│   │   │   │   └── BasePage.java
│   │   │   └── utils/          # Utility classes
│   │   │       ├── DriverManager.java
│   │   │       └── ConfigReader.java
│   │   └── resources/
│   │       └── config.properties
│   └── test/
│       └── java/
│           └── tests/          # Test classes
│               └── BaseTest.java
├── testng.xml                  # TestNG suite configuration
├── pom.xml                     # Maven dependencies
└── README.md
```

## Technologies Used

- **Java 11**
- **Selenium WebDriver 4.16.1**
- **TestNG 7.8.0**
- **WebDriverManager 5.6.3**
- **Maven**

## Setup Instructions

1. **Prerequisites:**
   - Install Java JDK 11 or higher
   - Install Maven
   - Install an IDE (IntelliJ IDEA, Eclipse, or VS Code)

2. **Clone or download the project**

3. **Install dependencies:**
   ```bash
   mvn clean install
   ```

4. **Configure test settings:**
   - Update `src/main/resources/config.properties` with your application URL and browser preference

## Running Tests

### Using Maven:
```bash
mvn clean test
```

### Using TestNG XML:
```bash
mvn test -DsuiteXmlFile=testng.xml
```

## Configuration

Edit `config.properties` to customize:
- Browser type (chrome, firefox, edge)
- Base URL
- Timeout values

## Framework Features

- **Page Object Model (POM)** design pattern
- **WebDriverManager** for automatic driver management
- **ThreadLocal** driver instance for parallel execution support
- **Centralized configuration** management
- **Reusable utility methods** in BasePage
- **TestNG** for test execution and reporting

## Adding New Tests

1. Create page objects in `src/main/java/pages/`
2. Extend `BasePage` for common web element interactions
3. Create test classes in `src/test/java/tests/`
4. Extend `BaseTest` for automatic setup and teardown

## Contact

For questions or issues, please contact the project maintainer.
