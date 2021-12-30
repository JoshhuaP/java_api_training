package fr.lernejo.navy_battle.Json;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JsonParserTest {
    JsonParser jsonParser;
    JSONObject jsonSchema;
    InputStream inputStream = new InputStream() {
        @Override
        public int read() throws IOException {
            return 0;
        }
    };

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
        }
        Assertions.assertNotNull(jsonSchema);
    }

    @org.junit.jupiter.api.Test
    public final void test_Parser_jsonSchema() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("StratingGameTest.json");
        JSONObject requestJson = new JSONObject(new JSONTokener(is));
        Assertions.assertNotNull(jsonParser.jsonSchema);
    }

    @Test
    public void test_parser() {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("StratingGameTest.json");
        Assertions.assertDoesNotThrow(()->jsonParser.Parser(is));
    }
}
