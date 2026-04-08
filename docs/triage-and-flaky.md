# Triage and flaky handling

## Failure categories
- `assertion`: product behavior mismatch
- `env`: infrastructure/browser/network timeout failures
- `test-data`: invalid or stale fixtures
- `flaky`: unstable test behavior without deterministic repro

## Flaky policy
1. Mark flaky tests with `@Tag("flaky")`.
2. Keep retries limited (max 1 retry in CI).
3. Move persistent flaky tests to quarantine and create issue.
4. Track flaky rate trend on Grafana dashboard.
