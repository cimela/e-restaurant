# e-Restaurant
This project is the one built to apply our skills and knowledge which we've learnt

## How to use this project
1. Ensure that all the required programs are available. Check the list of these programs at [here](https://github.com/cimela/e-restaurant/blob/master/README.md#requirements)
2. Build whole project with the corresponding [profile](https://github.com/cimela/e-restaurant/blob/master/README.md#profiles).


## Requirements
These programs should be available to use this project  

| #     | Programs | Version |
| :---: | :------: | :-----: |
| 1     | Java     | 1.8+    |
| 2     | Maven    | 3.5.4+  |
| 3     | NodeJS   | 8.11.4+ |
| 4     | MongoDB  | 4.0.1   |


## Profiles
There are 2 kind of profiles to build this project
+ production: this build will provide the final product with all current source code.
+ dev: this build will help developers reduce the project building time since only the related parts will be built.
All following commands must be executed at the base folder

### For production
```
mvn clean install -Pproduction
```
**Note:** this command must be executed at *the first time* after getting the code to generate the front end build.

### For dev
#### Front End
```
mvn clean install -Pproduction
```
This command will re-build the front end part and integrate with the final product

#### Back End
```
mvn clean install
```
This command will re-build only the back end part with the final product.
