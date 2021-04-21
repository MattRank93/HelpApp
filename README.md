<!--
*** Thanks for checking out Spring Boot Application Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Thanks again!
-->

[comment]: <> (# Highway Emergency Location Platform )
<div align="center" spacing="5">
<a href="https://imgur.com/o56PeaZ"><img src="https://i.imgur.com/o56PeaZ.png" title="source: imgur.com" /></a>
</div>
<div align="center">
Highway Emergency Location Platform

</div>


<div align="center">

<br>

<div align="center">
  <sub>Built with ❤︎ by <a href="https://github.com/kayleqb">Quincy Kayle</a> and <a href="https://github.com/MattRank93">Matthew Rank</a>
</div>



<p align="center">
	<a href="https://documenter.getpostman.com/view/13688383/TVmLCyby#61200d8c-9d42-4cb3-9dc7-b96fa7dca8c2"><strong>Explore the docs »</strong></a>
	<br />
	<br />

</p>

<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
-->

## Important Note: This app in not yet complete, expect MVP soon

<!-- TABLE OF CONTENTS -->
## Table of Contents

<details open="open">
   <ul>
      <li><a href="#application-screenshots">Application screenshots</a></li>
      <li>
         <a href="#technology-stack---other-open-source-libraries">Technology stack &amp; other Open-source libraries</a>
         <ul>
            <li><a href="#data">Data</a></li>
            <li><a href="#client---frontend-ui">Client - Frontend/UI</a></li>
            <li><a href="#server---backend">Server - Backend</a></li>
            <li><a href="#libraries-and-plugins">Libraries and Plugins</a></li>
            <li><a href="#others">Others</a></li>
            <li><a href="#external-tools---services">External Tools &amp; Services</a></li>
         </ul>
      </li>
      <li><a href="#features-and-to-do">Features and To-Do</a></li>
      <li>
         <a href="#getting-started">Getting Started</a>
         <ul>
            <li><a href="#prerequisites">Prerequisites</a></li>
            <li><a href="#eer-diagram">EER Diagram</a></li>
         </ul>
      </li>
      <li>
         <a href="#installing">Installing</a>
         <ul>
            <li><a href="#running-the-application-with-ide">Running the application with IDE</a></li>
            <li><a href="#running-the-application-with-maven">Running the application with Maven</a></li>
            <li>
               <a href="#running-the-application-with-executable-jar">Running the application with Executable JAR</a>
               <ul>
                  <li>
                     <a href="#accessing-data-in-h2-database">Accessing Data in H2 Database</a>
                     <ul>
                        <li><a href="#h2-console">H2 Console</a></li>
                     </ul>
                  </li>
               </ul>
            </li>
            <li><a href="#running-the-application-via-docker-container">Running the application via docker container</a></li>
         </ul>
      </li>
      <li>
         <a href="#deployment">Deployment</a>
      </li>
      <li>
         <a href="#code-coverage">Code Coverage</a>
         <ul>
            <li><a href="#cobertura">Cobertura</a></li>
         </ul>
      </li>
      <li>
         <a href="#testing-api">Testing API</a>
         <ul>
            <li><a href="#testing-with-postman-runner">Testing with Postman Runner</a></li>
            <li><a href="#testing-with-maven">Testing with Maven</a></li>
            <li><a href="#basic-load-testing">Basic Load Testing</a></li>
         </ul>
      </li>
      <li><a href="#security">Security</a></li>
      <li><a href="#explore-rest-apis">Explore Rest APIs</a></li>
      <li><a href="#documentation">Documentation</a></li>
      <li><a href="#internationalization--i18n-">Internationalization (i18n)</a></li>
      <li>
         <a href="#files-and-directories-structure">Files and Directories Structure</a>
      </li>
      <li><a href="#reporting-issues-suggest-improvements">Reporting Issues/Suggest Improvements</a></li>
	  <li><a href="#changelog">Changelog</a></li>
      <li><a href="#the-end">The End</a></li>
      <li><a href="#contributing">Contributing</a></li>
      <li><a href="#license">License</a></li>
      <li><a href="#fossa-third-party-code--license-compliance-and-vulnerabilities">FOSSA third-party code, license compliance and vulnerabilities</a></li>
      <li><a href="#contact">Contact</a></li>
   </ul>
</details>



## Technology stack & other Open-source libraries
### Database

<details open="open">
   <ul>
      <li><a href="https://flywaydb.org/">Flyway</a> - Version control for database</li>
      <li><a href="https://www.postgresql.org//">postgresql</a> - Open-Source Relational Database Management System</li>
      <li><a href="https://docs.oracle.com/javase/tutorial/jdbc/basics/index.html">JDBC</a> - Java SQL database. Embedded and server modes; in-memory databases</li>
   </ul>
</details>

### Client - Frontend/UI

<details open="open">
   <ul>
      <li><a href="https://getbootstrap.com/">Bootstrap</a> - Bootstrap is a free and open-source CSS framework directed at responsive, mobile-first front-end web development.</li>
      <li><a href="https://bootstrap-table.com/">Bootstrap Table</a> - An extended table to the integration with some of the most widely used CSS frameworks.</li>
      <li><a href="https://www.thymeleaf.org/">Thymeleaf</a> - Modern server-side Java template engine for both web and standalone environments.</li>
   </ul>
</details>

### Server - Backend

<details open="open">
   <ul>
      <li><a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">JDK</a> - Java™ Platform, Standard Edition Development Kit</li>
      <li><a href="https://spring.io/projects/spring-boot">Spring Boot</a> - Framework to ease the bootstrapping and development of new Spring Applications</li>
      <li><a href="https://maven.apache.org/">Maven</a> - Dependency Management</li>
      <li><a href="https://www.jsonwebtoken.io/">JSON Web Token</a> - Encode or Decode JWTs</li>
   </ul>
</details>

###  Libraries and Plugins

<details open="open">
   <ul>
      <li><a href="https://afeld.github.io/bootstrap-toc/">Bootstrap ToC</a> - Table of Contents plugin for Bootstrap</li>
      <li><a href="https://github.com/Antibrumm/thymeleaf-extras-with-dialect">Thymeleaf With Dialect</a> - A dialect for Thymeleaf that allows you to use attributes with a &quot;with&quot; prefix to avoid having long &quot;th:with&quot;-expressions.</li>
      <li><a href="https://github.com/ultraq/thymeleaf-layout-dialect">Thymeleaf Layout Dialect</a> - A dialect for Thymeleaf that lets you build layouts and reusable templates in order to improve code reuse.</li>
      <li><a href="https://projectlombok.org/">Lombok</a> - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.</li>
      <li><a href="https://swagger.io/">Swagger</a> - Open-Source software framework backed by a large ecosystem of tools that helps developers design, build, document, and consume RESTful Web services.</li>
      <li><a href="https://github.com/vladimir-bukhtoyarov/bucket4j">Bucket4j</a> - Java rate limiting library based on token/leaky-bucket algorithm.</li>
   </ul>
</details>

### Others

<details open="open">
   <ul>
      <li><a href="https://git-scm.com/">git</a> - Free and Open-Source distributed version control system</li>
      <li><a href="https://prometheus.io/">Prometheus</a> - Monitoring system and time series database</li>
	  <li><a href="https://github.com/spotify/dockerfile-maven">Dockerfile Maven</a> - This Maven plugin integrates Maven with Docker</li>
      <li><a href="https://www.docker.com/">Docker</a> - A set of platform as a service products that use OS-level virtualization to deliver software in packages called containers.</li>
   </ul>
</details>

### External Tools & Services

<details open="open">
   <ul>
      <li><a href="https://mailtrap.io/">Mailtrap</a> - Safe Email Testing for Staging &amp; Development.</li>
      <li><a href="https://www.getpostman.com/">Postman</a> - API Development Environment (Testing Docmentation)</li>
      <li><a href="https://docs.postman-echo.com/?version=latest">Postman Echo</a> - A service that can be used to test your REST clients and make sample API calls. It provides endpoints for GET, POST, PUT, various auth mechanisms and other utility endpoints.</li>
      <li><a href="https://travis-ci.org/github/Spring-Boot-Framework/Spring-Boot-Application-Template">Travis CI</a> - A hosted continuous integration service used to build and test software projects hosted at GitHub and Bitbucket.</li>
      <li><a href="https://codecov.io/gh/Spring-Boot-Framework/Spring-Boot-Application-Template">Codecov</a> - A hosted tool that is used to measure the test coverage of your codebase.</li>
      <li><a href="https://dependabot.com/">Dependabot</a> - Automated dependency updates.</li>
      <li><a href="https://fossa.com/">FOSSA</a> - Scalable, end-to-end management for third-party code, license compliance and vulnerabilities.</li>
      <li><a href="https://sonarcloud.io/dashboard?id=Spring-Boot-Framework_Spring-Boot-Application-Template">sonarcloud</a> - Cloud-based code analysis service designed to detect code quality issues continuously ensuring the maintainability, reliability and security of code.</li>
      <li><a href="https://www.toptal.com/developers/gitignore/api/java,eclipse,intellij">gitignore.io</a> - Create useful .gitignore files for your project.</li>
   </ul>
</details>

## Features and To-Do

<details open="open">
   <ul>
      <li>[x] Logger (Console, File)</li>
      <li>[x] <a href="https://spring.io/blog/2013/05/11/content-negotiation-using-spring-mvc">Content Negotiation</a></li>
      <li>[x] <a href="https://en.wikipedia.org/wiki/Light-on-dark_color_scheme">Dark Mode</a></li>
      <li>[x] <a href="https://spring.io/projects/spring-security">Spring Security</a> RBAC, Session Timeout</li>
      <li>[x] API <a href="https://en.wikipedia.org/wiki/Rate_limiting">Rate Limiting</a></li>
      <li>[x] <a href="https://docs.spring.io/spring-data/jpa/docs/1.7.0.DATAJPA-580-SNAPSHOT/reference/html/auditing.html">JPA Auditing via AuditorAware Interface</a></li>
      <li>[x] <a href="https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-profiles">Spring Profiles</a> (dev, production, qa, staging, test)</li>
      <li>[x] <a href="https://www.docker.com/">Docker</a></li>
      <li>[x] <a href="https://docs.spring.io/spring-boot/docs/2.1.6.RELEASE/reference/html/boot-features-caching.html">Caching</a></li>
      <li>[x] <a href="https://en.wikipedia.org/wiki/HATEOAS">HATEOS (Hypermedia as the Engine of Application State)</a></li>
      <li>[x] Software documentation - <a href="https://swagger.io/">Swagger</a>, <a href="https://en.wikipedia.org/wiki/Javadoc">Javadoc</a>, <a href="https://www.postman.com/collection/">Postman Collection</a></li>
      <li>[x] <a href="https://en.wikipedia.org/wiki/HTTPS">HTTPS</a> with <a href="https://en.wikipedia.org/wiki/Self-signed_certificate">(self-signed certificate)</a></li>
      <li>[x] <a href="https://www.jsonwebtoken.io/">JSON Web Token</a> based authentication</li>
      <li>[ ] Quartz Scheduler</li>
      <li>[ ] Multiple Databases</li>
      <li>[ ] <a href="https://www.jooq.org/">jOOQ</a></li>
      <li>[ ] Replace Docker with <a href="https://github.com/GoogleContainerTools/jib">jib</a></li>
      <li>[ ] Unit Tests, Integration Tests</li>
      <li>[ ] Shut down app on button click via actuator url </li>
      <li>[ ] Spring Boot Admin</li>
      <li>[ ] NoSQL (MongoDB)</li>
      <li>[ ] Multitenancy</li>
      <li>[ ] Micrometer</li>
      <li>[ ] Grafna</li>
      <li>[ ] Spring Retry</li>
   </ul>
</details>

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

*	To activate the accounts of registered users, an email with activation link is sent to the email provided during the user signup stage. An **SMTP** is required for the same.

	[Mailtrap](https://mailtrap.io/) or any other service like **Gmail**, etc., can be used to create an SMTP.
	
	update the **springMailHost**, **springMailPort**, **springMailProtocol**, **springMailUsername** and **springMailPassword** details in the **application_settings** section of **/resources/data/mysql/migrations/V0_0_4__populate_data.sql**

*	You need to have **MySQL** installed on your machine to run the application in **`dev`** profile. Using the `MySQL Workbench` or on any other MySQL client/console, create a database/schema named `sbat`.

~~~sql
-- create schema
CREATE SCHEMA sbat;

-- use schema
USE sbat;

-- Create user 
create user 'sbat'@'localhost' identified by 'sbat';

-- Grant privileges to user
grant all privileges on *.* to 'sbat'@'localhost' with grant option;
~~~

After creating the database/schema, you need to add your **MySQL** `username` and `password` in the `application-dev.properties` file on `src/main/resource`. The lines that must be modified are as follows:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/sbat?useSSL=false&allowPublicKeyRetrieval=true
spring.datasource.username=sbat
spring.datasource.password=sbat
```

*	A Java Keystore File is required to generate JSON Web Token.

```shell
keytool -genkey -alias redditclone -keyalg RSA -keystore redditclone.jks -keysize 2048
```

<img src="documents\images\settings\reddit-clone-jks-generation.PNG"/>

### EER Diagram

* 	Refer to [ARCHITECTURE.md](documents/ARCHITECTURE.md) for details.

## Installing

*	Default active profile is **`test`**. When the application is running, **Flyway** will create the necessary tables and system data along with sample data. In the **`test`** profile, the application uses **H2** database (data in memory).

* 	URL to access application UI: **http://localhost:8080/sbat/index** or **https://192.168.99.102:8080/sbat/index** if **SSL** is enabled.

* 	Other sample profiles like **`dev`**, **`production`**, **`qa`**, and  **`staging`** are available. Change the **spring.profiles.active** property in the **application.properties** file to any of the aforementioned profiles to use it.

*	To enable or disable **SSL** support, in the **application properties** file turn **server.ssl.enabled** to **true** or **false**

#### Running the application with IDE

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.arc.sbtest.SBtemplateApplication` class from your IDE.

* 	Download the zip or clone the Git repository.
* 	Unzip the zip file (if you downloaded one)
* 	Open Command Prompt and Change directory (cd) to folder containing pom.xml
* 	Open Eclipse
     * File -> Import -> Existing Maven Project -> Navigate to the folder where you unzipped the zip
     * Select the project
* 	Choose the Spring Boot Application file (search for @SpringBootApplication)
* 	Right Click on the file and Run as Java Application

#### Running the application with Maven

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
$ git clone https://github.com/Spring-Boot-Framework/Spring-Boot-Application-Template.git
$ cd Spring-Boot-Application-Template
$ mvn spring-boot:run
```

#### Running the application with Executable JAR

The code can also be built into a jar and then executed/run. Once the jar is built, run the jar by double clicking on it or by using the command

```shell
$ git clone https://github.com/Spring-Boot-Framework/Spring-Boot-Application-Template.git
$ cd Spring-Boot-Application-Template
$ mvn package -DskipTests
$ java -jar target/SBtemplate-0.0.1-SNAPSHOT.jar --spring.profiles.active=test
```

To shutdown the jar, follow the below mentioned steps on a Windows machine.

*	In command prompt execute the **jcmd** command to print a list of all running Java processes
*	**Taskkill /PID PROCESS_ID_OF_RUNNING_APP /F** execute this command by replacing the **PROCESS_ID_OF_RUNNING_APP** with the actual process id of the running jar found out from executing the previous command

##### Accessing Data in H2 Database

###### H2 Console

URL to access H2 console: **http://localhost:8080/h2-console/login.jsp** or **https://192.168.99.102:8080/h2-console/login.jsp** if **SSL** is enabled.

Fill the login form as follows and click on Connect:

* 	Saved Settings: **Generic H2 (Embedded)**
* 	Setting Name: **Generic H2 (Embedded)**
* 	Driver class: **org.h2.Driver**
* 	JDBC URL: **jdbc:h2:mem:sbat;MODE=MySQL**
* 	User Name: **sa**
* 	Password:

<img src="documents\images\h2db\h2-console-login.PNG"/>

<img src="documents\images\h2db\h2-console-main-view.PNG"/>

#### Running the application via docker container

* 	Refer to [DOCKER.md](documents/DOCKER.md) for details.

## Deployment

* 	Refer to [DEPLOYMENT.md](documents/DEPLOYMENT.md) for details.

## Code Coverage

### Cobertura

Generating code coverage reports

```shell
$ mvn cobertura:cobertura
```

This will create a detailed HTML style report showing code coverage statistics gathered via code instrumentation.

**Spring-Boot-Application-Template\target\site\cobertura**

## Testing API

### Testing with Postman Runner

Import the **Spring Boot Application Template API.postman_test_run** file into postman and run the API tests.

### Testing with Maven

*	Run only unit tests:

```shell
$ mvn clean test
```

### Basic Load Testing

Basic load testing for retrieving a `person` for a given `id` can be performed with the ApacheBench by executing the following command:

```shell
ab -n 10000 -c 100 -k http://localhost:8080/api/v1/person/1
```

* **-n 10000** is the number of requests to make
* **-c 100** is the number of concurrent requests to make at a time
* **-k** sends the **KeepAlive** header, which asks the web server to not shut down the connection after each request is done, but to instead keep reusing it

Result:

```
Benchmarking localhost (be patient)
Completed 1000 requests
Completed 2000 requests
Completed 3000 requests
Completed 4000 requests
Completed 5000 requests
Completed 6000 requests
Completed 7000 requests
Completed 8000 requests
Completed 9000 requests
Completed 10000 requests
Finished 10000 requests


Server Software:
Server Hostname:        localhost
Server Port:            8080

Document Path:          /api/v1/person/1
Document Length:        132 bytes

Concurrency Level:      100
Time taken for tests:   9.213 seconds
Complete requests:      10000
Failed requests:        0
Non-2xx responses:      10000
Keep-Alive requests:    0
Total transferred:      5330000 bytes
HTML transferred:       1320000 bytes
Requests per second:    1085.38 [#/sec] (mean)
Time per request:       92.133 [ms] (mean)
Time per request:       0.921 [ms] (mean, across all concurrent requests)
Transfer rate:          564.95 [Kbytes/sec] received

Connection Times (ms)
              min  mean[+/-sd] median   max
Connect:        0    1   1.1      1      49
Processing:    13   91  30.1     85     523
Waiting:        0   68  29.3     65     472
Total:         14   91  30.1     85     523

Percentage of the requests served within a certain time (ms)
  50%     85
  66%     95
  75%    101
  80%    105
  90%    119
  95%    136
  98%    176
  99%    223
 100%    523 (longest request)
```

## Security

* 	Refer to [APP_SECURITY_AND_API.md](documents/APP_SECURITY_AND_API.md) for details.

## Explore Rest APIs

* 	Refer to [APP_SECURITY_AND_API.md](documents/APP_SECURITY_AND_API.md) for details.

## Documentation

* 	[Postman Collection](https://documenter.getpostman.com/view/2449187/TVCe1UAk) - online, with code auto-generated snippets in cURL, jQuery, Ruby,Python Requests, Node, PHP and Go programming languages
* 	Postman Collection for offline testing is available in the postman folder.
* 	[Swagger](http://localhost:8080/swagger-ui.html) - `http://localhost:8080/swagger-ui.html`- Documentation & Testing
* 	[Swagger](http://localhost:8080/v2/api-docs?group=Spring%20Boot%20Application%20Template) - `http://localhost:8080/v2/api-docs?group=Spring%20Boot%20Application%20Template`- Documentation & Testing
*	Find Java Doc in **javadoc** folder
* 	Java Doc is generated in `Spring-Boot-Application-Template\target\site\apidocs` folder using the Maven command

```text
`mvn javadoc:javadoc`                   //Generate JavaDoc
```

## Internationalization (i18n)

This app can be adapted to various languages and regions without engineering changes. Textual elements, such as status messages and the GUI component labels, are not hardcoded in the program. Instead they are stored outside the source code and retrieved dynamically.

Refer `io.github.anantharajuc.sbat.backend.config.I18Nconfiguration`. The text elements are stored in `\src\main\resources\i18n` folder.

## Files and Directories Structure

* 	Refer to [ARCHITECTURE.md](documents/ARCHITECTURE.md) for details.

## Reporting Issues/Suggest Improvements

This Project uses GitHub's integrated issue tracking system to record bugs and feature requests. If you want to raise an issue, please follow the recommendations below:

* 	Before you log a bug, please [search the issue tracker](https://github.com/AnanthaRajuC/Spring-Boot-Application-Template/search?type=Issues) to see if someone has already reported the problem.
* 	If the issue doesn't already exist, [create a new issue](https://github.com/AnanthaRajuC/Spring-Boot-Application-Template/issues/new)
* 	Please provide as much information as possible with the issue report.
* 	If you need to paste code, or include a stack trace use Markdown +++```+++ escapes before and after your text.

## Changelog

See [CHANGELOG.md](documents/CHANGELOG.md)

## The End

In the end, I hope you enjoyed the application and find it useful, as I did when I was developing it to create a Spring Boot web application template with good/convenient practices for rapid prototyping.

If you would like to enhance, please:

* 	**Open PRs**,
* 	Give **feedback**,
* 	Add **new suggestions**, and
*	Finally, give it a 🌟.

* Happy Coding ...* 🙂

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to be learn, inspire, and create. Any contributions you make are **greatly appreciated**.

Kindly refer to [CONTRIBUTING.md](/CONTRIBUTING.md) for important **Pull Request Process** details

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

Kindly follow [Conventional Commits](https://www.conventionalcommits.org/en/v1.0.0/) to create an explicit commit history. Kindly prefix the commit message with one of the following type's.

**build**   : Changes that affect the build system or external dependencies (example scopes: gulp, broccoli, npm)
**ci**      : Changes to our CI configuration files and scripts (example scopes: Travis, Circle, BrowserStack, SauceLabs)
**docs**    : Documentation only changes
**feat**    : A new feature
**fix**     : A bug fix
**perf**    : A code change that improves performance
**refactor**: A code change that neither fixes a bug nor adds a feature
**style**   : Changes that do not affect the meaning of the code (white-space, formatting, missing semi-colons, etc)
**test**    : Adding missing tests or correcting existing tests

## License

Distributed under the MIT License. See [LICENSE.md](/LICENSE.md) for more information.

## FOSSA third-party code, license compliance and vulnerabilities

[![FOSSA Status](https://app.fossa.io/api/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template.svg?type=large)](https://app.fossa.io/projects/git%2Bgithub.com%2FSpring-Boot-Framework%2FSpring-Boot-Application-Template?ref=badge_large)

<!-- CONTACT -->
## Contact

Anantha Raju C - [@anantharajuc](https://twitter.com/anantharajuc) - arcswdev@gmail.com

Project Link: [https://github.com/Spring-Boot-Framework/Spring-Boot-Application-Template](https://github.com/Spring-Boot-Framework/Spring-Boot-Application-Template)
