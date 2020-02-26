package com.controller;

import com.service.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomepageController
{
    @Autowired
    private HomepageService homepageService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        System.out.println("login");
        model.addAttribute("name", "Dear");
        return "login";
    }

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
        String countryId = "11";
        String countryName = homepageService.getCountryNameByCountryId(countryId);
        System.out.println(countryName);

        return "index";
    }

    @RequestMapping(value = "console", method = RequestMethod.GET)
    public String console(Model model) {
        System.out.println("login");
        model.addAttribute("name", "Dear");
        return "console";
    }

    @RequestMapping(value = "pachong", method = RequestMethod.POST)
    @ResponseBody
    public String pachong() {
        System.out.println("pachong");

        return "success";
    }

}
