[![Build Status](https://secure.travis-ci.org/nadavc/gwt-spring-bootstrap.png)](http://travis-ci.org/nadavc/gwt-spring-bootstrap)

gwt-spring-bootstrap
====================

A Gwt/Spring/Gradle application that can be used to bootstrap a web application

App Overview
============
Upon login, the user enters his name and gets a greeting in a random language, pulled from a database

Tech Overview
=============
- Gradle build with Travis CI integration
- DevMode-enabled Gwt client
- Java/Spring/MyBatis backend
- Spring Security enabled with multi-tenancy
- 4 software layers - presentation (cli/webapp)/business logic (services)/dal/shared
- Unit testing with JUnit/Spring/Fest/Mockito

Multi-tenancy
=============
- There are two tenants: 'firstTenant' and 'secondTenant'
- Each tenant has its own H2 schema
- Each tenant has one user
- When logging in, you need to specify the tenant name within the username, like so: username@tenantName
- User in firstTenant: joe / pass
- User in secondTenant: eve / pass
- Only user 'joe' has permission to get a greeting.



