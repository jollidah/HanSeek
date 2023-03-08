package HanSeek.domain;

import org.json.JSONObject;
import org.json.JSONException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class answerDatabase{
    private final JSONObject answerData = new JSONObject();

    public JSONObject add(String key, String value) throws JSONException {
        answerData.put(key, value);
        return answerData;
    }

    public void sendToModel(JSONObject answerData) {
        try{
            long ID = (long) answerData.get("ID");
            String path = String.format("HanSeek/Database/DataToModel/%d.json", ID);
            PrintWriter out = new PrintWriter(new FileWriter(path));
            out.write(answerData.toString());
            
        }catch (IOException e){
            System.out.println("IOException while sending data to model");
        } catch (JSONException e) {
            System.out.println("JSONException while sending data to model");
        }
    }
}
