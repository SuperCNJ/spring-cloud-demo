package com.charver.cloud.controller;

import com.charver.cloud.service.OrderClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @ClassName OrderController <br>
 * @Description TODO <br>
 *
 * @Author njchen
 * @Date 2020/1/6 16:17
 * @Version 1.0
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderClientService orderClientService;

    @RequestMapping("/getMemberList")
    @ResponseBody
    public Map<String, String> getMemberList() {
        return orderClientService.getMemberList();
    }

    @RequestMapping("/memberDiscovery")
    @ResponseBody
    public Object memberDiscovery() {
        return orderClientService.discovery();
    }

}
