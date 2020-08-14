package com.demo.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {

    public static String handleException(BlockException exception) {
        return "自定义限流处理信息....CustomerBlockHandler";
    }
}
