Spring mvc application for accommodation system
# Requirements

* Java 1.7 of higher
    * please set JAVA_HOME environment variable 
* Maven
    *maven version 3.0.3 or higher
*Internet connection
    *This is important for maven to download dependencies from maven central in initial project set up
# Database Mysql database
   1.Create database named  `home`
   2.To set db password open file named application.yml.(path from project root = src/main/resources/application.yml)

#Registering users
  1.ADMIN
     sign up into the system using the sign up link.
     *From a linux terminal or windows command prompt, navigate to project root directory of the extracted zip file and
        run mysql queries and access users table and change the role to 'ADMIN', take note it should be in uppercase.

  2.STUDENT(S)
 #Student sign up
   New students can sign up into the system using the sign up link.
   They complete their profiles before they can start booking.
#log in
   use username or email and the pass word you provided during sign up.
# How to run
  *Import the sql file provided named init.sql (path= project root directory).
  *From a linux terminal or windows command prompt, navigate to project root directory of the extracted zip file and
   run mvn spring-boot:run
  *From the browser view the project using this link http://localhost:8080

## Packaging
  1. `mvn package`
