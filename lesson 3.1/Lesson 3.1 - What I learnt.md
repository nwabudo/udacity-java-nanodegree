# WebServices: Overview

A web service is a way to share data between two disparate systems. The communication typically happens between a client and a server.

* Client - The client makes a request for data.
* Server - The server responds to the client's request.

## Web Service Communication

he means of communication between the client and server is via a standard web protocol like HTTP (or HTTPS) on the world wide web, that uses a common language like JSON or XML.

A client invokes a web service by sending an XML (or JSON) message, then waits for a corresponding XML response from the server.

### How Web Services Work

Step 1: The web service provider (the person who created the web service) defines a standard format for requests and also for the responses provided.

Step 2: The client sends a request to the web service across the network.

Step 3: The web service receives the request and performs an action (like query a database or perform a calculation) and sends a response back to the calling client

### Web Services vs APIs vs Microservices

Web Services:

* Started in early 90's
* SOAP Complexities led to REST
* Developing Restful APIs using Spring Boot
* SOAP (Simple Object Access Protocol)

APIs

* APIs are more lightweight and Streamlined
* They are good for devices with limited bandwith
* They are dependednt on SOAP Protocol vs REST
* It requires work in Packaging and Unpackaging data

> All Web Services are APIs but not all APIs are Web Services

Microservices

* Similar to APIs
* Fully Contained in an environment
* Tied to an Individual Business Component
* Specific to a Business Domain

#### Publicly Accessible API

[A list of publicly accessible APIs](https://github.com/public-apis/public-apis/blob/master/README.md)
