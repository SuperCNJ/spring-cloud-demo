package com.charver.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @ClassName OrderClientService <br>
 * @Description TODO <br>
 * @Author njchen
 * @Date 2020/3/24 15:31
 * @Version 1.0
 */
//@FeignClient(value = "service-member")
@FeignClient(value = "service-member", fallbackFactory = OrderClientServiceFallbackFactory.class)
public interface OrderClientService {

    @RequestMapping("/member/list")
    Map<String, String> getMemberList();

    @RequestMapping("/member/discovery")
    Object discovery();
}
