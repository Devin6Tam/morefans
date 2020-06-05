># 框架介绍
```
├─.idea
│  ├─inspectionProfiles
│  └─libraries
├─basic-common                                                          公共组件库
│  ├─basic-common-bom                                                   组件清单，api接扣清单
│  ├─basic-common-core
│  │  ├─src
│  │  │  └─main
│  │  │      ├─java
│  │  │      │  └─com
│  │  │      │      └─morefans
│  │  │      │          └─basic
│  │  │      │              └─core
│  │  │      │                  ├─base
│  │  │      │                  ├─constant
│  │  │      │                  └─util
│  │  │      └─resources
│  ├─basic-common-mybatis                                               mybaitis 组件包
│  │  ├─src
│  │  │  └─main
│  │  │      ├─java
│  │  │      │  └─com
│  │  │      │      └─morefans
│  │  │      │          └─common
│  │  │      │              └─mybatis
│  │  │      │                  ├─common
│  │  │      │                  │  ├─mapper
│  │  │      │                  │  └─service
│  │  │      │                  │      └─impl
│  │  │      │                  ├─config
│  │  │      │                  └─properties
│  │  │      └─resources
│  │  │          └─META-INF                                             swagger接口渲染组件包
│  └─basic-common-swagger                                               
│      ├─src
│      │  └─main
│      │      ├─java
│      │      │  └─com
│      │      │      └─morefans
│      │      │          └─common
│      │      │              └─swagger
│      │      │                  └─autoconfig
│      │      └─resources
│      │          └─META-INF
├─k8s-docker                                                            暂未使用
│  ├─dubbo
│  └─nacos
├─mfs-activity                                                          活动微服务
│  ├─activity-service-api                                               活动服务api接口
│  │  ├─src
│  │  │  └─main
│  │  │      └─java
│  │  │          └─com
│  │  │              └─morefans
│  │  │                  └─activity
│  │  │                      ├─constant
│  │  │                      ├─dto
│  │  │                      ├─dubbo
│  │  │                      │  └─service
│  │  │                      ├─pojo
│  │  │                      ├─request
│  │  │                      │  └─vo
│  │  │                      └─response
│  │  │                          └─vo
│  └─activity-service-biz                                               活动服务实现
│      ├─src
│      │  └─main
│      │      ├─java
│      │      │  └─com
│      │      │      └─morefans
│      │      │          └─activity
│      │      │              ├─dubbo
│      │      │              │  └─service
│      │      │              │      └─impl
│      │      │              ├─mapper
│      │      │              └─service
│      │      │                  └─impl
│      │      └─resources
│      │          └─mybatis
├─mfs-api                                                              api接口（app后端）
│  ├─src
│  │  └─main
│  │      ├─java
│  │      │  └─com
│  │      │      └─morefans
│  │      │          └─api
│  │      │              ├─controller
│  │      │              └─facade
│  │      └─resources
│  │          └─mybatis
├─mfs-backend                                                          后台管理平台
│  ├─backend-service-api                                               系统服务api接口
│  │  ├─src
│  │  │  └─main
│  │  │      └─java
│  │  │          └─com
│  │  │              └─morefans
│  │  │                  └─backend
│  │  │                      ├─dto
│  │  │                      ├─dubbo
│  │  │                      │  └─service
│  │  │                      ├─pojo
│  │  │                      ├─vo
│  └─backend-service-biz                                              系统服务实现
│      ├─src
│      │  ├─main
│      │  │  ├─java
│      │  │  │  └─com
│      │  │  │      └─morefans
│      │  │  │          └─backend
│      │  │  │              ├─autoconfig
│      │  │  │              ├─controller
│      │  │  │              ├─dubbo
│      │  │  │              │  └─service
│      │  │  │              ├─facade
│      │  │  │              ├─mapper
│      │  │  │              └─service
│      │  │  └─resources
│      │  │      └─mybatis
            ├─mfs-stars                                             明星社圈                                            
│  ├─stars-service-api                                              明星社圈api接口
│  │  ├─src
│  │  │  └─main
│  │  │      └─java
│  │  │          └─com
│  │  │              └─morefans
│  │  │                  └─star
│  │  │                      ├─dto
│  │  │                      ├─dubbo
│  │  │                      │  └─service
│  │  │                      ├─pojo
│  │  │                      ├─service
│  │  │                      └─vo
│  └─stars-service-biz                                             明星社圈实现
│      ├─src
│      │  ├─main
│      │  │  ├─java
│      │  │  │  └─com
│      │  │  │      └─morefans
│      │  │  │          └─stars
│      │  │  │              ├─dubbo
│      │  │  │              │  └─service
│      │  │  │              ├─mapper
│      │  │  │              └─service
│      │  │  └─resources
├─mfs-trade                                                       交易端服务
│  ├─trade-service-api                                            交易端服务api接口                                   
│  │  ├─src
│  │  │  └─main
│  │  │      └─java
│  │  │          └─com
│  │  │              └─morefans
│  │  │                  └─trade
│  │  │                      ├─dto
│  │  │                      ├─pojo
│  │  │                      ├─service
│  │  │                      └─vo
│  └─trade-service-biz                                           交易端服务实现
│      ├─src
│      │  ├─main
│      │  │  ├─java
│      │  │  │  └─com
│      │  │  │      └─morefans
│      │  │  │          └─trade
│      │  │  │              ├─dubbo
│      │  │  │              │  └─service
│      │  │  │              ├─mapper
│      │  │  │              └─service
│      │  │  └─resources
```

```
SpringMVC 实现层面
---------------------
controller              -- 控制器
pojo,mapper,service     -- 正常的数据层，业务逻辑层
vo                      -- 用于视图层的请求，响应的实体
dto                     --  用于数据层的对象数据整合，且并不返回对应的持久化对象’

微服务实现层面
---------------------
dubbo.service           -- dubbo 服务
facade                  -- 外观  dubbo服务的整合，以及数据整理、封装

```


># 快速进入开发

参考宣讲笔记来执行
http://note.youdao.com/noteshare?id=45fff0d401b32db3cb05fa12ba79ab4e

># 流程部署

## 开发环境准备
### nacos 安装
需要准备虚拟机，安装docker，docker-compose
`git clone https://github.com/nacos-group/nacos-docker.git
docker-compose -f example/standalone-mysql.yaml up`


### 本地环境运行
mvn clean package -Dmaven.skip=true -P dev

执行对应application入口文件

