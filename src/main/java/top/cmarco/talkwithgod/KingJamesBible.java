package top.cmarco.talkwithgod;

import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public final class KingJamesBible {

    private final TalkWithGod talkWithGod;
    private JSONArray jsonArray;


    public KingJamesBible(TalkWithGod talkWithGod) {
        this.talkWithGod = talkWithGod;
    }

    public void load() {
        InputStream inputStream = talkWithGod.getResource("kjv.json");
        String json = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)).lines().collect(Collectors.joining("\n"));
        this.jsonArray = new JSONArray(json);
    }


    public JSONArray getJsonArray() {
        return jsonArray;
    }

    public int getLength() {
        return this.jsonArray.length();
    }

    public String getWord(int i) {
        return this.jsonArray.getJSONObject(i).getString("verse");
    }
}
