
Usecase: 1

1.How to externalize the spring properties 


1.By default spring boot reads the properties from application.properties file name.
2.It searches for this file in following different places.

By default, Spring Boot will look for your externalized properties in a file named application.properties located in one of the following folders :

classpath root
in the package /config in classpath
in the current directory
/config subdirectory of the current directory


3.Spring boot uses the by default application.properties as the property name to look for property file.
4.spring uses the 15 different ways to load the properties
5.Spring boot loads the all the properties in Environment where we can access the properties in Java Program.
6.Spring boot property values can be passed through the command line arguments.


Passing the spring boot arguments from application arguments

--application.user.name="application user name  passed from program arguments" --application.name="applicationName passed from application Name"


Passing the spring boot arguments from VM arguments 

-Dapplication.user.name="application uses name  passed from program arguments" -Dapplication.name="applicationName passed from application Name"



Usecase 2 :

rename application.properties in Spring boot.

--spring.config.name=applcationProperties - Application Arguments
-Dspring.config.name="applicationProperties - VM Arguments.

Don't specify the extention (.properties)


Usecase 3 :

How to load multiple Properties files and from different locations


--spring.config.name=application,conf 
--spring.config.location=classpath:/external/properties/,classpath:/com/roufid/tutorial/configuration/
