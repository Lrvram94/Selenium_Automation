# Selenium Test Automation Framework

A Selenium WebDriver automation framework using Java, TestNG, and Page Object Model (POM) design pattern for testing web applications.

## Project Structure

```
Selenium_Project/
│
├── .github/
│   └── workflows/
│       └── maven-tests.yml          # GitHub Actions CI/CD workflow
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/               # Page Object Model classes
│   │   │   │   ├── BasePage.java
│   │   │   │   └── Elements.java
│   │   │   └── utils/               # Utility classes
│   │   │       ├── ConfigReader.java
│   │   │       ├── DriverManager.java
│   │   │       └── TestUrls.java
│   │   └── resources/
│   │       └── config.properties    # Configuration file
│   │
│   └── test/
│       └── java/
│           └── tests/               # Test classes
│               ├── BaseTest.java
│               └── ElementsTest.java
│
├── target/
│   └── surefire-reports/           # Test execution reports
│
├── testng.xml                       # TestNG suite configuration
├── pom.xml                          # Maven dependencies
├── mvnw & mvnw.cmd                  # Maven wrapper scripts
└── README.md
```

## Technologies Used

- **Java 21**
- **Selenium WebDriver 4.16.1**
- **TestNG 7.8.0**
- **WebDriverManager 5.6.3** - Automatic browser driver management
- **Maven** - Build and dependency management

## Prerequisites

- Java JDK 21 or higher
- Chrome, Firefox, or Edge browser installed
- IDE (IntelliJ IDEA, Eclipse, or VS Code) - optional

> **Note:** Maven installation is NOT required - this project includes Maven wrapper.

## Getting Started

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd Selenium_Project
   ```

2. **Verify Java installation**
   ```bash
   java -version
   ```

3. **Build the project**
   
   Windows:
   ```bash
   .\mvnw.cmd clean install
   ```
   
   Mac/Linux:
   ```bash
   ./mvnw clean install
   ```

## Running Tests

### Using Maven Wrapper (Recommended)

Windows:
```bash
.\mvnw.cmd test
```

Mac/Linux:
```bash
./mvnw test
```

### Using TestNG XML Suite

```bash
.\mvnw.cmd test -DsuiteXmlFile=testng.xml
```

### Run with Specific Browser

```bash
.\mvnw.cmd test -Dbrowser=chrome   # default
.\mvnw.cmd test -Dbrowser=firefox
.\mvnw.cmd test -Dbrowser=edge
```

## Configuration

Edit `src/main/resources/config.properties`:

```properties
# Browser Configuration
browser=chrome                    # Options: chrome, firefox, edge

# Application URL
baseUrl=https://demoqa.com

# Timeout Configuration (in seconds)
implicitWait=10
explicitWait=15
pageLoadTimeout=30
```

## CI/CD Integration

This project includes a GitHub Actions workflow (`.github/workflows/maven-tests.yml`) that:
- Runs tests automatically on push/pull requests to main, master, and develop branches
- Supports manual workflow dispatch
- Uses Ubuntu latest with Chrome
- Uploads test reports as artifacts (30-day retention)

## Test Reports

After test execution, view reports at:
- `target/surefire-reports/index.html`

Windows:
```bash
start target/surefire-reports/index.html
```

Mac:
```bash
open target/surefire-reports/index.html
```

Linux:
```bash
xdg-open target/surefire-reports/index.html
```

## Framework Features

- ✅ **Page Object Model (POM)** - Clean separation of test logic and page elements
- ✅ **WebDriverManager** - No manual driver downloads required
- ✅ **ThreadLocal WebDriver** - Thread-safe for parallel execution
- ✅ **Externalized Configuration** - Easy environment management
- ✅ **Explicit Waits** - Stable and reliable test execution
- ✅ **TestNG Integration** - Powerful test orchestration and reporting
- ✅ **CI/CD Ready** - GitHub Actions workflow included
- ✅ **Cross-Browser Support** - Chrome, Firefox, and Edge

## Adding New Tests

1. **Create Page Object:**
   - Add new class in `src/main/java/pages/`
   - Extend `BasePage` for reusable methods
   - Define web elements using `@FindBy` annotations

2. **Create Test Class:**
   - Add new class in `src/test/java/tests/`
   - Extend `BaseTest` for automatic setup/teardown
   - Write test methods with `@Test` annotation

3. **Update TestNG Suite:**
   - Add test class to `testng.xml` if needed

## Project Highlights

- Modern Page Object Model implementation
- Clean, maintainable code structure
- Industry-standard design patterns
- Automated CI/CD pipeline
- Comprehensive test reporting
