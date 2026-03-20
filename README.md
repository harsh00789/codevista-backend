# CodeVista Backend ⚙️

The backend engine for CodeVista, providing high-performance algorithm execution traces and system design configurations.

## ✨ Features

- **Algorithm Engine**: Generates detailed execution steps for sorting and searching algorithms.
- **Problem Solver**: Provides optimized solutions and metadata for LeetCode-style problems.
- **Design Generator**: Serves structured node and edge data for architectural visualizations.
- **Structured Responses**: Consistent `AlgorithmResponse` and `DesignResponse` wrappers for easy frontend integration.

## 🛠️ Technology Stack

- **Framework**: [Spring Boot](https://spring.io/projects/spring-boot) (Java)
- **Build Tool**: [Gradle](https://gradle.org/)
- **Architecture**: RESTful API
- **Design Patterns**: Controller-Service-Model architecture

## 🚀 Getting Started

### Prerequisites

- [JDK 17](https://www.oracle.com/java/technologies/downloads/) or higher
- [Gradle](https://gradle.org/install/) (optional, wrapper included)

### Running the Application

1. Navigate to the backend directory:
   ```bash
   cd projects/codevista/backend/come.codevista
   ```

2. Build and run the project using the Gradle wrapper:
   ```bash
   ./gradlew bootRun
   ```

The server will start on `http://localhost:8081`.

## 📡 API Endpoints

- `POST /api/sort/bubble-sort`: Get bubble sort execution steps.
- `POST /api/problems/two-sum`: Get two sum solution walkthrough.
- `GET /api/design/url-shortner`: Fetch URL shortener system architecture.

## 📁 Code Highlights

- `controller/`: REST endpoints for different feature modules.
- `dsa/response/`: Data transfer objects for algorithm metadata.
- `design/`: Logic for generating system architecture configurations.
"# codevista-backend" 
