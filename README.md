<body>
    <h1>Microservice Project</h1>
    <p>This project consists of multiple microservices with a service registry, an API gateway, and two core microservices: User Service and Contact Service.</p>
    <h2>Services and Ports</h2>
    <ul>
        <li><strong>Service Registry</strong>: Running at port <code>8761</code></li>
        <li><strong>API Gateway</strong>: Running at port <code>8085</code></li>
        <li><strong>User Microservice</strong>: Running at port <code>8880</code></li>
        <li><strong>Contact Microservice</strong>: Running at port <code>8881</code></li>
    </ul>
    <h2>Architecture Overview</h2>
    <ol>
        <li><strong>Service Registry</strong>: Responsible for service discovery. All microservices register themselves with the service registry.</li>
        <li><strong>API Gateway</strong>: Routes requests to appropriate microservices and acts as a reverse proxy.</li>
        <li><strong>User Microservice</strong>: Manages user data and has a one-to-many relationship with the contact data.</li>
        <li><strong>Contact Microservice</strong>: Manages contact data associated with users.</li>
    </ol>
    <h2>Prerequisites</h2>
    <ul>
        <li>Java 17</li>
        <li>Maven</li>
        <li>SpringBoot 3.2.6</li>
          <li>MySql</li>
    </ul>
    <h2>Getting Started</h2>
    <h3>1. Service Registry</h3>
    <p>This service uses Spring Cloud Netflix Eureka for service discovery.</p>
    <div class="code-block">
        <pre>cd service-registry
mvn spring-boot: run</pre>
    </div>
    <h3>2. API Gateway</h3>
    <p>The API Gateway uses Spring Cloud Gateway.</p>
    <div class="code-block">
        <pre>cd API-gateway
mvn spring-boot: run</pre>
    </div>
    <h3>3. User Microservice</h3>
    <p>The User Microservice handles user data and communicates with the Contact Microservice to fetch contact details.</p>
    <div class="code-block">
        <pre>cd user-service
mvn spring-boot: run</pre>
    </div>
    <h3>4. Contact Microservice</h3>
    <p>The Contact Microservice handles contact data associated with users.</p>
    <div class="code-block">
        <pre>cd contact-service
mvn spring-boot: run</pre>
    </div>
    <h2>API Endpoints</h2>
    <h3>User Microservice</h3>
    <ul>
        <li><strong>Get All Users</strong>: <code>GET /user/get</code>
            <ul>
                <li>Returns a list of all users along with their contact details.</li>
                <li>This endpoint triggers the Contact Microservice to fetch associated contacts for each user.</li>
            </ul>
        </li>
    </ul>
    <h3>Contact Microservice</h3>
    <ul>
        <li><strong>Get Contacts by User ID</strong>: <code>GET /contacts/user/{userId}</code>
            <ul>
                <li>Returns a list of contacts for the specified user ID.</li>
            </ul>
        </li>
    </ul>
    <h2>Example Usage</h2>
    <p>To retrieve all users along with their contact details:</p>
    <div class="code-block">
        <pre>curl -X GET http://localhost:8085/user/get</pre>
    </div>
    <p>This request goes through the API Gateway, which routes it to the User Microservice. The User Microservice then fetches the contact details for each user by communicating with the Contact Microservice.</p>
    <h2>Project Structure</h2>
    <div class="code-block">
        <pre>.
├── api-gateway
│   └── src
│       └── main
│           └── java
│               └── com.example.gateway
├── contact-service
│   └── src
│       └── main
│           └── java
│               └── com.example.contact
├── service-registry
│   └── src
│       └── main
│           └── java
│               └── com.example.registry
├── user-service
    └── src
        └── main
            └── java
                └── com.example.user</pre>
    </div>
    <h2>Configuration</h2>
    <h3>Service Registry Configuration</h3>
    <div class="code-block">
        <pre>service:
  port: 8075

eureka:
  client:
    register-with-eureka: false
    fetch-registry: false
  server:
    enable-self-preservation: false</pre>
    </div>
    <h3>API Gateway Configuration</h3>
    <div class="code-block">
        <pre>server:
  port: 8085

spring:
  application:
    name: API-gateway

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8075/eureka/</pre>
    </div>
    <h3>User Microservice Configuration</h3>
    <div class="code-block">
        <pre>server:
  port: 8880

spring:
  application:
    name: user-service

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8075/eureka/</pre>
    </div>
    <h3>Contact Microservice Configuration</h3>
    <div class="code-block">
        <pre>server:
  port: 8881

spring:
  application:
    name: contact-service

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka/</pre>
    </div>
    <h2>Conclusion</h2>
    <p>This setup demonstrates a simple microservices architecture with a service registry, an API gateway, and core microservices for managing users and contacts. Each microservice is independently deployable and scalable.</p>
    <p>For any issues or questions, please open an issue or contact the maintainers.</p>
</body>
