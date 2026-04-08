package org.qaplatform.testdata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TestUserFactoryTest {
    @Test
    void shouldCreateUserPayload() {
        TestUserFactory factory = new TestUserFactory();
        assertNotNull(factory.createUser().get("username"));
    }
}
