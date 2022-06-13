package com.example.chuck_norris_jokes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import guru.springframework.norris.chuck.ChuckNorrisQuotes;

@RequestMapping("/")
@Controller
public class IndexController {

    @RequestMapping
    public String getJoke(Model model) {
        ChuckNorrisQuotes jokes = new ChuckNorrisQuotes();
        model.addAttribute("joke", jokes.getRandomQuote());

        return "index";
    }
}
