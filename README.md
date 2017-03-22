# simpleDubbo

spring+dubbo+restful

2个service ：simple-customer / simple-service 相互间存在接口调用

simple-spi 接口 实体类保存

simple-web restful

持久层用 mongdb - 建议封装 mongoTemplate （simple-web 里面 还为把 mongdb 根据业务 分开 web里面测试）后期可以把mongdb单独放在一个 simple-common里面
