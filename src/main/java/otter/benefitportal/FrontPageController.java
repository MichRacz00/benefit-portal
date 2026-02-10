package otter.benefitportal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FrontPageController {

    @RequestMapping("/")
    public String index() {
        return "/front-page/front-page.html";
    }
}
