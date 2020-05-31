package com.morefans.mfs_nacos_demo.service.impl;


import com.morefans.mfs_nacos_demo.domain.Balance;
import com.morefans.mfs_nacos_demo.service.BalanceService;
import org.apache.dubbo.config.annotation.Service;

import java.util.HashMap;
import java.util.Map;

@Service(interfaceClass = BalanceService.class,protocol = "dubbo")
public class InMemoryBalanceService implements BalanceService {

    final static Map<Integer, Balance> balanceMap = new HashMap() {
        {
            put(1, new Balance(1, 10, 1000,""));
            put(2, new Balance(2, 0, 10000,""));
            put(3, new Balance(3, 100, 0,""));
        }
    };

    @Override
    public Balance getBalance(Integer id) {
        if(id != null && balanceMap.containsKey(id)) {
            return balanceMap.get(id);
        }
        return new Balance(0, 0, 0, "不存在");
    }
}
