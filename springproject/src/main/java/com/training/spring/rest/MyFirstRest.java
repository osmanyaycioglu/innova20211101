package com.training.spring.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/first")
public class MyFirstRest {

    @GetMapping("/hello2/{isim}/xyz/{soyisim}")
    public String hello2(@PathVariable("isim") final String name,
                         @PathVariable("soyisim") final String surname) {
        return "hello 2 " + name + " " + surname;
    }


    @GetMapping("/hello4/{abc}")
    public String hello4(@PathVariable("abc") final String name,
                         @RequestParam("soyisim") final String surname) {
        return "hello 4 " + name + " " + surname;
    }

    // Yapma
    @GetMapping("/hello5/{cmd}")
    public ResponseEntity<?> hello5(@PathVariable("komut") final String cmd,
                                    final HttpServletRequest hsp) {
        switch (cmd) {
            case "add":
                return ResponseEntity.ok("Addwd " + hsp.getParameter("abc"));
            case "get":
                return ResponseEntity.ok(new Result().setDesc("xyxy")
                                                     .setName(hsp.getParameter("xyz")));
            case "abc":
                return ResponseEntity.ok("abc");

            default:
                return ResponseEntity.ok("default");
        }
    }

    @GetMapping("/hello7/{isim}")
    public String hello7(@PathVariable("isim") final String name) {
        return "hello 7 " + name;
    }

    @GetMapping("/hello3")
    public String hello3(@RequestParam("isim") final String name,
                         @RequestParam("soyisim") final String surname) {
        return "hello 3 " + name + " " + surname;
    }

    @PostMapping("/hello6")
    public String hello6(@RequestBody final Person person) {
        return "hello 6 : " + person;
    }

    @GetMapping("/hello8")
    public ResponseEntity<String> hello8(@RequestHeader("isim") final String name,
                                         @RequestHeader("soyisim") final String surname) {
        return ResponseEntity.status(200)
                             .header("test",
                                     "headerTest")
                             .body("hello 8 " + name + " " + surname);
    }


    @GetMapping("/hello1")
    public String hello1() {
        return "hello 1";
    }

    @PostMapping("/hello1")
    public String hello1p() {
        return "hello 1 Post";
    }

    @DeleteMapping("/hello1")
    public String hello1d() {
        return "hello 1 Delete";
    }

    @PutMapping("/hello1")
    public String hello1put() {
        return "hello 1 Put";
    }

    @PatchMapping("/hello1")
    public String hello1patch() {
        return "hello 1 Patch";
    }

}
