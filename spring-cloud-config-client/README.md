## Spring Cloud Config Server
* Spring Cloud Config
  * https://docs.spring.io/spring-cloud-config/docs/current/reference/html/

---

## 목차
* [Programming Language](#programming-language)
* [Framework](#framework)
* [Build Tool](#build-tool)
* [Library](#library)
* [Profile](#profile)
* [Package](#package)
* [Filename Prefix/Suffix](#filename-prefixsuffix)
* [Method Prefix/Suffix](#method-prefixsuffix)
* [Properties](#properties)

---

### Programming Language
* Java : OpenJDK 17

---

### Framework
* Spring Boot : 3.2.2

---

### Build Tool
* Gradle : 8.5

---

### Library
* Spring Boot
  * spring-boot-starter-web
  * spring-boot-starter-actuator
  * spring-boot-starter-test
* Spring Cloud
 * spring-cloud-config-server

---

### Profile
* application.yml
    * spring.profiles.active는 local, dev, qa, prod로 구분
    * spring.profiles.active 값에 따라서 import 목록을 구분
        * database-*.yml - DataSource 설정
        * environment-*.yml - 환경 설정

---

### Package
* Controller 관련된 클래스는 com.daekyo.ds.{domain}.controller 하위에 작성
* Service 관련된 클래스는 com.daekyo.ds.{domain}.service 하위에 작성
* Dto 관련된 클래스는 com.daekyo.ds.{domain}.dto 하위에 작성
* Repsository 관련된 클래스는 com.deakyo.ds.{domain}.repository 하위에 작성
* Mapper 관련된 클래스 com.daekyo.ds.{domain}.mapper 하위에 작성, SQLMapper는 resource.mapper.* 하위에 작성

---

### Filename Prefix/Suffix
#### Filename suffix
* XXXController : 요청값을 검사하고 응답값을 반환하기 위한 클래스
* XXXService : 비지니스 로직을 처리하기 위한 클래스
* XXXDto : 파라미터를 전달 받기 위한 클래스
* XXXRepository : JpaRepository를 상속받아 Entity의 기본적인 CRUD를 사용하기 위한 인터페이스
* XXXRepositoryCustom : QueryDSL을 사용하는 메소드를 정의하는 인터페이스
* XXXRepositoryImpl : CustomRepository를 구현하는 클래스
* XXXMapStruct : Entity와 Dto간의 매핑을 위한 인터페이스
* XXXSpecification : JPA Specification 사용하여 다중 조건을 구현하기 위한 클래스
* XXXMapper : 저장 프로시저나 SQL문으로 객체를 연결하기 위한 클래스
* XXXUtils : 공통 유틸리티 클래스

---

### Method Prefix/Suffix
#### Mapper Method prefix
* selectXXX : select 질의문으로 단일행을 조회하는 경우
* selectXXXs : select 질의문으로 다중행을 조회하는 경우
* selectXXXCount : select 질의문으로 갯수를 조회하는 경우 
* insertXXX : insert 질의문으로 단일행을 저장하는 경우
* insertXXXs : insert 질의문으로 다중행을 저장하는 경우 
* updateXXX : update 질의문으로 단일행을 수정하는 경우
* updateXXXs : update 질의문으로 다중행을 수정하는 경우 
* mergeXXX : merge 질의문으로 단일행을 입력하는 경우
* mergeXXXs : merge 질의문으로 다중행을 수정하는 경우
* 
#### Service Method prefix
* getXXX : 객체를 반환하는 경우
* setXXX : 객체를 설정하는 경우
* buildXXX : 객체를 빌더 패턴으로 설정하는 경우
* insertXXX : 객체를 저장하는 경우
* updateXXX : 객체를 수정하는 경우
* deleteXXX : 객체를 삭제하는 경우
* bulkInsertXXX : 객체를 다중으로 저장하는 경우
* bulkUpdateXXX : 객체를 다중으로 수정하는 경우
* bulkDeleteXXX : 객체를 다중으로 삭제하는 경우

---

### Response Format
* HTTP 상태 코드와 응답 헤더 및 본문을 전달하기 위하여 ResponseEntity을 사용
* body는 BaseReponse 또는 ErrorResponse로 응답

---

### Properties
#### Properties 폴더 구조
* application 명
  * profile 명 - local / dev / qa / prod
    * 예) api1/local/

#### Properties 파일 작성
* *.properties 파일이 아닌 *.yml 파일로 작성
* 파일명은 application 명-설정 파일명-profile 명으로 작성
  * 예) api1-datasource-local.yml
* 설정 파일명
  * DataSource, JPA, Redis 등 RDS, NoSQL 과 관련된 내용은 datasource 명으로 작성
    * 예) api1-datasource-local.yml
  * 암호화, 외부 API 정보, S3, Sentry 등 환경 설정과 관련된 내용은 environment 명으로 작성
    * 예) api1-environment-local
---
