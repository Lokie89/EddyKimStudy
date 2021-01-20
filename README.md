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

- Dependency Injection ( 의존성 주입 )
    - 객체 내부에서 다른 객체를 생성 하는 것이 아니라<br>
      객체 외부에서 파라미터를 통해 객체를 받는 것

```java
class A {
    public A(B b) {
        // 생성자를 통한 DI
    }

    public void setB(B b) {
        // 메서드를 통한 DI
    }
}

class Main {
    public static void main(String[] args) {
        A a = new A(new B());
        a.setB(new B());
        // 이런 방법으로 외부에서 의존성 주입 해줌
    }
}
```

- 스프링의 DI
    - 스프링은 빈 컨테이너<br>
      빈 컨테이너에서 같은 빈 컨테이너에 등록되어있는 객체가<br>
      필요한 객체를 DI 받을 때 해당 타입에 맞는 객체 ( 추가로 이름까지 ) 를 찾아<br>
      주입해주는 것

```java
class A {
    public A(B b) {
        // 생성자를 통한 DI
    }

    public void setB(B b) {
        // 메서드를 통한 DI
    }
}

class Main {
    public static void main(String[] args) {
       // A 와 B 가 모두 빈 컨테이너에 등록 되어있다면
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        A a = context.getBean("a");
        // 빈 컨테이너에서 꺼내온 A는 이미 B를 DI 받아 가지고 있음
    }
}
```

3. 네이버 오픈 API 에 애플리케이션 등록
4. 샘플 소스를 개발 툴 IntelliJ 에서 실행해보고 잘 되는지 확인
5. 샘플 소스의 응답 데이터 필드
6. 테스트 코드 작성
7. 영화 외 다른 검색 서비스 추가
    - News 검색 서비스 추가
    
### 2주차 과제
1. 임베디드 톰캣의 쓰레드 풀 사이즈를 변경해보세요.
    - application.properties `-Dserver.tomcat.max-threads=400` 추가
2. 샘플 소스 영화 검색 API 응답 데이터 필드 누락 수정
    - actor, director 추가
3. 영화 외 다른 검색 서비스 연동
    - 뉴스 검색 서비스
4. 영화 검색 시 평점이 0인 데이터는 제외하는 기능
    - getMovieGroupFilterZero()
5. API 디자인 지침 글 읽기
6. 영화 평점 순 정렬 단위 테스트
    - shouldSortedInOrderOfGrade()
7. 영화 검색시 평점 0인 데이터 제외 단위 테스트 (@SpringBootTest 사용하지 말 것)
   - shouldFilterZeroOfGrade()
8. 네이버 오픈 API 인증 실패일 경우 예외 처리
9. 검색들이 사용하는 검색 기능 로직 중 RestTemplate 을 공통 사용 부분 리팩토링
10. RestTemplate Bean 설정값 모두 application.yml 파일로 분리
11. FeignClient 사용해 볼 것
