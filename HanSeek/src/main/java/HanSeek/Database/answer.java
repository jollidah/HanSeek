package HanSeek.Database;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.jackson.JsonObjectDeserializer;
import org.springframework.stereotype.Repository;

@Repository
public interface answer {
    JSONObject getById(long id);
    long makeNewId() throws JSONException;
    void sendToModel(long id);

    void addData(long id, String Question, int ans);

}
