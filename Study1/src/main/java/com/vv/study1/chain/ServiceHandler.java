package com.vv.study1.chain;

import java.util.concurrent.CompletableFuture;

/**
 * @author kw
 * @program WorkProject
 * @description 责任链节点接口
 * @create 2024 - 06 - 02 20:25
 **/
public interface ServiceHandler {

    CompletableFuture<Void> handle(ProductInfo productInfo);
}
