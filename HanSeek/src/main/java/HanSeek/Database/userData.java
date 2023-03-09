package HanSeek.Database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

public class userData {
    private long id;
    private String bestResult;
    private String feedback;


    public userData(long id, String bestResult, String feedback) {
        this.id = id;
        this.bestResult = bestResult;
        this.feedback = feedback;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBestResult() {
        return bestResult;
    }

    public void setBestResult(String bestResult) {
        this.bestResult = bestResult;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

//    public void saveUserData() {
//        try{
//            String Path = ""
//            Gson gson = new GsonBuilder().setPrettyPrinting().create();
//            gson.toJson(this);
//            FileWriter fw = new FileWriter();
//
//        }catch (Exception e){
//            System.out.println("IOException while sending data to model");
//            e.printStackTrace();
//        }
//    }

}
