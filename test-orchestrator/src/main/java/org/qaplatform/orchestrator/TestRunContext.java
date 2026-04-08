package org.qaplatform.orchestrator;

import java.util.UUID;

public final class TestRunContext {
    private static final String RUN_ID_PROPERTY = "qa.runId";

    private TestRunContext() {
    }

    public static String initRunId() {
        String runId = System.getProperty(RUN_ID_PROPERTY);
        if (runId == null || runId.isBlank()) {
            runId = UUID.randomUUID().toString();
            System.setProperty(RUN_ID_PROPERTY, runId);
        }
        return runId;
    }
}
