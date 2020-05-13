package mpa.controller;


import mpa.domain.Item;
import mpa.service.MongoService;
import mpa.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    MongoService mongoService;

    @Value("${spring.data.mongodb.host}")
    private String mongoConfig;

    @RequestMapping("/greeting")
    public List<Greeting> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        ArrayList<Greeting>greetings = new ArrayList();
        greetings.add(new Greeting(counter.incrementAndGet(), String.format(template, name)));
        greetings.add(new Greeting(counter.incrementAndGet(), name));
        return greetings;
    }

    @RequestMapping(value = "/db", method = RequestMethod.GET)
    public Item getItem() {
        return mongoService.findItem();
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public String getConfig() {
        return mongoConfig;
    }

}
