# Project Review for Super Duper Drive

Dear Student,

Congratulations on completing all the requirements of the SuperDuperDrive project and earning a new milestone.

Amazing work in this submission! ✌ I was truly happy to see the results of all your learning have come so clearly into your first project. You were really good at showcasing your excellency in entity design, implementation, and exception handling.✌

You are perfect in implementing functionalities of CRD (create, read and delete) for Files Tab, CRUD (create, read and delete) for Notes Tab, and CRUD (create, read and delete) for Credentials Tab, Test cases, etc. 👏✌

Below mentioned are the only minimal change that is required in your application. Fix for the below-mentioned one will drive you towards the success path.

* Handle the large file upload operation.
* Display success message on the login page, once redirection is done.
* Avoid duplicate file insertion.

You can also refer to advanced concepts for designing web applications.

* [Building an app with Angular and Spring](https://developer.okta.com/blog/2019/05/13/angular-8-spring-boot-2)
* [Spring Eco System](https://stackify.com/spring-boot-level-up/)
* Spring Boot with Docker
* Spring Boot Documentation

I wish you all the best for the upcoming challenges.✌

All the best!
Keep learning, keep being Udacious! Udacious:udacious:!

## Corrections Done

* Implemented the ErrorController Interface to show custom defined error Pages.
* Redirected the user to Login Page after a successful SignUp
* Display success message on the login page, once redirection is done.
* Disabled Automatic Spring While Label Error Page with:
 `server.error.whitelabel.enabled=false`
* Ensured that no two files with same name would be Saved
* To avoid Server crash, I set a limit of 1mb as the maximum file size to be uploaded using:
 `spring.servlet.multipart.max-file-size=-1`
 `spring.servlet.multipart.max-request-size=-1`
