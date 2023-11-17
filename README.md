# miniServer V1.0

mini Server V1.0 java version(backend)

## RDBMS 종류별 설정(application.yml)

### mssql
```
spring   
  datasource:
    driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
    url: jdbc:sqlserver://localhost:1433;databaseName={database_name};encrypt=false;
    username: sa
    password: 123456
    
-- 의존성설정(maven)
<dependency>
	<groupId>com.microsoft.sqlserver</groupId>
	<artifactId>mssql-jdbc</artifactId>
	<scope>runtime</scope>
</dependency>
```
### mysql
```
spring   
  datasource:
    driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
    url: jdbc:sqlserver://localhost:1433;databaseName={database_name};encrypt=false;
    username: sa
    password: 123456
    
    
-- 의존성설정(maven)
<dependency>
	<groupId>com.mysql</groupId>
	<artifactId>mysql-connector-j</artifactId>
	<scope>runtime</scope>
</dependency>
```
### mariadb
```
spring:
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    url: jdbc:mariadb://localhost:3306/your_database_name?serverTimezone=Asia/Seoul
    username: root
    password: 1111
    
-- 의존성설정(maven)
<dependency>
	<groupId>org.mariadb.jdbc</groupId>
	<artifactId>mariadb-java-client</artifactId>
	<scope>runtime</scope>
</dependency>

```
### oracle
```
spring:
  datasource:
    driver-class-name: oracle.jdbc.OracleDriver
    url: jdbc:oracle:thin:@localhost:1521:your_sid
    username: your_username
    password: your_password
    
-- 의존성설정(maven)
<dependency>
    <groupId>com.oracle.database.jdbc</groupId>
    <artifactId>ojdbc8</artifactId> <!-- Use the appropriate version -->
    <scope>runtime</scope>
</dependency>

```

