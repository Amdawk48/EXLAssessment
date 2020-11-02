This application is currently set to run using MySQL as the database.
Be sure to get the MySQL Workbench to set up your server.

Angular will be used for the front-end; you will be able to download it here: https://angular.io/

You will also need Maven as well for running the spring application.
Once you download maven, add the path that leads to your Mavens "bin" folder to your environment variables.


There are 2 batch script that can be run to start the Spring (startSringApplication) and Angular(startAngularAplication) applications.
*The batch script should currently be placed directly outside of the application folder to run properly.

Connecting to the Database:
	Open the "application.propertes" folder located in the Spring's resource folder. *employeewebapp/src/main/resources 
	The sql portion should look similar to the following:
		spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
		spring.datasource.url=jdbc:mysql://localhost:3306/{database_name}
		spring.datasource.username={user with permission to access database}
		spring.datasource.password={user's password}
		spring.jpa.hibernate.ddl-auto=update
		spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
		spring.jpa.database=mysql
		
	The {database_name) will be the database that you created in your mySql

Once you have your mySql server running run the batch scripts in the following order:
startSringApplication
startAngularAplication

Once both aplication have started running, you will be able to see the page at http://localhost:4200	.