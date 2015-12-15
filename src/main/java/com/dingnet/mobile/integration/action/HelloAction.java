package com.dingnet.mobile.integration.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jordan on 2015/12/7.
 */
@Controller
public class HelloAction {

    @RequestMapping(value = "/helloworld",method ={ RequestMethod.GET,RequestMethod.POST})
    public @ResponseBody
    Map<String,String> hello(@RequestParam(value = "name",name = "name", required=true,defaultValue = "abc") String name){
        Map<String,String> returnmap = new HashMap<>();
        returnmap.put("abc","134");
        returnmap.put("name",name);
        return returnmap;
    }
}
