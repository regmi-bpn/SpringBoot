package com.bipin.bootjpa.controller;

import com.bipin.bootjpa.model.Alien;
import com.bipin.bootjpa.dao.AlienRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class AlienController {

    @Autowired
    AlienRepo repo;

    @RequestMapping("/home")
    public String home(){
        return "home";
    }

    @RequestMapping("/addAlien")
    public String addAlien(Alien alien){

        repo.save(alien);
        return "home";
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam int aid){
        ModelAndView mv = new ModelAndView("showAlien");
        Alien alien = repo.findById(aid).orElse(new Alien());

        System.out.println(repo.findByTech("Java"));
        mv.addObject(alien);

        return mv;
    }
}
