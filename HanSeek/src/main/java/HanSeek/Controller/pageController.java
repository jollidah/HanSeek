package HanSeek.Controller;

import HanSeek.Database.answerString;
import HanSeek.Database.User;

import HanSeek.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class pageController {
    final UserService userService;

    @Autowired
    public pageController(UserService userService) {
        this.userService = userService;
    }

    // GetMapping

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("queries/query1_meat_fish")
    public String page1() {
        return "queries/query1_meat_fish";
    }

    @GetMapping("queries/query2_meat")
    public String page2() {return "queries/query2_meat";}

    @GetMapping("queries/query3_seafood")
    public String page3() {return "queries/query3_seafood";}

    @GetMapping("queries/query4_carbohydrate")
    public String page4() {return "queries/query4_carbohydrate";}

    @GetMapping("queries/query5_recipe")
    public String page5() {return "queries/query5_recipe";}

    @GetMapping("queries/query6_spicy")
    public String page6() {return "queries/query6_spicy";}

    @GetMapping("queries/query7_taste")
    public String page7() {return "queries/query7_taste";}

    @GetMapping("result")
    public String resultPage() {return "result";
    }

    @GetMapping("survey")
    public String surveyPage() {return "survey";
    }

    @GetMapping("final")
    public String finalPage() {return "final";
    }

    // PostMapping

    @PostMapping("queries/query1")
    public String createQuestion_tmp(Model model) {
        long userId = answerString.allocateNewId();
        String tmp = "";
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", tmp);
        return "queries/query1_meat_fish";
    }

    @PostMapping("/answer_1")
    public String saveAnswer_1(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_1_button") String ans,
                               Model model) {
        answerString += ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        if (answerString.charAt(0) == '1') {
            return "queries/query2_meat";
        } else if (answerString.charAt(1) == '1') {
            return "/queries/query3_seafood";
        } else {
            return "queries/query4_carbohydrate";
        }
    }

    @PostMapping("/answer_2")
    public String saveAnswer_2(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_2_button") String ans,
                               Model model) {
        answerString = ans + answerString.charAt(1);
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        if (answerString.charAt(1) == '1') {
            return "/queries/query3_seafood";
        } else {
            return "queries/query4_carbohydrate";
        }
    }

    @PostMapping("/answer_3")
    public String saveAnswer_3(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_3_button") String ans,
                               Model model) {
        answerString = answerString.charAt(0) + ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        return "queries/query4_carbohydrate";
    }

    @PostMapping("/answer_4")
    public String saveAnswer_4(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_4_button") String ans,
                               Model model) {
        answerString += ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        return "queries/query5_recipe";
    }

    @PostMapping("/answer_5")
    public String saveAnswer_5(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_5_button") String ans,
                               Model model) {
        answerString += ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        return "queries/query6_spicy";
    }

    @PostMapping("answer_6")
    public String saveAnswer_6(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_6_button") String ans,
                               Model model) {
        answerString += ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        return "queries/query7_taste";
    }

    @PostMapping("answer_7")
    public String saveAnswer_7(@RequestParam("userId") long userId,
                               @RequestParam("answerString") String answerString,
                               @RequestParam("answer_7_button") String ans,
                               Model model) {
        answerString += ans;
        model.addAttribute("userId", userId);
        model.addAttribute("answerString", answerString);
        // send to model
        String r1 = HanSeek.Database.answerString.getResult(answerString, "first");
        String r2 = HanSeek.Database.answerString.getResult(answerString, "second");
        String r3 = HanSeek.Database.answerString.getResult(answerString, "third");
        model.addAttribute("result_1", r1);
        model.addAttribute("result_2", r2);
        model.addAttribute("result_3", r3);
        model.addAttribute("result_1_url", "/img/" + r1 + ".jpg");
        model.addAttribute("result_2_url", "/img/" + r2 + ".jpg");
        model.addAttribute("result_3_url", "/img/" + r3 + ".jpg");
        return "result";
    }

    @PostMapping("feedback")
    public String getResult(@RequestParam("userId") long userId,
                            @RequestParam("answerString") String answerString,
                            @RequestParam("bestResult") String bestResult,
                            @RequestParam(value = "attendance", defaultValue = "N") String attendance,
                            @RequestParam("feedback") String feedback,
                            Model model) {
        User user = new User();
        user.setId(userId);
        user.setAnswerString(answerString);
        user.setBestResult(bestResult);
        user.setFeedback(feedback);
        user.setAttendance(attendance);
        userService.saveUser(user);
        if (attendance.equals("Y")) {
            model.addAttribute("userId", userId);
            return "survey";
        } else {
            userService.printUserLog(userId);
            return "final";
        }
    }

    @PostMapping("surveyForm")
    public String createSurvey(@RequestParam("userId") long userId,
                               @RequestParam("name") String name,
                               @RequestParam("gender") String gender,
                               @RequestParam("nationality") String nationality,
                               @RequestParam("email") String email,
                               @RequestParam("visit_length") String visit_length) {
        User user = (User) userService.getUserById(userId);
        user.setName(name);
        user.setGender(gender);
        user.setNationality(nationality);
        user.setEmail(email);
        user.setVisit_length(visit_length);
        userService.printUserLog(userId);
        return "final";
    }
}