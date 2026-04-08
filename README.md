# QA Platform Java

Модульная QA-платформа автоматизации тестирования, реализованная по техническому заданию.

## Модули
- `test-orchestrator`
- `api-tests`
- `ui-tests`
- `contract-tests`
- `performance-tests`
- `test-data-service`
- `reporting-service`
- `observability-service`

## Локальный запуск
1. Запуск инфраструктуры:
   - `docker compose -f infra/docker-compose.yml up -d`
2. Smoke-прогон:
   - `mvn test -Psmoke`
3. Regression-прогон:
   - `mvn test -Pregression`
4. Только E2E:
   - `mvn test -Pe2e -pl ui-tests -Dui.e2e.enabled=true`
5. Проверка quality gate:
   - `python scripts/quality_gate.py --smoke-max-minutes 15 --regression-max-minutes 120 --flaky-max-rate 0.03`

## Целевые показатели качества
- Flaky rate <= 3%
- Smoke <= 15 minutes
- Regression <= 120 minutes

## Документы для сдачи
- `docs/quickstart.md`
- `docs/triage-and-flaky.md`
- `docs/tz-compliance-matrix.md`
