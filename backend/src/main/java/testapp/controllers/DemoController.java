package testapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import testapp.daos.DemoDao;

@Controller
public class DemoController {

    @Autowired
    private DemoDao demoDao;
    
    @RequestMapping(value="/index.html", method=RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "First spring boot return!";
    }

    @RequestMapping(value="/home.html", method=RequestMethod.GET)
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("name", demoDao.getFirstName());
        return "home.html";
    }
}
