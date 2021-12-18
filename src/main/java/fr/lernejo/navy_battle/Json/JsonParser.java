package fr.lernejo.navy_battle.Json;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.everit.json.schema.loader.SchemaLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.Map;

public class JsonParser {
    final JSONObject jsonSchema;
    public JsonParser() throws IOException {
        InputStream is = this.getClass().getClassLoader().getResourceAsStream("StratingGame.json");
        try(is) {
            this.jsonSchema = new JSONObject(new JSONTokener(is));
        }
    }
    public final JSONObject Parser(InputStream inputStream) {
        try (inputStream) {
            JSONObject requestJson = new JSONObject(new JSONTokener(inputStream));
            SchemaLoader.load(jsonSchema).validate(requestJson);
            return requestJson;
        } catch (IOException e) {
            e.printStackTrace();
        }
         return null;
     }
}
