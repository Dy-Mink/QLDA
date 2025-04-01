package com.example.banquanaonam.contro;

import com.example.banquanaonam.Entity.Product;
import com.example.banquanaonam.service.Productservice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class BanQuanAoNam {
    private final Productservice productservice;

    public BanQuanAoNam(Productservice productservice) {
        this.productservice = productservice;
    }

    // SAN PHAM
    @GetMapping("/sanpham")
    public String sanpham(Model model) {
        model.addAttribute("sanpham", productservice.getAll());
        return "/QuanAoNam/sanpham/sanpham";
    }

    @GetMapping("/detail/{id}")
    public String detail(Model model, @PathVariable int id) {
        Product product = productservice.getById(id);
        model.addAttribute("sanpham", product);
        return "/QuanAoNam/sanpham/detail";
    }

    @GetMapping("/timKiem")
    public String timKiem(@RequestParam("name") String name, Model model){
        model.addAttribute("sanpham",productservice.timKiem(name));

        return "/QuanAoNam/sanpham/sanpham";
    }
}
