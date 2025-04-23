package com.example.demo.controllers;

import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
public class AboutController {
    //add a mapping for About button/page
    @GetMapping({"/About"})
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword){
        return "About";
    }
}
