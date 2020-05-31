package com.morefans.mfs_nacos_demo.controller;


import com.morefans.mfs_nacos_demo.service.BalanceService;
import com.morefans.mfs_nacos_demo.domain.User;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AccountController {

    final static Map<Integer, User> userMap = new HashMap() {{
        put(1, new User(1, "张三",null));
        put(2, new User(2, "李四",null));
        put(3, new User(3, "王五",null));
    }
    };

    @Reference
    private BalanceService balanceService;

    @RequestMapping("/acc/user")
    public User getUser(@RequestParam Integer id) {
        if(id != null && userMap.containsKey(id)) {
            User user = userMap.get(id);
            user.setBalance(balanceService.getBalance(id));
            return user;
        }
        return new User(0, "",null);
    }

}
