# Spring Boot Application

This is a Spring Boot application that allows you to Search, Add, Update and Delete the book information and as well as allows you to add notes(comments) and whether you have read the book or not.

## Prerequisites
Before you can download and run the Spring Boot application, make sure you have the following software installed on your machine:
- Java Development Kit (JDK) 11 
- Maven build tool
- Internet connection to download dependencies and libraries

## Download
To download the Spring Boot application, follow these steps:
1. Clone the repository from GitHub using the following command:
```
 git clone https://github.com/vinayb004/Scan-Book-backend.git
```
2. Alternatively, you can download the ZIP file of the repository from GitHub by navigating to the repository's main page, clicking on the "Code" button, and selecting "Download ZIP".
3. Extract the downloaded ZIP file to a directory of your choice.

Once downloaded, Edit the Application.properties file based on your database configuration.

## Run
To run the Spring Boot application, follow these steps:
1. Open a command prompt or terminal window.
2. Navigate to the directory where the application is downloaded or cloned.
3. Build the application using Maven by running the following command: 
```
mvn clean install
```
4. Once the build is successful, you can run the application using the following command:
```
java -jar target/<your-app-name>.jar
```
   Replace <your-app-name> withe the name of your JAR file.
   
5. The Spring Boot application will now start and you will see logs indicating the server is running.
6. Open a web browser and go to `http://localhost:8080` (or the specified port) to access the application.



