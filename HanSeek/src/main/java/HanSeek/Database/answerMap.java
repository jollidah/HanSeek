package HanSeek.Database;
import org.json.JSONObject;

import java.util.HashMap;

public class answerMap {
    private static HashMap <String, JSONObject> answerMap = new HashMap<>();
    private static long ID;

    public static HashMap<String, JSONObject> getAnswerMap() {
        return answerMap;
    }

//    public static void setAnswerMap(HashMap<String, JSONObject> answerMap) {
//        answerMap.answerMap = answerMap;
//    }
}
