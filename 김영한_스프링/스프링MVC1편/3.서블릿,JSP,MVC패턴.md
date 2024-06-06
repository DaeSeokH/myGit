## 서블릿으로 만든 웹 애플리케이션
 - 서블릿으로 회원목록 조회 HTML 응답
```java
@WebServlet(name = "memberListServlet", urlPatterns = "/servlet/members")
public class MemberListServlet extends HttpServlet {
   private MemberRepository memberRepository = MemberRepository.getInstance();
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.setContentType("text/html");
     response.setCharacterEncoding("utf-8");
     List<Member> members = memberRepository.findAll();
     PrintWriter w = response.getWriter();
     w.write("<html>");
     w.write("<head>");
     w.write(" <meta charset=\"UTF-8\">");
     w.write(" <title>Title</title>");
     w.write("</head>");
     w.write("<body>");
     w.write("<a href=\"/index.html\">메인</a>");
     w.write("<table>");
     w.write(" <thead>");
     w.write(" <th>id</th>");
     w.write(" <th>username</th>");
     w.write(" <th>age</th>");
     w.write(" </thead>");
     w.write(" <tbody>");
       for (Member member : members) {
         w.write(" <tr>");
         w.write(" <td>" + member.getId() + "</td>");
         w.write(" <td>" + member.getUsername() + "</td>");
         w.write(" <td>" + member.getAge() + "</td>");
         w.write(" </tr>");
       }
     w.write(" </tbody>");
     w.write("</table>");
     w.write("</body>");
     w.write("</html>");
   }
}
```
 - 자바코드로 HTML 문서를 만드는 것 보다 HTML문서에 동적으로 변경해야 하는 부분만 자바 코드로 넣는게 효율적이다.
 - 따라서 JSP,Thymeleaf 등 템플릿 엔진을 사용한다.

## JSP으로 만든 웹 애플리케이션
```java
<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
 MemberRepository memberRepository = MemberRepository.getInstance();
 List<Member> members = memberRepository.findAll();
%>
<html>
<head>
 <meta charset="UTF-8">
 <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
 <thead>
 <th>id</th>
 <th>username</th>
 <th>age</th>
 </thead>
 <tbody>
  <%
   for (Member member : members) {
   out.write(" <tr>");
   out.write(" <td>" + member.getId() + "</td>");
   out.write(" <td>" + member.getUsername() + "</td>");
   out.write(" <td>" + member.getAge() + "</td>");
   out.write(" </tr>");
   }
  %>
 </tbody>
</table>
</body>
</html>
```
 - <%@ page import="hello.servlet.domain.member.MemberRepository" %>는 자바의 import문과 같다.
 - <% ~~ %>는 자바 코드를 입력할 수 있다.
 - <%= ~~ %>는 자바 코드를 출력할 수 있다.
 - jsp가 너무 많은 역할을 하므로 비즈니스 로직은 서블릿 처럼 다른곳에서 처리, JSP는 VIEW에 집중하도록 하는 MVC패턴 등장

## MVC패턴 -개요
 - 컨트롤러 : HTTP 요청을 받아 파라미터 검증, 비즈니스 로직 실행, 뷰에 전달할 결과 데이터를 조회해서 모델에 담는다.
 - 모델 : 뷰에 출력할 데이터를 담는다. 뷰는 비즈니스로직이나 데이터 접근을 몰라도 되고, 화면을 렌더링 하는 일에 집중할 수 있다.
 - 뷰 : 모델에 담겨있는 데이터를 사용해서 화면을 그리는 일에 집중한다.
```
MVC 패턴 이전   
클라이언트 -호출-> (비즈니스 로직, 뷰 로직)

MVC 패턴1
클라이언트 -호출-> Controller(비즈니스로직) -> (데이터전달) -> Model(모델) -> (뷰는 데이터참조) -> View(뷰 로직) -> 응답

MVC 패턴2
클라이언트 -호출-> Controller(컨트롤러로직) -> 서비스,리포지토리(비즈니스 로직, 데이터 접근)   
-> (데이터전달) -> Model(모델) -> (뷰는 데이터참조) -> View(뷰 로직) -> 응답
 ```


## MVC패턴 -적용
```java
@WebServlet(name = "mvcMemberListServlet", urlPatterns = "/servlet-mvc/members")
public class MvcMemberListServlet extends HttpServlet {
   private MemberRepository memberRepository = MemberRepository.getInstance();
   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
     System.out.println("MvcMemberListServlet.service");
     List<Member> members = memberRepository.findAll();
     request.setAttribute("members", members);
     String viewPath = "/WEB-INF/views/members.jsp";
     RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
     dispatcher.forward(request, response);
   }
}
```
 - request.setAttribute(), request.getAttribute()를 사용하면 데이터를 보관,조회 가능
 - HttpServletRequest를 Model로 사용한다.
 - /WEB-INF 경로안에 있는 JSP는 직접 호출할 수 없고, 컨트롤러를 통해서 호출해야 한다.
 - redirect vs forward
   - redirect는 실제 클라이언트(웹 브라우저)에 응답이 나갔다가 클라이언트가 redirect 경로로 다시 요청(클라이언트가 인지하고, URL 경로도 실제로 변경됨)
   - forward는 서버 내부에서 일어나는 호출로 클라이언트가 전혀 인지하지 못함

 - 상대 경로 관련
```java
<!-- 상대경로 사용, [현재 URL이 속한 계층 경로 + /save] -->
<form action="save" method="post">
 username: <input type="text" name="username" />
 age: <input type="text" name="age" />
 <button type="submit">전송</button>
</form>
```
 - save는 상대경로인데(/로 시작 X) 폼 전송시 현재 URL이 속한 계층 경로 +save가 호출된다.
 - 현재 계층 경로는 /servlet-mvc/members/new-form 에서 /servlet-mvc/members가 된다.
 - 폼 전송 결과로 /servlet-mvc/members/save가 된다.
 - JSP 에서 <%= request.getAttribute("member")%> 로 모델에 저장한 member 객체를 꺼낼 수 있지만 ${member.id} 으로 덜복잡하게 꺼낼 수 있다.

## MVC패턴-한계
 - 포워드 중복(View로 이동하는 코드가 항상 중복 호출,메소드로 공통화해도 항상 직접 호출해야됨)
   ```java
    RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
    dispatcher.forward(request, response);
   ```
 - ViewPath에 중복
    ```java
    String viewPath = "/WEB-INF/views/new-form.jsp";
    ```
   - prefix: /WEB-INF/views/
   - suffix : .jsp
   - 경로, jsp에서 thymeleaf로 다른 템플릿 뷰로 변경시 전체 코드를 변경해야 한다.
 - 공통 처리가 어렵다.
   - 기능이 복잡할 수 록 컨트롤러에서 공통 처리할 부분이 많은데 공통 메서드로 뽑아도 항상 호출해야 되고 실수로 미호출 할경우도 있다. 또한 호출자체도 중복이다.
 - 프론트 컨트롤러(Front Controller)패턴을 도입
   - 컨트롤러를 호출 전에 먼저 공통 기능을 처리
   - 입구를 하나로 한다.
   - 스프링 MVC의 핵심 
