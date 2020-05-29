package com.charver.cloud.service.impl;

import com.charver.cloud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * @ClassName OrderServiceImpl <br>
 * @Description TODO <br>
 *
 * @Author njchen
 * @Date 2020/1/6 16:20
 * @Version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final String REST_URL_PREFIX = "http://service-member";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Map<String, String> getMemberList() {
        return restTemplate.getForObject("http://localhost:8001" + "/member/list", Map.class);
    }

    @Override
    public Object discovery() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/member/discovery", Object.class);
    }

}
