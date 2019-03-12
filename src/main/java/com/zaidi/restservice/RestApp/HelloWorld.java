package com.zaidi.restservice.RestApp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public  class HelloWorld{

    @GetMapping
    public String helloWorld(){
        return "hello world";
    }

    @GetMapping(value = "/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public Car json(){
        return  new Car("Honda","Civic");

    }

    private class Car {
        private  String manufecturer;
        private  String name;

        public String getManufecturer() {
            return manufecturer;
        }

        public void setManufecturer(String manufecturer) {
            this.manufecturer = manufecturer;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Car(String manufecturer, String name) {
            this.manufecturer = manufecturer;
            this.name = name;
        }
    }
}




