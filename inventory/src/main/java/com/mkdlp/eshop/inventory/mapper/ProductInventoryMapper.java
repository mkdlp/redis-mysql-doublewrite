package com.mkdlp.eshop.inventory.mapper;

import com.mkdlp.eshop.inventory.model.ProductInventory;
import org.apache.ibatis.annotations.Param;

/**
 * ProductInventoryMapper接口
 */
public interface ProductInventoryMapper {

    /**
     * 更新库存数量
     */
    void updateProductInventory(ProductInventory productInventory);

    /**
     * 根据商品id查询商品库存信息
     * @param productId 商品id
     * @return 商品库存信息
     */
    ProductInventory findProductInventory(@Param("productId") Integer productId);
}
