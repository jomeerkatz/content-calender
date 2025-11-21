package jomeerkatz.springboot.content_calender.controller;

import jomeerkatz.springboot.content_calender.config.ContentCalenderProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {
    private ContentCalenderProperties contentCalenderProperties;

    public HomeController(ContentCalenderProperties contentCalenderProperties){
        this.contentCalenderProperties = contentCalenderProperties;
    }

    @GetMapping("/")
    public ContentCalenderProperties helloWorld() {
        return contentCalenderProperties;
    }


}
