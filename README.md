# SPM
## 环境
### IntelliJ IDEA 2019
### MySQL 8.0以上
## 部署方法
### 在IDEA中连接上数据库
#### 修改resources/application.property中的spring.datasource相关
#### 修改pom.xml中org.flywaydb相关
### 执行 mvn flyway:migrate
### 编译执行
