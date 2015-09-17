package ash.app.status.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Sentinel on 9/12/2015.
 */
@RestController
@RequestMapping("/status")
public class StatusController {

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public String getTest(){
        System.out.println("Inside GET");
        return "index";
    }
}
