package com.hhit.community.community.mapper;

import com.hhit.community.community.model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 作者: 周鸿
 * @version v1.0 创建时间: 2019/9/7 15:43
 * @email 邮箱: 1525261116@qq.com
 * @description 描述:
 */
@Mapper
public interface QuestionMapper {
    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator_id,tag) values(#{title},#{description},#{gmtCreate},#{gmtModified},#{creatorId},#{tag})")
    void create(Question question);
    @Select("select * from question limit #{offset},#{size}")
    List<Question> list(@Param(value = "offset") Integer offset, @Param(value = "size") Integer size);
    @Select("select count(1) from question")
    Integer count();
}
