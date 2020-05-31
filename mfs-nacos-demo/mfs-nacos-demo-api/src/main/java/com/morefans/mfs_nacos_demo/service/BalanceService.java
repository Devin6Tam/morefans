package com.morefans.mfs_nacos_demo.service;


import com.morefans.mfs_nacos_demo.domain.Balance;

public interface BalanceService {
    Balance getBalance(Integer id);
}