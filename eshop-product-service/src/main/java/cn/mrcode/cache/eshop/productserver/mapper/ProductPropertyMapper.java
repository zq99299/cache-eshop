package cn.mrcode.cache.eshop.productserver.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mrcode.cache.eshop.productserver.model.ProductProperty;

@Mapper
public interface ProductPropertyMapper {
	
	@Insert("INSERT INTO product_property(name,value,product_id) VALUES(#{name},#{value},#{productId})")  
	public void add(ProductProperty productProperty);
	
	@Update("UPDATE product_property SET name=#{name},value=#{value},product_id=#{productId} WHERE id=#{id}")  
	public void update(ProductProperty productProperty);
	
	@Delete("DELETE FROM product_property WHERE id=#{id}")  
	public void delete(Long id);
	
	@Select("SELECT * FROM product_property WHERE id=#{id}")  
	public ProductProperty findById(Long id);
	
}
