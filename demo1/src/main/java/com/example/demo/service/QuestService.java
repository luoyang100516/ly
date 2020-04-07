package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface QuestService {
    String sayHello();

    List<Map<String,Object>> batchHello(List<Map<String, Object>> params);
}
