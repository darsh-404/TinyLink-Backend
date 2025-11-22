# TinyLink Backend

URL Shortener Backend API built with Spring Boot and PostgreSQL.

## Tech Stack

- Java 17
- Spring Boot 3.2.0
- Spring Data JPA
- PostgreSQL
- Maven

## Prerequisites

- Java 17 or higher
- Maven 3.6+
- PostgreSQL database (or Neon account)

## Setup Instructions

### 1. Database Setup

Create a PostgreSQL database or use Neon:

```sql
CREATE DATABASE tinylink;
```

### 2. Configure Environment Variables

Create a `.env` file or set environment variables:

```properties
DATABASE_URL=jdbc:postgresql://your-host:5432/tinylink
DATABASE_USERNAME=your-username
DATABASE_PASSWORD=your-password
FRONTEND_URL=http://localhost:3000
```

### 3. Build and Run

```bash
# Build the project
mvn clean package

# Run the application
mvn spring-boot:run
```

The API will be available at `http://localhost:8080`

## API Endpoints

### Health Check

- `GET /healthz` - Health check endpoint

### Links Management

- `POST /api/links` - Create a new short link
- `GET /api/links` - Get all links
- `GET /api/links/{code}` - Get link stats by code
- `DELETE /api/links/{code}` - Delete a link

### Redirect

- `GET /{code}` - Redirect to target URL

## Testing

Test the health endpoint:

```bash
curl http://localhost:8080/healthz
```

## Deployment

### Railway

1. Connect your GitHub repository
2. Add environment variables
3. Deploy automatically

### Render

1. Create a new Web Service
2. Build command: `./mvnw clean package`
3. Start command: `java -jar target/tinylink-backend-0.0.1-SNAPSHOT.jar`
4. Add environment variables
