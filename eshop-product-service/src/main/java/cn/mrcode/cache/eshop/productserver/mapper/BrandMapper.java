package cn.mrcode.cache.eshop.productserver.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mrcode.cache.eshop.productserver.model.Brand;

@Mapper
public interface BrandMapper {

    @Insert("INSERT INTO brand(name,description) VALUES(#{name},#{description})")
    void add(Brand brand);

    @Update("UPDATE brand SET name=#{name},description=#{description} WHERE id=#{id}")
    void update(Brand brand);

    @Delete("DELETE FROM brand WHERE id=#{id}")
    void delete(Long id);

    @Select("SELECT * FROM brand WHERE id=#{id}")
    Brand findById(Long id);
}
