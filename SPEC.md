# 项目规格说明书 - test-MybatisFlex

## 基本信息

| 项目名 | test-MybatisFlex |
|--------|-----------------|
| 路径 | /Users/junw/Documents/GitHub/test-MybatisFlex |
| 简介 | MyBatis-Flex 框架的测试与学习项目 |
| 技术栈 | Spring Boot 3.x + MyBatis-Flex 1.x + MySQL 8.0 + Lombok |
| License | AGPL-3.0 |

## 功能概述

- MyBatis-Flex 基础 CRUD 操作
- 关联查询（多表关联）
- 查询构造器（QueryWrapper）
- 分页查询
- 多租户支持
- 逻辑删除
- 审计自动填充
- 自定义 SQL

## 项目结构

```
src/main/java/wo1261931780/testMybatisFlex/
├── TestMybatisFlexApplication.java  # 启动类
├── domain/        # 实体类（TbAccount 等）
├── mapper/       # Mapper 接口
├── service/      # 业务服务层
└── controller/  # 控制器层
```

## 核心功能示例

### 基础 CRUD
通过继承 BaseMapper<User> 自动获得 insert/select/update/delete 方法。

### 链式查询
```java
QueryWrapper.create()
    .select()
    .from(USER)
    .where(USER.USERNAME.like(username))
    .orderBy(USER.CREATE_TIME.desc());
```

### 分页查询
```java
userMapper.paginate(pageNum, pageSize, queryWrapper);
```

## 编译问题

**编译问题：Lombok @Setter 生成的 setter 方法在编译时丢失**

错误信息示例：
```
cannot find symbol: method setUserName(java.lang.String)
cannot find symbol: method setAge(int)
cannot find symbol: method setBirthday(java.util.Date)
```

原因分析：
- Lombok 注解处理器未正确执行
- TbAccount 实体类的 setter 方法编译时不存在
- MyBatis-Flex 需要实体类有完整的 getter/setter 或使用其注解配置字段映射
- Lombok 1.18.x 与 JDK 25 存在兼容性问题

建议解决方案：
1. 升级 Lombok 至 1.18.32+ 版本
2. 在 pom.xml 中显式配置 annotationProcessorPaths
3. 执行 `mvn clean compile` 清理后重编译
4. 检查是否需要额外配置 MyBatis-Flex 的表字段映射
5. 如持续有问题，可暂时降级至 JDK 21/17

## 数据库表结构

### tb_account 示例

| 字段 | 类型 | 说明 |
|------|------|------|
| id | bigint | 主键 |
| user_name | varchar | 用户名 |
| age | int | 年龄 |
| birthday | date | 生日 |

## 技术亮点

- 轻量级 ORM，相比 MyBatis-Plus 更灵活
- 支持自定义 SQL 和自动生成 SQL 混合使用
- 强大的查询构造器
- 内置分页、逻辑删除、审计等功能

## 环境要求

- JDK 17+（JDK 25 存在 Lombok 兼容问题）
- MySQL 8.0+
- Maven 3.6+
