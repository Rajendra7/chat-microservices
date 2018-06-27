API backend for: https://git.generalassemb.ly/andytham/chat-react

Microservice backend, originally deployed on AWS for SECA final project along with the react frontend, found in the link above.

How to start local version:
- cd into `chat-microservices`, `docker-compose up`

Endpoints:
- http://localhost:8080/chat-history/history
- http://localhost:8080/user-profiles-api/user-profiles
- http://localhost:8761 for Eureka service

Technology
- Java
- Spring Boot
- Microservices
- Zuul gateway
- Eureka service
- Docker
- AWS

Challenges / Specific issues
- Need more RAM