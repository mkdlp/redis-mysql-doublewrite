package com.mkdlp.eshop.inventory.request;

import com.mkdlp.eshop.inventory.model.ProductInventory;
import com.mkdlp.eshop.inventory.service.ProductInventoryService;

/**
 * 重新加载商品库存的缓存
 */
public class ProductInventoryCacheRefreshRequest implements Request {

    /**
     * 商品的ID
     */
    private Integer productId;

    private ProductInventoryService productInventoryService;

    /**
     * 是否强制刷新缓存
     */
    private boolean forceRefresh;

    public ProductInventoryCacheRefreshRequest(Integer productId, ProductInventoryService productInventoryService, boolean forceRefresh) {
        this.productId = productId;
        this.productInventoryService = productInventoryService;
        this.forceRefresh = forceRefresh;
    }

    @Override
    public void process() {

        //首先查询数据库
        ProductInventory productInventory=productInventoryService.findProductInventory(productId);
        System.out.println("===========日志===========: 已查询到商品最新的库存数量，商品id=" + productId + ", 商品库存数量=" + productInventory.getInventoryCnt());
        //然后再刷新缓存
        productInventoryService.setProductInventoryCache(productInventory);

    }

    @Override
    public Integer getProductId() {
        return productId;
    }

    public boolean isForceRefresh() {
        return forceRefresh;
    }
}
