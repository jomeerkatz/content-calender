# 📘 **README.md — Content Calendar API (Spring Boot 3)**

Perfekt Jo — damit kann ich jetzt das finale, hochprofessionelle README für dein GitHub-Repo erstellen.

Ich baue folgende Screenshots ein (mit **klaren Platzhaltern**, die du später nur noch ersetzen musst):

1. **Railway Deployment Screenshot**
2. **Docker Container Screenshot**
3. **API Response Screenshot (Postman / Browser / Thunder Client)**

Ich setze sie an die **optimalen Stellen**, wo Recruiter sofort den Eindruck bekommen:
👉 **„Der Typ deployt wirklich in Production und weiß, was er tut.“**

Und jetzt kommt dein fertiges README — **ready to paste**.

---

*Production-ready Spring Boot 3 API with PostgreSQL, H2, Docker, Profiles & Railway Deployment*

---

## 🚀 Project Summary

The **Content Calendar API** is a full Spring Boot 3 backend application built as part of my advanced learning path.
This project demonstrates how to build, structure, deploy, and operate a real-world Spring Boot service — from local development with H2 to a fully deployed PostgreSQL-backed service on Railway.

I built this project to:

* Refresh and deepen my Spring Boot knowledge (especially SB3 changes)
* Strengthen my Java backend portfolio for job applications
* Learn modern deployment workflows (Docker → Railway)
* Understand environment configurations (dev vs prod)
* Build a real API that is accessible online

---

# 🧩 Why This Project Exists

Backend engineering involves much more than writing endpoints.
This project shows full-stack backend competency:

* Building REST APIs the Spring way
* Managing two databases (H2 for dev, PostgreSQL for prod)
* Working with Docker containers
* Using profiles for **environment-specific behavior**
* Deploying production-ready apps using Railway
* Handling sensitive configuration with environment variables
* Debugging DB schema & connection issues in real deployment environments

It demonstrates the skills companies expect from a **Junior → Mid Java Backend Developer**.

---

# 🧠 What Problem This Project Solves

This project is a **teaching and demonstration tool**.
It solves the questions every beginner backend engineer faces:

* How do I build a Spring Boot 3 REST API?
* How do I work with PostgreSQL and H2?
* How do I configure Docker + containers?
* How do I switch between dev and prod environments?
* How do I deploy a Java backend to Railway?
* How do I manage environment variables safely?
* How do I structure a real backend application cleanly?

---

# 🔥 Tech Stack

| Layer           | Technology              |
| --------------- | ----------------------- |
| Language        | **Java 17**             |
| Framework       | **Spring Boot 3**       |
| Web             | Spring MVC              |
| Persistence     | Spring Data JPA         |
| Local DB        | H2 (in-memory)          |
| Production DB   | PostgreSQL              |
| Deployment      | Railway                 |
| Container       | Docker / Docker Compose |
| Monitoring      | Spring Boot Actuator    |
| Build Tool      | Maven                   |
| Version Control | GitHub                  |

---

# 🏗️ Architecture Overview

```
                ┌──────────────────────────────┐
                │         Frontend (optional)   │
                │  React / Next.js / Vue        │
                └───────────────┬──────────────┘
                                │ HTTP/JSON
                                ▼
                    ┌────────────────────────┐
                    │    Spring Boot API     │
                    │  Controllers (MVC)     │
                    ├────────────────────────┤
                    │   Service Layer        │
                    │  Business Logic        │
                    ├────────────────────────┤
                    │ Repository Layer (JPA) │
                    └──────────────┬─────────┘
                                   │
                        ┌──────────┴───────────┐
                        │                       │
                 ┌──────────────┐      ┌────────────────┐
                 │  H2 (Dev)    │      │ PostgreSQL Prod │
                 └──────────────┘      └────────────────┘
```

---

# 🧪 Screenshots

### 📌 **Railway Deployment Screenshot**

*Add your screenshot path here:*

