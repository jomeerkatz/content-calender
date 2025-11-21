# Content Calender

A Spring Boot 3 REST API for planning and tracking content ideas. The service exposes CRUD endpoints for content items, uses Spring Data JDBC for persistence, and ships with profile-based data loaders for quick seeding in development.

## Features
- Content CRUD endpoints with validation on request payloads
- H2 in-memory database by default with schema managed via `schema.sql`
- Dev profile JSON seeding through a `CommandLineRunner`
- Property-based welcome/about metadata exposed at the root endpoint
- Spring Boot Actuator starter included for operational endpoints (uses default exposure)

## Tech Stack
- Java 17
- Spring Boot 3.5.7 (Web, Data JDBC, Validation, Actuator)
- H2 (runtime)
- Maven Wrapper (`mvnw`) for builds
- Docker Compose (PostgreSQL service scaffold)

## Architecture Overview
- **Controllers**: `HomeController` exposes configured metadata; `ContentController` provides REST CRUD operations under `/api/content`.
- **Models**: `Content` record represents content items with validation; `Status` and `Type` enums capture lifecycle and content type.
- **Repository**: `ContentRepository` extends `ListCrudRepository` for JDBC-backed persistence.
- **Configuration**: `ContentCalenderProperties` binds `cc.*` properties; `DataLoader` seeds JSON data when the `dev` profile is active; an additional `CommandLineRunner` seeds a sample record in the default profile.
- **Database**: `schema.sql` creates the `Content` table on startup. H2 is default; PostgreSQL is provisioned via Docker Compose but the JDBC driver is currently commented out in the POM.

## Folder Structure
```
content-calender/
├─ docker-compose.yml
├─ pom.xml
├─ src
│  ├─ main
│  │  ├─ java/jomeerkatz/springboot/content_calender
│  │  │  ├─ ContentCalenderApplication.java
│  │  │  ├─ config/ (properties binding, dev data loader)
│  │  │  ├─ controller/ (Home, Content controllers)
│  │  │  ├─ model/ (Content record, Status & Type enums)
│  │  │  └─ repository/ (ContentRepository)
│  │  └─ resources
│  │     ├─ application.properties
│  │     ├─ schema.sql
│  │     └─ data/content.json
│  └─ test/java/jomeerkatz/springboot/content_calender
│     └─ ContentCalenderApplicationTests.java
```

## Installation & Running Locally
**Prerequisites:** Java 17, Maven (or use the provided `./mvnw` wrapper).

```bash
# Build the project
./mvnw clean package

# Run with the default profile (uses H2 and loads schema.sql)
./mvnw spring-boot:run
```
The application starts on port `8080` by default. H2 console is not enabled by default.

## Running with Docker / Docker Compose
A Dockerfile is not included. To experiment with PostgreSQL locally, start the compose service:

```bash
docker compose up -d db
```
This provisions a PostgreSQL 16 instance on `localhost:5432` with database `content_calender` and user/password `postgres`.

To connect the application to PostgreSQL, add the PostgreSQL JDBC dependency (currently commented out in `pom.xml`) and provide datasource properties (e.g., in `application-prod.properties`):
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/content_calender
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.datasource.driver-class-name=org.postgresql.Driver
spring.sql.init.mode=always
```

## Environment Variables / Properties
- `cc.welcomeMessage`, `cc.about`: optional properties exposed via the root (`/`) endpoint.
- `SPRING_PROFILES_ACTIVE=dev`: enables JSON seeding via `DataLoader`.
- `SPRING_DATASOURCE_*`: set when pointing to PostgreSQL (see above).

## Profiles (dev vs prod)
- **Default (no profile)**: Uses H2 with schema initialization and seeds a single sample record via `CommandLineRunner` in `ContentCalenderApplication`.
- **`dev` profile**: Activates `DataLoader` to seed multiple records from `data/content.json` at startup.

## API Endpoints
| Method | Path | Description |
| --- | --- | --- |
| GET | `/` | Returns configured `cc.*` properties (welcome/about). |
| GET | `/api/content` | List all content items. |
| GET | `/api/content/{id}` | Retrieve a specific content item by ID (404 if not found). |
| PUT | `/api/content` | Create a new content item. Validates payload and returns `201 Created`. |
| POST | `/api/content/{id}` | Update an existing content item. Returns `204 No Content` on success or `404` if missing. |
| DELETE | `/api/content/{id}` | Delete a content item by ID. Returns `204 No Content`. |

## Deployment Notes
- Package with `./mvnw clean package` to produce a runnable JAR in `target/`.
- Configure an external relational database (e.g., PostgreSQL) and set datasource properties before running in production.
- Consider enabling and configuring Actuator endpoint exposure and adding CORS rules before public deployment.

## Author Info
Project by Jomeerkatz.
