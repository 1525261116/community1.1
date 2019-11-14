package com.hhit.community.community.mapper;

import com.hhit.community.community.model.Question;
import org.apache.ibatis.annotations.*;

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

    @Select("select count(1) from question where creator_id=#{userId}")
    Integer countByUserId(@Param("userId") Integer userId);

    @Select("select * from question where creator_id=#{userId} limit #{offset},#{size}")
    List<Question> listByUserId(@Param("userId") Integer userId, @Param(value = "offset") Integer offset, @Param(value = "size") Integer size);
    @Select("select * from question where id=#{id}")
    Question findById(@Param("id") Integer id);
    @Update("update question set title=#{title} ,description=#{description},tag = #{tag},gmt_modified=#{gmtModified} where id =#{id}")
    void update(Question question);
    @Update("update question set view_count=#{viewCount} where id =#{id}")
    void updateViewCountById(@Param("id")Integer id,@Param("viewCount") Integer viewCount);
    @Update("update question set comment_count=#{commentCount} where id =#{id}")
    int updateCommentCount(@Param("id")Integer id,@Param("commentCount") Integer commentCount);
}
