package com.vlat.KafkaLearn.controller;

import com.vlat.KafkaLearn.service.StringProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private StringProducerService stringProducerService;

    @PostMapping("/string")
    public ResponseEntity<Object> saveString(@RequestBody String string){

        stringProducerService.send(string);

        return  ResponseEntity.status(HttpStatus.CREATED).body("saved");
    }

}
