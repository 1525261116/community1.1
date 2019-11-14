## community demo
## 资料

[es社区 模板](https://elasticsearch.cn )

[spring 文档](https://spring.io/guides)

[git Oauth apps](https://developer.github.com/apps/building-oauth-apps/authorizing-oauth-apps/)

[mvnrepository](https://mvnrepository.com)
[sql](
Create Table

CREATE TABLE `comment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) NOT NULL,
  `parent_type` int(11) DEFAULT NULL COMMENT '父类类型',
  `commentator` int(11) NOT NULL COMMENT '评论人',
  `gmt_create` bigint(20) DEFAULT NULL,
  `gmt_modified` bigint(20) DEFAULT NULL,
  `like_count` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
)

## 工具
