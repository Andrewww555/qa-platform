package org.qaplatform.reporting;

public final class FailureClassifier {
    private FailureClassifier() {
    }

    public static String classify(Throwable throwable) {
        String message = throwable == null ? "" : String.valueOf(throwable.getMessage()).toLowerCase();
        if (message.contains("timeout")) {
            return "env";
        }
        if (message.contains("assert")) {
            return "assertion";
        }
        if (message.contains("data")) {
            return "test-data";
        }
        return "flaky";
    }
}
