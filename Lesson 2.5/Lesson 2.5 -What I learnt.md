# Data Persistence & Security

## What to Learn

![Lesson Outline](/lesson-outline.png)

## Lesson Outline

* **ORM is the Norm**: We introduce ORM, or object-relational-mapping, a software pattern that leverages the similarities between Java classes and SQL tables to eliminate boilerplate in data access code.
* **MyBatis Mappers**: We introduce MyBatis, a dead-simple ORM tool for Java that integrates well with Spring. We discuss the "Mapper" classes MyBatis wants us to design to access the database.
* **Practical Example - User Credentials and Authentication**: As a motivating example for using ORM, we discuss how to implement basic login security with a User table, MyBatis, and Spring Security. We walk through a lengthy sample project that implements the entirety of this motivating example.

## ORM and Security

![The Growing Layers of Our Application](/big-picture.png)

The figure above shows the growing layers of our application. By adding MyBatis, we now have a translation from the Java and Spring world to the world of databases and SQL.

### Why a database is required?

Adding a database to our application is a way to externalize data persistence problems. When storing data in memory at runtime, we struggle to deal with:

* Storage Space
* Concurrency
* Persistence of Data

Using a database allows us to isolate these concerns from the rest of our application, so we can focus on the business logic of our application.

### How to interact with a database?

There are many ways to manage the communication between an application and a database. For this course, we'll be using the library MyBatis to transform Java objects to SQL query parameters and to transform SQL query results into Java objects.

We'll create MyBatis Mappers as Spring beans, so we can inject them into any other beans that need them. For example, if we think about an online-shopping example, we might have a UserMapper that manages credentials and profile information and a CartMapper that manages the contents of an individual user's cart. We can inject the UserMapper into a Checkout Service that also receives the CartMapper to apply the charges in a User's cart to that User's stored payment information.

Later in this lesson, we'll combine our MyBatis mappers with Spring Security to authenticate each user's session automatically. To continue our earlier example, this means we could inject the UserMapper in some kind of Authentication Service to check client credentials on login.

### Additional Reading on Persisting Data: Database and ORM

