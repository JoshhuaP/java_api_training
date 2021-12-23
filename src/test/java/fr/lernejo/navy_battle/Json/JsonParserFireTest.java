package fr.lernejo.navy_battle.Json;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Assertions;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class JsonParserFireTest {
    JsonParser jsonParser;
    JSONObject jsonSchema;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        jsonParser = new JsonParser();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        jsonParser = null;
    }

    @org.junit.jupiter.api.Test
    void TestJsonParser() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("FireTest.json");
        try(is) {
            this.jsonSchema = new JSONObject(new JSONTokener(is));
        }
        Assertions.assertNotNull(jsonSchema);
    }

    @org.junit.jupiter.api.Test
    public final void testParser() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("FireTest.json");
        JSONObject requestJson = new JSONObject(new JSONTokener(is));
        Assertions.assertNotNull(requestJson);
    }
}
