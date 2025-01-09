
### Clone the repository
```
git clone https://github.com/ralfsgit/BTA_Automation_task.git
```

### Install maven dependencies
```
mvn clean install
```

## Executing Tests

### Run the tests
```
mvn clean test
```

#### The tests will be executed on Chrome by default.
### Running tests on different browsers
```
mvn clean test -Dselenide.browser={browser_name}
```
For example:
```
mvn clean test -Dselenide.browser=firefox

## Reporting
After test execution Allure test results are generated automatically in `target/allure-results`
#### To see the HTML report:
```
mvn allure:serve
```
After executing this command a HTML page will be opened containing all the test results
#### By default a json report is also generated in `target/reports/cucumber-reports/cucumber.json`

