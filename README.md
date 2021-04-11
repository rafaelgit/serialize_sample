# serialize_sample
Some ways to serialize the database result, using JPA

### Before running the project
```sql
create database serialize_sample;
```

### After running the project
```sql
insert into person (category, name) values ('human', 'Pereira');
insert into person (category, name) values ('animal', 'Thor');
```

ps.: You will probably need to change the `application.properties`.  Mainly the database connection username and password
```properties
spring.datasource.url=<url>
spring.datasource.username=<username>
spring.datasource.password=<password>
```