package com.neusoft.controller;

import com.alibaba.fastjson.JSON;
import com.neusoft.domain.Dept;
import com.neusoft.mapper.DeptMapper;
import com.neusoft.service.HelloService;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.rmi.log.LogInputStream;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HelloController {
        @Autowired
        HelloService helloService;
        @RequestMapping("/hello")
        public String hello ()
        {
            Dept dept = helloService.GetDeptByID(20);
            return "hello";
        }
    @RequestMapping("/check/{username}")
    public void check(HttpServletResponse response, @PathVariable String username) throws IOException {
        response.setContentType("text/html;charset=utf8");

        Dept dept = new Dept();
        dept.setDname("张三");
        dept.setDeptno(42);
        dept.setLoc("沈阳");
        String json = JSON.toJSONString(dept);

        List<Dept> list = new ArrayList<Dept>();
        list.add(dept);
        Dept dept1 = new Dept();
        dept1.setDname("李四");
        dept1.setDeptno(36);
        dept1.setLoc("大连");
        list.add(dept1);
        String json1=JSON.toJSONString(list);

        if(username.length() < 6)
        {
            response.getWriter().println(json1);
        }
        else
        {
            response.getWriter().println(json1);
        }

    }
    @RequestMapping(value="/table_c/{id}",produces="application/text;charset=utf-8")
    @ResponseBody
    public String table_c(@PathVariable Integer id){
        Map<Integer,String> map=new HashMap<>();
            map.put(0,"邸狗");
            map.put(1,"张明阳");
            map.put(2,"陶倩");
            String content=map.get(id);
            return content;


    }




    }

