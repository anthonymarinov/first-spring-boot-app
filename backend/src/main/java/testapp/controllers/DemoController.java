package testapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import testapp.daos.DemoDao;
import testapp.daos.Todo;

import java.util.List;

@Controller
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private DemoDao demoDao;
    
    @RequestMapping(value="/index", method=RequestMethod.GET)
    @ResponseBody
    public String index() {
        return "First spring boot return!";
    }

    @RequestMapping(value="/todos", method=RequestMethod.GET)
    @ResponseBody
    public List<Todo> todos() {
        return demoDao.getAllTodos();
    }

    @RequestMapping(value="/home.html", method=RequestMethod.GET)
    public String home(ModelMap modelMap) {
        modelMap.addAttribute("name", demoDao.getFirstName());
        return "home.html";
    }
}
