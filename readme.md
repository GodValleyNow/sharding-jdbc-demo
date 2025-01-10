# 主要内容
- 使用 ShardingSphere ShardingSphere-JDBC实现 MySQL 水平分库、水平分表、垂直分库、垂直分表
- 使用 ShardingSphere ShardingSphere-JDBC实现读写分离
- 使用 ShardingSphere ShardingSphere-JDBC实现分页查询
  - [官方分页文档](https://shardingsphere.apache.org/document/4.1.0/cn/features/sharding/use-norms/pagination/)
# 前置条件
- 为了测试方便，使用docker搭建mysql挂载卷方式，参考：[Docker搭建Mysql主从复制](https://www.chenhuazhan.com/ui/details/159)
- 表结构啥的请参考本文下面那个文档

# 版本说明
- shardingsphere 4.0.0-RC1
- springboot 2.2.11.RELEASE
- jdk 1.8
- mysql 8.0

# 使用说明
- spring.profiles.active来激活不同的配置
- 为了测试方便，主从配置的是一台虚拟机
- master端口号3307，slave端口号3308，3306是之前测试的一个docker容器，可以把所有的3306都改成3307
- 测试方法在[ShardingJDBCApplicationTests.java](src%2Ftest%2Fjava%2FShardingJDBCApplicationTests.java)
- 虚拟机ip，用户名密码请根据实际情况修改application.yml中的文件
# 参考
- [使用 ShardingSphere 实操MySQL分库分表实战](https://segmentfault.com/a/1190000038241298)
- 配套视频：[尚硅谷Sharding Sphere，Sharding JDBC，分库分表利器，数据库中间件](https://www.bilibili.com/video/BV1LK411s7RX/?spm_id_from=333.788.player.switch&vd_source=ab28dddadb542b4f26d2fadcc8dc61af&p=11)