* Briefly read the research paper titled [Object/relational mapping 2008: hibernate and the entity data model](http://citeseerx.ist.psu.edu/viewdoc/download?doi=10.1.1.457.1205&rep=rep1&type=pdf) by Elizabeth O'Neil for a better insight into the ORM.
* If you are not familiar with JDBC, refer to this official [JDBC Introduction](https://docs.oracle.com/javase/tutorial/jdbc/overview/index.html), and have a quick look at the underlying architecture. Though, we will not use the JDBC directly. MyBatis will automatically generate JDBC requests. You will learn and implement MyBatis shortly.

### What Data Should be Stored in a Database?

* Data shared across multiple user sessions, like a product inventory
* Persistent data that should remain accessible after being logged out, like user profile or shopping cart

### How Should Data be Structured?

* Intuitively. Most data can be stored in a similar format to the data objects that represent it in Java, with attributes matching column names.
* Differing. Some data must be stored differently for security reasons, such as encrypted passwords. Other data may require a different format for efficient storage, such as large files.

### Thinking about Security

The main question to ask is: “What pages can a user access?”

* User-Specific Data
* Generally Accessible (Unsecured) Data
* May Vary by Domain

### Key Terms on ORM is the Norm

* **ORM**: Object-Relational Mapping. A general term describing a set of technology that can be used to automatically convert data between database representation and application representation.
* **Mapping**: Drawing a relationship between a field in a Java class and a column in a SQL table.
* **One to One**: A relationship between two objects in which one entity is on each side of the relationship.
* **Many to Many**: A relationship between two objects in which multiple copies of each entity can be related to multiple copies of the other entity.

### Suggested Reading on ORM is the Norm

* The book titled "**Patterns of Enterprise Application Architecture**" by Martin Fowler

* **[The Object-Relational Impedance Mismatch](https://hibernate.org/orm/what-is-an-orm/)**

### MyBatis Mappers

MyBatis provides a shallow ORM layer over JDBC (Java Database Connectivity). That means it helps map your Java objects to queries that save and retrieve data using JDBC.

MyBatis is mostly used through interface definitions. MyBatis automatically generates classes that implement the interface and makes them available as Spring beans. This is an example interface that defines a MyBatis Mapper.

```java

@Mapper
public interface UserMapper {
   @Select("SELECT * FROM USERS WHERE username = #{username}")
   User getUser(String username);
}

```

This code above uses `#{username}` to identify the username parameter. It's like Thymeleaf parameters, but for SQL!

For more information on the template syntax MyBatis uses for SQL, check out [the official documentation](https://mybatis.org/mybatis-3/sqlmap-xml.html#Parameters). There are additional annotations for `@Insert`, `@Update`, and `@Delete` as well. See the further research section below the next video for more info on ways to configure MyBatis.

#### `@Insert` and `@Options` annotation

The `@Insert` annotation automatically references attributes on the user object. Note username, firstName, lastName are all referenced directly here, because they are attributes of the user object.

```java
//UserMapper.java file
package com.udacity.jdnd.course1.data;

import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
   @Insert("INSERT INTO USERS (username, salt, password, firstname, lastname) " +
           "VALUES(#{username}, #{salt}, #{password}, #{firstName}, #{lastName})")
   @Options(useGeneratedKeys = true, keyProperty = "userId")
   int insert(User user);
}


// DeliveryMapper.java file

package com.udacity.jdnd.course1.data;

import org.apache.ibatis.annotations.*;

@Mapper
public interface DeliveryMapper {

    @Select("SELECT * FROM DELIVERY WHERE id = #{id}")
    Delivery finDelivery(int id);

    @Insert("INSERT INTO DELIVERY (orderId, time) VALUES(#{orderId}, #{time})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Delivery delivery);

    @Delete("DELETE FROM DELIVERY WHERE id = #{id}")
    void delete(int id);
}

```

This example also demonstrates the `@Options` annotation. `@Insert` normally returns an integer that is the count of rows affected. By using the `@Options` annotation, we're telling MyBatis that we want to automatically generate a new key and put it in userId. Now the method will return the new userId once the row has been inserted.

All we have to do to use these methods is inject beans for this interface into our services and MyBatis will automatically create the code for the JDBC requests!

#### MyBatis Mappers Lie at the Center of Our Onion Architecture

![MyBatis Mappers](/mybatis-mappers.png)

  MyBatis Mappers lie at the center of our onion architecture. Remember, that means that the only beans that should have dependencies on them are in the next layer up, services.

The diagram above shows that MyBatis Mappers lie at the center of our onion architecture. Remember, that means that the only beans that should have dependencies on them are in the next layer up, services.

### Key Terms on MyBatis Mappers

* **`@Select`, `@Insert`, `@Update`, `@Delete`**: Annotations representing SQL statements to be executed. Each annotation takes a string for a SQL statement of the corresponding type. For example, a `@Select` annotation takes a string for a SQL `SELECT` statement.
* **`@Options`**: Annotation providing access to switches and configuration options for JDBC statements.

### Further Research on MyBatis Mappers

* For a full list of the available MyBatis annotations and some example usage, see the [MyBatis Java API documentation](https://mybatis.org/mybatis-3/java-api.html).
* For an informal overview of result mapping with MyBatis annotations, see [this Medium article](https://medium.com/@hsvdahiya/mybatis-annotations-result-mapping-spring-79944ff74b84).

### Glossary

* **ORM**: Object-Relational Mapping. A general term describing a set of technology that can be used to automatically convert data between database representation and application representation.
* **JDBC**: Java Database Connectivity API, which is a specification for making SQL requests from Java.
* **MyBatis**: A thin ORM over JDBC that automatically generates code to execute SQL statements over JDBC and maps the results to Java objects.
* **Mapping**: Drawing a relationship between a field in a Java class and a column in a SQL table.
* **One to One**: A relationship between two objects in which one entity is on each side of the relationship.
* **Many to Many**: A relationship between two objects in which multiple copies of each entity can be related to multiple copies of the other entity.
* **@Select**, @Insert, @Update, @Delete: Annotations representing SQL statements to be executed. Each annotation takes a string for a SQL statement of the corresponding type. For example, a @Select annotation takes a string for a SQL SELECT statement.
* **@Options**: Annotation providing access to switches and configuration options for JDBC statements.
* **Onion Pattern**: Sometimes also called Tiered Architecture, Multi-tiered Architecture, or n-tiered Architecture. This is a design pattern that separates areas of the application into controller, service, and data layers (and sometimes more). User flows originate from the controller tier, which passes them to the service tier, which then reaches a data access bean.
* **Encryption**: Modifying data before storing it, with the intention of using another algorithm to return the data to its original form once it needs to be used.
* **Hashing**: Modifying data before storing it with the intention of never returning it to its original form. The modified data will be compared to other modified data only.
* **Salt**: random data that is combined with the input string when hashing so that the resultant hashed values are unique for each row. This means that two users with the same password would not have the same hash in the database.
