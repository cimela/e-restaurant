# e-Restaurant
This project is the one built as a sample of final solution where integrating React, Spring-Boot and MongoDB
**All following commands must be executed at the base folder**

## Versions and Release Plan
- Current version: v0.0.1 - Initial Stage 

| #     | Name     | Description  | Status  |
| :---: | :------: | :----------- | :----:  |
| 1     | Init     | Build project structure with base code, prepare documents, conventions will be applied in this project and configure github | On-going |

## How to start with this project
1. Ensure that all the [required programs](https://github.com/cimela/e-restaurant/blob/master/README.md#requirements) are available.
2. Build whole project with the corresponding [profile](https://github.com/cimela/e-restaurant/blob/master/README.md#profiles).
3. Execute following command in other to generate the Eclipse configuration for all modules projects
```
mvn eclipse:eclipse
```
4. If you want to execute the application, move to **appserver** project and run this command
```
mvn spring-boot:run
```

## Requirements
These programs should be available to use this project  

| #     | Programs | Version |
| :---: | :------- | :-----: |
| 1     | [Java](http://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html)     | 1.8+    |
| 2     | [Maven](https://maven.apache.org/download.cgi)    | 3.5.4+  |
| 3     | [NodeJS](https://nodejs.org/en/download/)   | 8.11.4+ |
| 4     | [MongoDB](https://www.mongodb.com/download-center#community)  | 4.0.1   |


## Profiles
There are 2 kind of profiles to build this project
+ production: this build will provide the final product with all current source code.
+ dev: this build will help developers reduce the project building time since only the related parts will be built.  

### For production
```
mvn clean install -Pproduction
```
**Note:** this command must be executed at *the first time* after getting the code to generate the front end build.

### For dev
#### Front End
```
mvn clean install -Pfrontend
```
This command will re-build the front end part and integrate with the final product

#### Back End
```
mvn clean install
```
This command will re-build only the back end part with the final product.

## How to run project
Execute following command
```
java -jar appserver/target/eRestaurant.jar
```

## Database Details
You can customize the database configuration at **appserver/src/main/resources/application.properties**    

| #     | Info       | Details      |
| :---: | :--------- | :----------- |
| 1     | host       | localhost    |
| 2     | port       | 27017        |
| 3     | collection | e-restaurant |

## Coordinators
| #     | Members    | Email                  |
| :---: | :--------: | :--------------------: |
| 1     | [Quyen Phan](https://github.com/cimela) | quyen.it1423@gmail.com |
| 2     | [Lam Ho](https://github.com/longkid)     | hotienlam@gmail.com    |
