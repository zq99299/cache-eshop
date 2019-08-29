package cn.mrcode.cache.eshop.productserver.model;

/**
 * 商品属性
 */
public class ProductProperty {
    private Long id;
    // 如 机身颜色 iPhoneX【5.8寸黑色】 、 iPhoneX【5.8寸银色】
    private String name;
    private String value;
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
