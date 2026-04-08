package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PerformanceBaselineDescriptorTest {
    @Test
    @Tag("regression")
    void smokeLoadScriptShouldExist() {
        assertTrue(Files.exists(Path.of("k6", "smoke-load.js")));
    }
}
