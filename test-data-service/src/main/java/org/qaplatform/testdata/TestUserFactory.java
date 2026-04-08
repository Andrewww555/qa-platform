package org.qaplatform.testdata;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.Map;

public class TestUserFactory {
    private final Faker faker = new Faker(Locale.ENGLISH);

    public Map<String, String> createUser() {
        return Map.of(
                "username", faker.name().username(),
                "email", faker.internet().emailAddress(),
                "role", "customer"
        );
    }
}
