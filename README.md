# Hibernate
Hibernate-powered, applications and services with absolute minimum fuss.

## Modules

[comment]: <> (1. Hibernate-00-Helloworld)
   

[comment]: <> (2. Hibernate-01-Entity-Mapping)

   
[comment]: <> (4. Hibernate-02-Persistence-API)


[comment]: <> (5. Hibernate-03-Association-Mapping)


[comment]: <> (6. Hibernate-04-Collection-Mapping)


[comment]: <> (7. Hibernate-05-Inheritance-Mapping)


[comment]: <> (8. Hibernate-06-Complex-Mapping)


[comment]: <> (9. Hibernate-07-Hql)


[comment]: <> (10. Hibernate-08-Concurrency)


[comment]: <> (11. Hibernate-09-Optimization)


[comment]: <> (12. Hibernate-10-Applications)

## Setup



## Dependencies



## Bundles

Take note of the `pom.xml` file.

## Philosophy

I hate coding absolute paths in my build script, and I hate including
built files as part of the base project. My philosophy is that the
*environment* should be set up so that the tool can easily find the
external resources they need (JUnit, etc.) from the system or
dependency manager. It's the system or dependency manager that
provides the libraries. Anyone who has the proper development
environment set up -- one that works across many projects -- should be
able to clone the repository and do a build simply by running the
build program with no special arguments. There should be no need to
edit or install anything into the project space for the initial build.

# License
Geekcolab Spring is Open Source application programs under the https://www.apache.org/licenses/LICENSE-2.0.html[Apache 2.0 license].
