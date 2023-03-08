package HanSeek.Database;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class answerMap implements answer {

    private static HashMap<Long, JSONObject> answerMap = new HashMap<>();
    private static long id = 0L;

    @Override
    public JSONObject getById(long inputId) {
        return answerMap.get(inputId);
    }

    @Override
    public long makeNewId() {
        try {
            JSONObject tmp = new JSONObject();
            tmp.put("UserId", id);
            answerMap.put(id, tmp);
        } catch (Exception e) {
            System.out.println("ERROR while making new object");
            e.printStackTrace();
        }
        return id++;
    }

    @Override
    public void sendToModel(long inputId) {
//        try{
        System.out.println(getById(inputId).toString());
//            String path = String.format("HanSeek/Database/DataToModel/%d.json", inputId);
//            PrintWriter out = new PrintWriter(new FileWriter(path));
//            out.write(getById(inputId).toString());
//        }catch (IOException e){
//            System.out.println("IOException while sending data to model");
//            e.printStackTrace();
//        }
    }

    @Override
    public void addData(long inputId, String Question, int ans) {
        try {
            getById(inputId).put(Question, ans);
        } catch (JSONException e) {
            System.out.println("JSONJSONException - while adding data at JSONObject");
            e.printStackTrace();
        }
    }
}
