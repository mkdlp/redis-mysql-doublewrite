package com.mkdlp.eshop.inventory.request;

import com.mkdlp.eshop.inventory.model.ProductInventory;
import com.mkdlp.eshop.inventory.service.ProductInventoryService;

/**
 * 更新数据库里缓存数据的请求
 */
public class ProductInventoryDBUpdateRequest implements Request {

    /**
     * 商品库存
     */
    private ProductInventory productInventory;
    /**
     * 商品库存Service
     */
    private ProductInventoryService productInventoryService;

    public ProductInventoryDBUpdateRequest(ProductInventory productInventory,
                                           ProductInventoryService productInventoryService) {
        this.productInventory = productInventory;
        this.productInventoryService = productInventoryService;
    }

    @Override
    public void process() {
        System.out.println("===========日志===========: 数据库更新请求开始执行，商品id=" + productInventory.getProductId() + ", 商品库存数量=" + productInventory.getInventoryCnt());
        // 删除redis中的缓存
        productInventoryService.removeProductInventoryCache(productInventory);
        // 修改数据库中的库存

        // 为了模拟演示先删除了redis中的缓存，然后还没更新数据库的时候，读请求过来了，这里可以人工sleep一下
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        productInventoryService.updateProductInventory(productInventory);
    }

    /**
     * 获取商品id
     */
    public Integer getProductId() {
        return productInventory.getProductId();
    }

    @Override
    public boolean isForceRefresh() {
        return false;
    }
}
