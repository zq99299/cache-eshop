package cn.mrcode.cache.eshop.productserver.model;

/**
 * 商品内容
 */
public class ProductIntro {

    private Long id;
    // 里面存储 1.jpg,2.jpg,3.jpg 图片名称
    private String content;
    private Long productId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

}
