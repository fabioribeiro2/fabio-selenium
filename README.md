# fabio-selenium

This is a scalable, threaded, fully dynamic UI Framework for testing your Front End Project!
At the moment of this writing, this framework tests the Signup, Login and Profile features of the website https://waesworks.bitbucket.io/

## Getting Started

To use it locally or on your CI-CD solution, first clone this project, then run the following command:

mvn test -Dcucumber.options='--tags "@all"'

That's it! You're up and running!

### Prerequisites

To run this, you will need:

Java 8
Apache Maven 3.3.9
Git 2.7.4

### Reporting:

An Html report containing the results of your executions will be saved at /YOUR_REPOS/fabio-selenium/target/cucumber-reports/index.html

### Configuring the framework on the fly

The framework accepts the following configurations:

-Dcucumber.numthreads
-Dcucumber.seleniumDriver
-DimplicitTimeoutSeconds
-Dcucumber.options

So, to run your tests on all tags (features) with Firefox, using 3 threads, and with an implicit wait of 15 seconds, use the following command:

mvn test -Dcucumber.options='--tags "@all"' --Dcucumber.numthreads=3 -Dcucumber.seleniumDriver=firefox -DimplicitTimeoutSeconds=15

Enjoy!