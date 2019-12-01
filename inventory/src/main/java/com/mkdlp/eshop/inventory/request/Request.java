package com.mkdlp.eshop.inventory.request;

/**
 * 请求的接口
 */
public interface Request {

    void process();

    Integer getProductId();

    boolean isForceRefresh();
}
