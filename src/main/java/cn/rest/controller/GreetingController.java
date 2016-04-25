package cn.rest.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cn.rest.util.ConfigUtils;

@RestController
public class GreetingController {

    private Logger log = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/hello.do", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> hello() {
        log.info("进入");
        log.info("driver: "+ConfigUtils.getString("db.driver"));
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("message", "Hello");
        log.info("完成");
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    @RequestMapping(value = "/error.do", method = RequestMethod.GET)
    public ResponseEntity<Map<String, Object>> error() {
        log.info("进入");
        int num = 10 / 0;
        System.out.println(num);
        Map<String, Object> map = new HashMap<String, Object>();
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }
}
