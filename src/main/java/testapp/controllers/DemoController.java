package testapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {
    
    @RequestMapping(value="/index.html", method=RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "First spring boot return!";
    }

    @RequestMapping(value="/home.html", method=RequestMethod.GET)
    public String home() {
        return "home.html";
    }
}
