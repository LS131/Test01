package com.baizhi.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("page")
@Slf4j
public class PageController {

    @RequestMapping("demo01")
    public String demo01(){
        log.info("demo01...........");
        return "/demo01";
    }
}
