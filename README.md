# Selenium Framework

Hybrid Selenium automation framework using **Java, TestNG, Maven, and Cucumber**, designed with **Page Object Model (POM)**, **Data-Driven Testing (DDT)**, and **Behavior-Driven Testing (BDT)**, and integrated with **Jenkins** for CI/CD. This project demonstrates a complete end-to-end e-commerce testing workflow including login, product search, add to cart, and checkout.

## 🚀 Features
- End-to-end e-commerce test scenarios  
- Login, searching, adding to cart, and checkout workflows  
- Page Object Model (POM) for better test structure  
- Data-Driven Testing (DDT) with TestNG DataProviders  
- Behavior-Driven Testing (BDT) using Cucumber (Gherkin syntax)  
- Jenkins CI/CD integration for automated test runs  
- Reports, logs, and screenshots on test failures  

## 🛠️ Tech Stack

| Tool/library | Purpose |
| ---- | ---- |
| **Java**             | Main programming language              |
| **Selenium WebDriver** | Browser automation                   |
| **TestNG**           | Test execution, grouping, parallelization |
| **Cucumber**         | BDD framework (feature files in Gherkin) |
| **Maven**            | Dependency management, build tool       |
| **Jenkins**          | Continuous integration & scheduling     |

## 📂 Project Structure
```plaintext
selenium-framework/
├── pom.xml                # Maven configuration
├── testng.xml             # TestNG suite
├── cucumberRunner.xml     # Cucumber test suite
├── src/
│   ├── main/
│   └── test/
│       ├── pages/         # Page Object classes
│       ├── steps/         # Step definitions for Cucumber
│       ├── tests/         # TestNG test classes
│       └── utils/         # Utilities (data providers, helpers, etc.)
├── drivers/               # WebDriver executables
├── screenshots/           # Captured screenshots (on failure)
└── README.md              # Project documentation
```
## ⚙️ Getting Started

### 1️⃣ Clone the repository
```bash
git clone https://github.com/TheGreatEtsh/selenium-framework.git
cd selenium-framework
```
### 2️⃣ Install dependencies
```bash
mvn clean install
```
### 3️⃣ Run the project
```bash 
npm start     # or python main.py, or mvn test
```

### 4️⃣ Run tests

Run TestNG suite:
```bash
npm start     # or python main.py, or mvn test
```
