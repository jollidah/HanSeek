package HanSeek.Controller;

import HanSeek.Database.answerMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class pageController {
    private final answerMap answerMap;

    @Autowired
    public pageController(answerMap answerMap) {
        this.answerMap = answerMap;
    }


    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/queries/query1")
    public String createQuestion_1(Model model) {
        long userId = answerMap.makeNewId();
        model.addAttribute("userId", userId);
        return "/queries/query1";
    }

    @GetMapping("answer_1")
    public String saveAnswer_1(@RequestParam("userId") long userId,
                               @RequestParam("answer_1_button") int ans,
                               Model model) {
        answerMap.addData(userId, "question_1", ans);
        model.addAttribute("userId", userId);
        return "/queries/query2";
    }

    @GetMapping("answer_2")
    public String saveAnswer_2(@RequestParam("userId") long userId,
                               @RequestParam("answer_2_button") int ans,
                               Model model) {
        answerMap.addData(userId, "question_2", ans);
        model.addAttribute("userId", userId);
        return "/queries/query3";
    }

    @GetMapping("answer_3")
    public String saveAnswer_3(@RequestParam("userId") long userId,
                               @RequestParam("answer_3_button") int ans,
                               Model model) {
        answerMap.addData(userId, "question_3", ans);
        model.addAttribute("userId", userId);
        return "/queries/query4";
    }

    @GetMapping("answer_4")
    public String saveAnswer_4(@RequestParam("userId") long userId,
                               @RequestParam("answer_4_button") int ans,
                               Model model) {
        answerMap.addData(userId, "question_4", ans);
        model.addAttribute("userId", userId);
        return "/queries/query5";
    }

    @GetMapping("answer_5")
    public String saveAnswer_5(@RequestParam("userId") long userId,
                               @RequestParam("answer_5_button") int ans,
                               Model model) {
        answerMap.addData(userId, "question_5", ans);
        model.addAttribute("userId", userId);
        return "/queries/query6";
    }

    @GetMapping("/answer_6")
    public String saveAnswer_6(@RequestParam("userId") long userId,
                               @RequestParam("answer_6_button") int ans,
                               Model model) {
        answerMap.addData(userId, "question_6", ans);
        answerMap.sendToModel(userId);
        model.addAttribute("userId", userId);
        return "redirect:/result";
    }


    @GetMapping("result")
    public String resultPage() {
        return "result";
    }

}
