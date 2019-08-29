package cn.mrcode.cache.eshop.productserver.model;

/**
 * 商品规格
 */
public class ProductSpecification {
	private Long id;
	// 如：分辨率: 2436x1125像素
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
