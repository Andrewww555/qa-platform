# ТЗ Compliance Matrix

Ниже матрица соответствия ключевых требований ТЗ и реализации в проекте.

| Требование | Статус | Реализация | Проверка |
|---|---|---|---|
| Multi-module QA платформа | Done | `pom.xml`, модули `api-tests`, `ui-tests`, `contract-tests`, `performance-tests`, `test-data-service`, `reporting-service`, `observability-service`, `test-orchestrator` | `mvn -B test` |
| Smoke/regression разделение | Done | Профили `smoke`, `regression`, `e2e` в root `pom.xml` | `mvn test -Psmoke`, `mvn test -Pregression` |
| API позитив/негатив + базовые проверки | Partial | `api-tests/src/test/java/tests/BookingApiTest.java` | `mvn -pl api-tests test` |
| UI critical path | Done | `ui-tests/src/test/java/tests/E2eCriticalPathTest.java` | `mvn -pl ui-tests -Pe2e -Dui.e2e.enabled=true test` |
| Contract testing | Done | `contract-tests/src/test/java/tests/BookingContractTest.java` | `mvn -pl contract-tests test` |
| Performance smoke-load/stress/soak | Partial | `performance-tests/k6/smoke-load.js` + descriptors | `mvn -pl performance-tests test` |
| Test data service | Done | `test-data-service` (Faker + Flyway migration) | `mvn -pl test-data-service test` |
| Allure/отчётность | Done | Allure deps/config + surefire reports artifacts in CI | CI artifacts + local `allure:report` |
| Observability + Kafka events | Done | `observability-service/src/main/java/org/qaplatform/observability/TestEventPublisher.java` | compile + unit smoke |
| CI quality gates + release blocking | Done | `.github/workflows/ci.yml` + `scripts/quality_gate.py` | PR/push/nightly jobs |
| Локальное развёртывание | Done | `infra/docker-compose.yml`, `docs/quickstart.md` | `docker compose -f infra/docker-compose.yml up -d` |

## Примечания
- Для полного production уровня требуется расширение негативных API сценариев и полные stress/soak отчёты k6/JMeter.
- Для защиты у ментора текущий объём достаточен как полнофункциональный учебный MVP с quality gates и трассируемым контуром запуска.