```
![Railway Deployment](./screenshots/railway.png)
```

---

### 🐳 **Docker Container Screenshot**

*Add your screenshot path here:*

```
![Docker Containers](./screenshots/docker-containers.png)
```

---

### 📡 **API Response Screenshot (Postman / Thunder Client)**

*Add your screenshot path here:*

```
![API Response](./screenshots/api-response.png)
```

---

# ⚙️ Quick Start (TL;DR)

## 🖥️ **Local Development (H2)**

This uses the development profile and H2 in-memory DB.

```bash
git clone <YOUR_GITHUB_REPO_LINK>
cd content-calendar
./mvnw spring-boot:run
```

Access H2 console (dev only):

```
http://localhost:8080/h2-console
```

---

## 🐳 **Local with Docker + PostgreSQL**

```bash
docker compose up -d
SPRING_PROFILES_ACTIVE=prod ./mvnw spring-boot:run
```

---

## ☁️ **Production Deployment (Railway)**

### Steps:

1. Push code to GitHub
2. Connect Railway → New Service → Deploy from Repo
3. Add environment variables:

   * `SPRING_DATASOURCE_URL`
   * `SPRING_DATASOURCE_USERNAME`
   * `SPRING_DATASOURCE_PASSWORD`
4. Deploy Docker image
5. Railway auto-creates PostgreSQL DB
6. Run health checks via Actuator
7. The API becomes public

---

# 📚 API Examples

## POST — Create Content

```
POST /api/content
Content-Type: application/json
```

```json
{
  "title": "First Content",
  "description": "Learning Spring Boot",
  "status": "IDEA",
  "contentType": "VIDEO"
}
```

---

## GET — Get All Content

```
GET /api/content
```

### Example Response

```json
[
  {
    "id": 1,
    "title": "First Content",
    "description": "Learning Spring Boot",
    "status": "PUBLISHED",
    "contentType": "ARTICLE"
  }
]
```

---

# 🛠️ Technical Decisions

### ✔ H2 for Development

* Instant startup
* No external dependencies
* Perfect for fast testing

### ✔ PostgreSQL for Production

* Durable / reliable

* Cloud compatible
* Supports real-world scaling needs

### ✔ Environment Profiles

* `dev` → H2, debug logs
* `prod` → PostgreSQL, env variables, no dev tools

### ✔ Docker & Compose

* Standardized environment
* Same config everywhere
* Railway supports Docker natively

### ✔ Actuator

* Health checks
* Metrics
* Info endpoints

---

# 🧩 Challenges & How I Solved Them

### 🧱 1. Docker Deployment

Railway requires correct env variable mapping + working Dockerfile.
Solved via standardized Dockerfile + Railway environment config.

### 🔑 2. Sensitive Data Management

Learned to avoid hardcoded DB credentials.
Used environment variables everywhere.

### 🔄 3. Switching Between H2 and PostgreSQL

Implemented profile-based config:

* `application-dev.yml`
* `application-prod.yml`

### 🗄️ 4. Initial Schema & Sample Data

Railway calls schema at startup — needed to ensure proper migrations per profile.

---

# 🧠 What I Learned

* Spring Boot 3 fundamentals (MVC, JPA, Actuator)
* Dependency Injection, IoC, Spring Context
* REST API structure & layering
* PostgreSQL & H2 configuration
* Docker images, containers, Compose
* Railway deployment pipeline
* Working with profiles & env variables
* Diagnosing real production failures

This project made me more confident as a backend developer.

---

# 🗺️ Roadmap

* [ ] Add Swagger OpenAPI documentation
* [ ] Add unit + integration tests
* [ ] Add CI/CD pipeline
* [ ] Add real frontend client
* [ ] Add Spring Security + JWT
* [ ] Add pagination, sorting, filtering
* [ ] Enhance error handling & validations

---

# 👤 Author

**Jo — Java Backend Developer**
Building production-ready backend services with Spring Boot.

---
