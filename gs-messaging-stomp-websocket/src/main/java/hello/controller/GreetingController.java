package hello.controller;

import hello.bean.Greeting;
import hello.bean.HelloMessage;

import org.apache.log4j.Logger;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {

	Logger log = Logger.getLogger(GreetingController.class);

    @MessageMapping("/hello")
    @SendToUser("/message/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");
    }

    @MessageMapping("/bye")
    @SendTo("/topic/greetings")
    public Greeting bye(HelloMessage message) throws Exception {
        //Thread.sleep(3000); // simulated delay
       // return new Greeting("Good bye, " + message.getName() + " :(");
        return new Greeting("Good bye,  :(");
    }
}
