package com.vv.study1.chain;

import java.util.concurrent.CompletableFuture;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 06 - 02 20:31
 **/
public class ActivityServiceHandler implements ServiceHandler {


    @Override
    public CompletableFuture<Void> handle(ProductInfo productInfo) {
        CompletableFuture<Void> future = new CompletableFuture<>();
        CompletableFuture.runAsync(() -> {
            productInfo.setActivity("优惠活动");
            future.complete(null);
        });
        return future;
    }
}
