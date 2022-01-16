package com.ysj.file.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("//download")
public class Download {

    @GetMapping("/index")
    public String Index(){
        return "index";
    }

    @GetMapping("/music")
    public String Download(@RequestParam("file") String filename){

        return "";
    }
}
