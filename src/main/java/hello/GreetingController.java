package hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {


    private static final String TEMPLATE = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(TEMPLATE, name));
    }

    @RequestMapping("/hello")
    public Greeting hello(@RequestParam(value="nom", defaultValue="Toi") String nom) {
        return new Greeting(42,
                            String.format("Bonjour, %s !", nom));
    }

    @RequestMapping("/kill")
    public Greeting kill(@RequestParam(value="nom", defaultValue="Toi") String nom) {
        System.exit(99);
        return new Greeting(666,"Session Killed !");
    }

    @RequestMapping("/cpu")
    public Greeting cpu(@RequestParam(value="time", defaultValue="10") String time) {
        int i=2;
        int y=3;
        while (i==2) {
		y=y+1;
	}
        return new Greeting(99,
                            String.format("%s pour 100 CPU !", time));
    }

}
