package HanSeek.Controller;

import HanSeek.Database.answerString;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class pageController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping ("/queries/query1")
    public String createQuestion_tmp(Model model) {
        long userId = answerString.allocateNewId();
        String tmp ="";
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", tmp);
        return "/queries/query1_meat_fish";
    }

//    @GetMapping("/queries/query1_meat_fish")
//    public String createQuestion_1(@RequestParam("userId") long userId,
//                                   @RequestParam("answerString") String answerString,
//                                    Model model) {
//        model.addAttribute("userId", userId);
//        model.addAttribute("answerString", answerString);
//        return "/queries/query1_meat_fish";
//    }

//    @GetMapping("/queries/query1_meat_fish")
//    public String page_1(){
//        return "/queries/query1_meat_fish";
//    }

    @PostMapping("answer_1")
    public String saveAnswer_1(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_1_button") String ans,
                               Model model) {
        answerString += ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        if (answerString.charAt(0) == '1') {
            return "/queries/query2_meat";
        } else if(answerString.charAt(1) == '1'){
            return "/queries/query3_fish";
        } else {
            return "/queries/query4_carbohydrate";
        }
    }

//    @GetMapping("/queries/query2_meat")
//    public String page_2(){
//        return "/queries/query2_meat";
//    }

    @PostMapping("answer_2")
    public String saveAnswer_2(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_2_button") String ans,
                               Model model) {
        answerString = ans + answerString.charAt(1);
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        if (answerString.charAt(1) == '1'){
            return "/queries/query3_fish";
        } else{
            return "/queries/query4_carbohydrate";
        }
    }

    @PostMapping("answer_3")
    public String saveAnswer_3(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_3_button") String ans,
                               Model model) {
        answerString = answerString.charAt(0) + ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        return "/queries/query4_carbohydrate";
    }

    @PostMapping("answer_4")
    public String saveAnswer_4(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_4_button") String ans,
                               Model model) {
        answerString += ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        return "/queries/query5_recipe";
    }

    @PostMapping("answer_5")
    public String saveAnswer_5(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_5_button") String ans,
                               Model model) {
        answerString += ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        return "/queries/query6_spicy";
    }

    @PostMapping("/answer_6")
    public String saveAnswer_6(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_6_button") String ans,
                               Model model) {
        answerString += ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        return "/queries/query7_taste";
    }

    @PostMapping("/answer_7")
    public String saveAnswer_7(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_7_button") String ans,
                               Model model) {
        answerString += ans;
        System.out.println(answerString);
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        // send to model

        model.addAttribute("result_1", HanSeek.Database.answerString.getResult(answerString));
        model.addAttribute("result_2", HanSeek.Database.answerString.getResult(answerString));
        model.addAttribute("result_3", HanSeek.Database.answerString.getResult(answerString));
        model.addAttribute("result_1_url", "/img/" + HanSeek.Database.answerString.getResult(answerString) + ".png");
        model.addAttribute("result_2_url", "/img/" + HanSeek.Database.answerString.getResult(answerString) + ".png");
        model.addAttribute("result_3_url", "/img/" + HanSeek.Database.answerString.getResult(answerString) + ".png");
        return "/result";
    }

@PostMapping("feedback")
public String getResult(@RequestParam("userId") long userId,
                        @RequestParam("bestResult") String bestResult,
                        @RequestParam("attendance") char attendance,
                        @RequestParam("feedback") String feedback,
                        Model model){

    // save file
    if(attendance == 'Y'){
        model.addAttribute("userId", userId);
        return "/survey";
    } else{
        return "/final";
    }
}

    @PostMapping("surveyform")
    public String surveyPage(@RequestParam("userId") long userId,
                             @RequestParam("name") String name,
                             @RequestParam("gender") char gender,
                             @RequestParam("nationality") String nationality,
                             @RequestParam("phone_number") String phone_number,
                             @RequestParam("visit_length") char visit_length){
        // save file
        return "/final";
    }


    @GetMapping("final")
    public String finalPage(){
        return "final";
    }
}
