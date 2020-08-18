package com.demo.service.impl;

import com.demo.mapper.AccountMapper;
import com.demo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountMapper accountMapper;

    /**
     * 扣减账户余额
     */
    @Override
    public void decrease(Long userId, BigDecimal money) {

        log.info("------->account-service中扣减账户余额开始");
//        try {
//            TimeUnit.SECONDS.sleep(20);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        accountMapper.decrease(userId, money);
        log.info("------->account-service中扣减账户余额结束");
    }
}
