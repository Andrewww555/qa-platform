# Delivery Checklist (for mentor)

## Что показать на защите
1. `mvn -B test` проходит успешно.
2. Запуск smoke/regression профилей:
   - `mvn test -Psmoke`
   - `mvn test -Pregression`
3. Локальный инфраструктурный контур:
   - `docker compose -f infra/docker-compose.yml up -d`
4. Quality gate:
   - `python scripts/quality_gate.py --smoke-max-minutes 15 --regression-max-minutes 120 --flaky-max-rate 0.03`
5. Матрица соответствия ТЗ:
   - `docs/tz-compliance-matrix.md`

## Готовая формулировка для сдачи
Проект реализован как multi-module QA платформа с API/UI/contract/performance контурами, test-data сервисом, CI quality gates, инфраструктурой наблюдаемости и документацией локального воспроизведения.
