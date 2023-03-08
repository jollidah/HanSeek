package HanSeek.Controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class pageController {
    private final JSONObject answerData;

    @Autowired
    public pageController(JSONObject answerData){
        this.answerData = answerData;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("queries/query1")
    public String createQuestion(){

        return "queries/query1.html";
    }

//    @PostMapping("/question1/y")
//    public String create()

}
