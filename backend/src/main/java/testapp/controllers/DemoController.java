package testapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import testapp.daos.DemoDao;
import testapp.daos.Todo;

import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class DemoController {

    @Autowired
    private DemoDao demoDao;
    
    @RequestMapping(value="/todos", method=RequestMethod.GET)
    @ResponseBody
    public List<Todo> todos() {
        return demoDao.getAllTodos();
    }

    @RequestMapping(value="/todos", method=RequestMethod.POST)
    @ResponseBody
    public String addTodo(@RequestParam String name) {
        return demoDao.insertTodo(name);
    }
    

    @RequestMapping(value="/index", method=RequestMethod.GET)
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
