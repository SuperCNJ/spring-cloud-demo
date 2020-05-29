package com.charver.cloud.service;

import java.util.Map;

/**
 * @ClassName OrderService <br>
 * @Description TODO <br>
 *
 * @Author njchen
 * @Date 2020/1/6 16:19
 * @Version 1.0
 */
public interface OrderService {

    Map<String, String> getMemberList();

    Object discovery();
}
