# status

- CircleCI 2.0 [![CircleCI](https://circleci.com/gh/positrium/spring-boot-ddd-api-circle-test/tree/feature%2Ftest.svg?style=svg)](https://circleci.com/gh/positrium/spring-boot-ddd-api-circle-test/tree/feature%2Ftest)

# env

- spring-boot
- DDD
- api ( json )
- circle.ci 2.0

# setup

```
CREATE DATABASE ci_test CHARACTER SET utf8mb4;
```

```
mvn flyway:baseline -Dflyway.baselineVersion=1.0.0 -Dflyway.baselineDescription="note v1.0.0" -Dflyway.user=root -Dflyway.password="" -Dflyway.url=jdbc:mysql://localhost:3306/ci_test -Dflyway.driver=com.mysql.jdbc.Driver
mvn flyway:clean -Dflyway.baselineDescription="note v1.0.0" -Dflyway.user=root -Dflyway.password="" -Dflyway.url=jdbc:mysql://localhost:3306/ci_test -Dflyway.driver=com.mysql.jdbc.Driver
mvn flyway:migrate -Dflyway.baselineDescription="note v1.0.0" -Dflyway.user=root -Dflyway.password="" -Dflyway.url=jdbc:mysql://localhost:3306/ci_test -Dflyway.driver=com.mysql.jdbc.Driver
```
