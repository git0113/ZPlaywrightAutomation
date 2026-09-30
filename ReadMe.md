# Playwright Java Automation Framework

A scalable and maintainable UI Automation Framework built using **Java**, **Playwright**, **Maven**, and **Page Object Model (POM)**.

The objective of this project is to demonstrate enterprise-level automation framework design while following clean coding practices and industry standards.

---

# Tech Stack

| Technology | Purpose |
|------------|---------|
| Java | Programming Language |
| Maven | Dependency Management |
| Playwright | Browser Automation |
| Selenium | UI Automation (Future Support) |
| TestNG | Test Execution |
| JUnit | Unit Testing |
| Cucumber | BDD Testing |
| Apache POI | Excel Read/Write |
| Log4j2 | Logging |
| Git | Version Control |

---

# Project Structure

```
Playwright
│
├── logs
│   └── automation.log
│
├── reports
│
├── screenshots
│
├── src
│   ├── main
│   │   ├── java
│   │   │
│   │   ├── pageobjects
│   │   ├── pageinteractions
│   │   ├── utils
│   │   ├── base
│   │   └── commonutilities
│   │
│   │
│   └── resources
│       ├── log4j2.xml
│       └── config.properties
│
├── pom.xml
│
└── README.md
```

---

# Framework Features

- Page Object Model (POM)
- Playwright Browser Automation
- Maven Dependency Management
- Logging using Log4j2
- Utility Classes
- Base Framework
- External Test Data Support
- Screenshot Capture (Upcoming)
- Reporting (Upcoming)
- Excel Integration (Upcoming)
- JSON Support (Upcoming)
- Parallel Execution (Upcoming)
- CI/CD Integration (Upcoming)

---

# Logging

## Why Logging?

Logging is used to record the execution flow of automation tests.

It helps in:

- Debugging failures
- Understanding execution flow
- Identifying application issues
- Maintaining execution history

---

## Logging Framework

This project uses **Apache Log4j2**.

### Maven Dependencies

```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.25.1</version>
</dependency>

<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.25.1</version>
</dependency>
```

---

## Configuration File

```
src/main/resources/log4j2.xml
```

The XML file defines:

- Where logs are stored
- Log format
- Log level
- Output destination

---

## Appenders

Appenders define **where logs should be written**.

This framework uses:

- Console Appender
- File Appender

---

## Console Appender

Displays logs directly in the IDE console.

Example:

```
INFO Launching Browser
INFO Navigating to Login Page
INFO Login Successful
```

---

## File Appender

Stores logs inside

```
logs/automation.log
```

This allows execution history to be reviewed even after the application has finished.

---

## Pattern Layout

```
%d{HH:mm:ss} %-5level %c{1} - %msg%n
```

| Pattern | Description |
|----------|-------------|
| %d | Date & Time |
| %level | Log Level |
| %c | Class Name |
| %msg | Log Message |
| %n | New Line |

---

## Log Levels

| Level | Description |
|---------|------------|
| TRACE | Detailed execution |
| DEBUG | Debug information |
| INFO | General execution information |
| WARN | Warning messages |
| ERROR | Errors |
| FATAL | Critical failures |

---

## Root Logger

```
<Root level="info">
```

This tells Log4j2 to record all logs with INFO level and above.

---

## Example Usage

```java
private static final Logger logger =
        LogManager.getLogger(LoginPage.class);

logger.info("Launching Browser");
logger.info("Entering Username");
logger.info("Clicking Login");
logger.info("Login Successful");
```

Example Output

```
10:20:14 INFO LoginPage - Launching Browser
10:20:17 INFO LoginPage - Entering Username
10:20:19 INFO LoginPage - Clicking Login
10:20:20 INFO LoginPage - Login Successful
```

---

# Upcoming Features

- Excel Utility (Apache POI)
- Config Reader
- JSON Reader
- Screenshot Utility
- Reporting
- Retry Mechanism
- Wait Utility
- Browser Factory
- Parallel Execution
- Jenkins Integration
- GitHub Actions
- Docker Support

---

# Author

**Sandeep Swamynathan**

Java | Playwright | Selenium | Automation Engineer