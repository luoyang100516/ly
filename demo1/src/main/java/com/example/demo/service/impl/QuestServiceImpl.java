package com.example.demo.service.impl;

import com.example.demo.service.QuestService;
import com.example.demo.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.*;

@Service
public class QuestServiceImpl implements QuestService {


    private int count;
    @Override
    public String sayHello() {
        count++;
        return "第"+count+"次hello service";
    }

    @Override
    public List<Map<String,Object>> batchHello(List<Map<String,Object>> params) {
        List<Map<String,Object>> res = new ArrayList<>();
        for(Map<String ,Object> map :params){
            map.put("res",count*count);
            res.add(map);
            count++;
        }
        return res;
    }


}
