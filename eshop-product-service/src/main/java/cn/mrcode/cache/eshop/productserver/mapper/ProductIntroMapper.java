package cn.mrcode.cache.eshop.productserver.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mrcode.cache.eshop.productserver.model.ProductIntro;

@Mapper
public interface ProductIntroMapper {

    @Insert("INSERT INTO product_intro(content,product_id) VALUES(#{content},#{productId})")
    public void add(ProductIntro productIntro);

    @Update("UPDATE product_intro SET content=#{content},product_id=#{productId} WHERE id=#{id}")
    public void update(ProductIntro productIntro);

    @Delete("DELETE FROM product_intro WHERE id=#{id}")
    public void delete(Long id);

    @Select("SELECT * FROM product_intro WHERE id=#{id}")
    public ProductIntro findById(Long id);

}
