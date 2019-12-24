# SPM
## 环境
### IntelliJ IDEA 2019
### MySQL 8.0以上
## 部署方法
### 在IDEA中连接上数据库
#### 建立spm_assignment数据库
#### 修改resources/application.property中的spring.datasource相关
#### 修改pom.xml中org.flywaydb相关
### 执行 mvn flyway:migrate
### 编译执行
## 默认端口：8500
## ccf认证pdf文件存储的OSS服务器可能在1月份会到期（我可能不会续费了，如果不能使用请联系qq595157823,电话15262532728，谢谢老师）