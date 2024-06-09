# Test Framework

This is a small automation framework for supporting WEB UI tests for Povio web page: https://povio-at.herokuapp.com/

## Technologies:

- Kotlin : Test Code
- KtLint : Project Linter
- Selenium : Web Testing
- TestNG : Test Runner.

## Quick start 

**Install Pre-Req Tools**
1. Install IntelliJ IDEA or any other IDE you prefer: https://www.jetbrains.com/help/idea/installation-guide.html
2. Install Java on your machine: https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html
3. Install Apache Maven: https://maven.apache.org/install.html

```shell
# Run command to check that you successfully installed Maven

mvn --version
```
4. Clone this project
5. Import project in your IntelliJ and start editing and executing tests.

## What's inside?

1. **`web`**: This directory contains all of the necessary files for WEB tests
2. **`factory`**: This directory contains Driver Manager setup for both supported browsers: Chrome and Firefox. For regulation of browsers versions we are using Selenium Manager, so this compatibility is managed by Selenium Manager.
3. **`pages`**: This directory contains page objects that represent the various web pages of application, including their elements and interactions.
4. **`testcases`**: This directory contains our WEB UI tests.
5. **`WebBasePage`**: This class contains base functions that are used for interaction with pages and elements.
6. **`WebBaseTest`**: This class contains driver setup, and also quiting driver at the end.

## How to run tests?
With this implementation we are able to run tests on two browsers:
* Chrome
* Firefox

By default we are running tests on Chrome.

We have two ways to run tests:
1. Maven command
```shell
# Run command to start executing tests

mvn test -Dbrowser=$browserName
```
For `browser` we can set two values `chrome` and `firefox`. This parameter is not mandatory, we can run tests without this parameter, and by default our tests will be executed on Chrome.

2. Using VM options 
* In your InteliJ in the main menu, go to Run -> Edit Configurations.
* Add new configuration
* Choose TestNG
* Add your desired name of the configurations
* Test kind: All in package
* Package: web/testcases
* In VM options we can again use `browser` parameter if we want.
* Click on Listeners -> Add `EmailableReporter` option. This will generate HTML report.
* HTML report can be found in the directory: `test-output`

# HTML Report Example
![example_report](https://github.com/dzankec7/testFrameworkPovio/assets/79761464/b4754785-64d5-4601-b8ef-009c53635afb)


