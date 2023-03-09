package HanSeek.Database;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class answerString {
    private static long id = 0L;

    public static long allocateNewId() {
        return id++;
    }

    public static String getResult(String answerString){
        String result = "";
        try {
            InputStream inputStream = answerString.class.getClassLoader().getResourceAsStream("model_result.json");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            Gson gson = new Gson();
            Map<String, String> resultHash = gson.fromJson(inputStreamReader, Map.class);
            result = resultHash.get(answerString);
        } catch (Exception e) {
            System.out.println("ERROR occured_get result");
            e.printStackTrace();
        }
        return result;
    }


//    public void saveUserData(String userData) {
//
//        try{
//            Gson gson = new Gson();
//            Map<String, String> tmpMap = new HashMap<>();
//            tmpMap.put(userData, new )
//        }catch (IOException e){
//            System.out.println("IOException while sending data to model");
//            e.printStackTrace();
//        }
//    }

}
