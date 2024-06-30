package com.vv.study1.chain;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author kw
 * @program WorkProject
 * @description
 * @create 2024 - 06 - 02 20:32
 **/
public class ServiceHandlerChain {
    private List<ServiceHandler> handlerList = new LinkedList<>();


    public void addHandler(ServiceHandler serviceHandler) {
        handlerList.add(serviceHandler);
    }

    public ProductInfo execute(ProductInfo productInfo) {
        CompletableFuture[] futures = handlerList.stream().map(handler -> handler.handle(productInfo))
                .toArray(CompletableFuture[]::new);
        CompletableFuture<Void> future = CompletableFuture.allOf(futures);
        future.join();
        return productInfo;
    }


    public static void main(String[] args) {
        ProductInfo productInfo = new ProductInfo();
        ServiceHandlerChain chain = new ServiceHandlerChain();
        chain.addHandler(new BasicInfoService());
        chain.addHandler(new PriceServiceHandler());
        chain.addHandler(new ActivityServiceHandler());

        ProductInfo execute = chain.execute(productInfo);
        System.out.println(execute);
    }
}
