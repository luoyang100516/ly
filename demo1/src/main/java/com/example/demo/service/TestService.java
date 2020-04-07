package com.example.demo.service;

import java.util.List;
import java.util.Map;

public interface TestService {
    String sayHello();

    String batchHello(List<Map<String,Object>> params);
}
