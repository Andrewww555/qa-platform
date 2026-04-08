# QA Platform Java

Multi-module QA automation platform aligned with the provided technical specification.

## Modules
- `test-orchestrator`
- `api-tests`
- `ui-tests`
- `contract-tests`
- `performance-tests`
- `test-data-service`
- `reporting-service`
- `observability-service`

## Local run
1. Start infra:
   - `docker compose -f infra/docker-compose.yml up -d`
2. Smoke:
   - `mvn test -Psmoke`
3. Regression:
   - `mvn test -Pregression`
4. E2E only:
   - `mvn test -Pe2e -pl ui-tests`

## Quality goals
- Flaky rate <= 3%
- Smoke <= 15 minutes
- Regression <= 120 minutes
