package com.fanshoufeng.mysqlnginx.controller;

import com.fanshoufeng.mysqlnginx.entity.Visitor;
import com.fanshoufeng.mysqlnginx.repository.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class VisitoryController {

    @Autowired
    private VisitorRepository visitorRepository;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        String ip = request.getRemoteAddr();
        Visitor visitor = visitorRepository.findByIp(ip);
        long times;
        if (visitor == null) {
            visitor = new Visitor();
            visitor.setIp(ip);
            times = 1L;
        } else {
            times = visitor.getTimes() + 1;
        }
        visitor.setTimes(times);
        visitorRepository.save(visitor);
        return "I have been seen ip " + ip + " " + times + " times.";
    }

}
