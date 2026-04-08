# Quickstart

## Requirements
- Java 21
- Maven 3.9+
- Docker Desktop

## Start local infrastructure
`docker compose -f infra/docker-compose.yml up -d`

## Execute suites
- Smoke: `mvn test -Psmoke`
- Regression: `mvn test -Pregression`
- Contract: `mvn test -pl contract-tests -Pregression`
- Performance descriptor check: `mvn test -pl performance-tests`

## Allure report
- Generate: `mvn allure:report`
- Results are collected from `target/allure-results` in each module.
