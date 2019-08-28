package cn.mrcode.cache.eshop.productserver.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.mrcode.cache.eshop.productserver.model.Category;

@Mapper
public interface CategoryMapper {

    @Insert("INSERT INTO category(name,description) VALUES(#{name},#{description})")
    void add(Category category);

    @Update("UPDATE category SET name=#{name},description=#{description} WHERE id=#{id}")
    void update(Category category);

    @Delete("DELETE FROM category WHERE id=#{id}")
    void delete(Long id);

    @Select("SELECT * FROM category WHERE id=#{id}")
    Category findById(Long id);

}
