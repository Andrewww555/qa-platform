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
   - `mvn test -Pe2e -pl ui-tests -Dui.e2e.enabled=true`
5. Quality gate check:
   - `python scripts/quality_gate.py --smoke-max-minutes 15 --regression-max-minutes 120 --flaky-max-rate 0.03`

## Quality goals
- Flaky rate <= 3%
- Smoke <= 15 minutes
- Regression <= 120 minutes

## Delivery docs
- `docs/quickstart.md`
- `docs/triage-and-flaky.md`
- `docs/tz-compliance-matrix.md`
