package fr.lernejo.navy_battle.Json;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class JsonParserTest {
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
    void TestJsonParser() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("StratingGame.json");
        Assertions.assertEquals(jsonSchema, new JSONObject(new JSONTokener(Objects.requireNonNull(is))));
        Assertions.assertThrows(IllegalArgumentException.class, this::TestJsonParser);
    }

    @org.junit.jupiter.api.Test
    public final void testParser(InputStream inputStream) {
        JSONObject requestJson = new JSONObject(new JSONTokener(inputStream));
        Assertions.assertEquals(jsonParser.Parser(inputStream), requestJson);
        Assertions.assertThrows(IllegalArgumentException.class, ()->jsonParser.Parser(inputStream));
    }
}
