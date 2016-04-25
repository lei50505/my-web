package cn.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.rest.entity.User;
import cn.rest.service.UserService;

@RestController
public class GreetingController {

    private Logger log = Logger.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/hello.do", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> hello() {
        log.info("进入");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Hello");
        log.info("完成");
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/error.do", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> error() {
        log.info("进入");
        System.out.println(10 / 0);
        Map<String, Object> map = new HashMap<String, Object>();
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/add.do", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> add() {
        log.info("进入");
        User user = new User("张三", 1);
        userService.add(user);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", user.toString());
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
}
