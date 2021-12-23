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
    void TestJsonParser() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("StratingGameTest.json");
        try(is) {
            this.jsonSchema = new JSONObject(new JSONTokener(is));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(jsonSchema, new JSONObject(new JSONTokener((is))));
    }

    @org.junit.jupiter.api.Test
    public final void testParser() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("StratingGameTest.json");
        JSONObject requestJson = new JSONObject(new JSONTokener(is));
        Assertions.assertEquals(jsonParser.Parser(is), requestJson);
    }
}
