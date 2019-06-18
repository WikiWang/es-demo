ES-DEMO
===========
This is the demo of ElasticSearch restful api project build with springboot.

Runtime environment:
======================
Java 1.8  
elasticsearch 6.2.2  
maven 3.6.0	  
springboot 2.1.5  
postman 7.2.0  

Project structure:
======================
```
├── README.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com
│   │   │       └── example
│   │   │           └── es
│   │   │               └── demo
│   │   │                   ├── EsDemoApplication.java
│   │   │                   ├── controller
│   │   │                   │   └── EsController.java
│   │   │                   ├── domain
│   │   │                   │   └── Message.java
│   │   │                   ├── exception
│   │   │                   │   ├── BaseClientException.java
│   │   │                   │   ├── BaseSystemException.java
│   │   │                   │   ├── NotFoundException.java
│   │   │                   │   ├── SerializeRuntimeException.java
│   │   │                   │   └── error
│   │   │                   │       ├── ErrorDefine.java
│   │   │                   │       ├── ErrorMsg.java
│   │   │                   │       └── ErrorType.java
│   │   │                   ├── handler
│   │   │                   │   └── ErrorHandlerControllerAdvice.java
│   │   │                   ├── repository
│   │   │                   │   └── MessageRepository.java
│   │   │                   ├── sesrvice
│   │   │                   │   ├── MessageService.java
│   │   │                   │   └── impl
│   │   │                   │       └── MessageServiceImpl.java
│   │   │                   └── utils
│   │   │                       └── JsonUtil.java
│   │   └── resources
│   │       └── application.yml
│   └── test
│       └── java
│           └── com
│               └── example
│                   └── es
│                       └── demo
└── testcase
    ├── es-test.postman_collection.json
    └── es-test.postman_environment.json
```

Guide:
======================
## install elasticsearch
download elasticsearch 6.2.2 <https://www.elastic.co/downloads/past-releases/elasticsearch-6-2-2>

## install elasticsearch-head(visual interface, you can use kibana instead)
github: <https://github.com/mobz/elasticsearch-head>

## modified `elasticsearch.yml`, add
```
http.cors.enabled: true
http.cors.allow-origin: "*"
```
## import es-demo project into your IDE(IDEA or Eclipse...)
### modified `application.yml`
```
#elasticsearch config 
spring:
  data:
    elasticsearch:
      cluster-name: elasticsearch
      cluster-nodes: 127.0.0.1:9300
      repositories:
        enabled: true
```
### start `EsDemoApplication.java`

## test with postman
#### import `/testcase/es test.postman_collection.json` and `testcase/es test.postman_environment.json` into postman
#### choose environment `es test` then you can test.











