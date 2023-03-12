package HanSeek.Database;

import com.google.gson.Gson;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class answerString {
    private static long id = 0L;

    public static long allocateNewId() {
        return id++;
    }

    public static String getResult(String answerString, String key){
        String result = "";
        Map<String, String> resultHash;
        try {
            InputStream inputStream = answerString.class.getClassLoader().getResourceAsStream("model_result.json");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            Gson gson = new Gson();
            Map<String, Map <String, String>> JSONhash = gson.fromJson(inputStreamReader, Map.class);
            resultHash = JSONhash.get(answerString);
            result = resultHash.get(key);
        } catch (Exception e) {
            System.out.println("ERROR occured_get result");
            e.printStackTrace();
        }
        return result;
    }
}
