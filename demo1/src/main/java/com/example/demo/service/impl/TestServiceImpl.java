package com.example.demo.service.impl;

import com.example.demo.service.QuestService;
import com.example.demo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.*;

@Service
public class TestServiceImpl implements TestService {


    @Autowired
    QuestService service;

    class Request{
        String code;
        String serialNo;
        CompletableFuture future;
    }
    LinkedBlockingQueue<Request> queue = new LinkedBlockingQueue<>();
    private int count;

    @Override
    public String sayHello() {
        count++;
        return "第"+count+"次hello service";
    }

    @Override
    public String batchHello(List<Map<String,Object>> params) {
        count++;
        return "第"+count+"次hello service";
    }


    public Map<String,Object> queryInfo(String code){
      try{
//          String serialNo = UUID.randomUUID().toString();
          String serialNo = code;
          Request request = new Request();
          request.code = code;
          request.serialNo = serialNo;
          CompletableFuture<Map<String,Object>> future = new CompletableFuture<>();
          request.future = future;
          queue.add(request);
          return future.get();
      }catch (Exception e){
          e.printStackTrace();
      }
      return null;
    }


    @PostConstruct
    public void init(){
        ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(1);
        scheduled.scheduleAtFixedRate(() -> {
            int size = queue.size();
            if(size==0){
                return;
            }
            ArrayList<Request> requests = new ArrayList<>();
            for(int i=0;i<size;i++){
                Request request = queue.poll();
                requests.add(request);
            }
            System.out.println("批处理数量："+size);
            List<Map<String ,Object>> params = new ArrayList<>();
            for(Request request :requests){
                Map<String ,Object> map = new HashMap<>();
                map.put("code",request.code);
                map.put("serialNo",request.serialNo);
                params.add(map);

            }
//                List<Map<String,Object>> response = TestService.batchHello
            List<Map<String,Object>> responses=service.batchHello(params);
            HashMap<String ,Map<String ,Object>> responseMap = new HashMap<>();
            for(Map<String ,Object> response : responses){

                String serialNo = response.get("serialNo").toString();
                responseMap.put(serialNo,response);
            }
        },0,11, TimeUnit.MILLISECONDS);

    }

}
