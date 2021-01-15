## eddy kim study

### 1주차 과제

1. 어노테이션이 어떤 기능을 하는지 정리

#### Spring

- @RestController
    - @Controller 는 보통 View 를 반환,<br>
      @RestController 는 데이터를 반환 하기 위해 사용함
    - @Controller 에 @ResponseBody 가 결합된 형태
    - application/json 나 text/plain 데이터 반환 타입 을 사용한다. [참고](https://wondongho.tistory.com/76) <br>
- @RequestMapping
    - 말그대로 요청을 매핑시켜준다.<br>
      클라이언트에서 요청한 url 을 해당 클래스, 메서드에 매핑시켜줌
    - value, method, params, headers 등 조건 사용

[comment]: <> (    - [***dispatcher-servlet***]&#40;https://mangkyu.tistory.com/18&#41;)

- @GetMapping
    - @RequestMapping 에 method=RequestMethod.GET 이 포함
    - 메서드 레벨에서만 사용 가능
    - method 만 다른 내용으로 PostMapping, PutMapping, DeleteMapping, PatchMapping이 있음
- @Service
    - @Component 와 큰 차이 없음 그냥 명시적인 것
- @Component
    - spring 에서 bean 으로 관리하기 위해 사용하는 기본적인 어노테이션
    - 비슷한 어노테이션으로 @Bean 이 있음<br>
      Bean 은 직접 제어가 불가능한 외부 라이브러리, Component 는 직접 작성한 클래스<br>
      사용처는 Bean 은 메서드( 리턴되는 객체 ) Component ( 타입 ) 에 사용 됨 [참고](https://galid1.tistory.com/494)
- @Configuration
    - 스프링 컨테이너에게 Bean 을 구성하기 위해 사용하는 설정 값임을 알려줌
- @SpringBootApplication
    - @EnableAutoConfiguration, @SpringBootConfiguration, @ComponentScan 포함
#### Lombok

- @Getter
    - 해당 타입, 필드 의 get 메서드 생성
- @Setter
    - 해당 타입, 필드 의 set 메서드 생성
- @Data
    - @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode 포함
    - @RequiredArgsConstructor final 로 정의된 필드를 매개변수로 하여 주입하는 Constructor 생성
- @Builder
    - Builder Pattern 을 이용한 정적 클래스 생성

2. 스프링 프레임워크의 DI란
3. 네이버 오픈 API 에 애플리케이션 등록
4. 샘플 소스를 개발 툴 IntelliJ 에서 실행해보고 잘 되는지 확인
5. 샘플 소스의 응답 데이터 필드
6. 테스트 코드 작성
7. 영화 외 다른 검색 서비스 추가