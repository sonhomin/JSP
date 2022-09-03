# JSP

<details>
<summary>Ch1</summary>
  
  ## 월드와이드웹(World Wide Web)   
  인터넷에서 운영되는 서비스   
  인터넷 = 네트워크망, 웹 = 서비스   
  인터넷상의 정보를 하이퍼텍스트 방식과 멀티미디어 환경에서 검색할 수 있게 해주는 정보 검색 시스템   
  *HTTP 프로토콜* 사용 HTML 문서를 연결하여 다양한 콘텐츠를 제공
  많은 사람들이 정보를 쉽게 공유하고 접근할수 있도록 하는것이 목적
  
  ## 클라이언트-서버 구조   
  * 클라이언트: 웹 서비스를 이용하는 사용자   
  * 서버: 웹 서비스를 제공하기 위한 서비스 공급자
  * 프런트엔드: 클라이언트 중심의 프로그래밍(HTML, CSS, 자바스크립트) 영역
  * 백엔드: 서버를 구성하며 서비스를 제공하기 위한 서버 쪽 프로그래밍(웹 서버 소프트웨어, 웹 프레임워크, 데이터베이스)영역   
  
  ## HTML
  웹 문서의 구조를 정의하고 콘텐츠를 표현하는 기본 마크업 언어   
  웹을 통해 콘텐츠를 제공하려면 HTML을 사용해야 함   
  HTML은 태그라고 하는 간단한 표기법으로 표현하고자 하는 정보에 의미를 부여함
  
  ## CSS(Cascading Style Sheet)
  HTML 문서에 레이아웃과 디자인을 포함한 *시각적 요소*를 정의하기 위한 규격   
  HTML은 콘텐츠의 내용과 구조(레이아웃)를 정의하고 CSS에서는 콘텐츠의 위치, 정렬, 글자 크기, 여백, 배경색상들을 정의함
  디자인을 적용할 HTML요소를 셀렉터(Selector)로 지정하고 원하는 디자인 속성을 부여하는 방식
  
  ## 자바스크립트(JavaScript)   
  HTML 문서에서 동적으로 변하는 콘텐츠를 표현하기 위해 이벤트를 처리를 하거나 서버와 연결하여 데이터를 가지고 오는 등의 역할을 하는 프로그램 언어   
  HTML 문서에서 이벤트를 서버 연결 없이 동적으로 처리할수 있는 기술
  대표적인 자바 스크립트 라이브러리(프레임워크) - 앵귤러 뷰 리액트
  
  ## 백엔드 중심 개발   
  전통적인 웹 개발 모델, 서버에서 모든것을 담당   
  자바/JSP   
  |장점|단점|   
  |:---:|:---:|  
  |서비스 연동에 필요한 다양한 서버 환경에 대응할수 있음|모바일 네트워크의 속도가 느리며 이용에 많은 비용을 지불해야 함|
  |검색 엔진 최적화에 유리함|서버에 화면 갱신을 요청할경우 모든 데이터가 다시 전송되야하므로 모바일 환경에는 부적함|
  |기술이 안정적이고 검증됨|REST API와 클라우드 인프라가 보편화 되면서 기존의 대규모 서버구축하는 모노폴리식 아키텍쳐보다 소규모 서버를 연동하는 MSA 방식이 확산|
  |기존에 개발된 시스템이 많고 레거시 시스템은 오랫동안 유지됨||
  
  ## 프런트엔드 중심 개발
  HTML만 받아오고 서버로부터 화면 구성에 필요한 데이터만 자바 스크립트로 받아와 화면을 조합해 보여줌 CSR(Client Side Rendering)이라고도함   
  |장점|단점|   
  |:---:|:---:|   
  |필요한 부분의 데이터만 갱신, 전체화면 받아올 필요 없음|데이터 제공을 위한 서버는 필요함|   
  |실시간 데이터 갱신 자유로움|데이터 제공 서버는 주로 REST API로 개발, 백엔드 작업이 당연히 존재함|   
  |SPA(Single Page App), PWA(Progressive Web App)등의 구현에 적용할 수 있음|콘텐츠가 검색 엔진에 노출될 수 있도록 SSR(Server Side Rendering)을 접목하기도 함|
  |React.js, Vue.js등 다양한 라이브러리/프레임워크를 사용할수 있음||   
  
</details>

<details>
<summary>Ch2</summary>
  
 ## 서블릿 컨테이너(Web Application Server, WAS)   
  이름과 같이 웹 애플리케이션을 구동하는 서버를 의미함   
  서버 컴퓨터가 WAS로 동작하려면 서블릿 컨테이너가 필요함   
  실제 서비스 시스템을 구축할 떄는 정적 콘텐츠 서비스를 위한 웹서버와 WAS를 병행해 운영하며 설정을 통해 상호 연동되는 구조를 가짐
  
 ## 배포   
  웹: 운영 서버로 소스코드 복사하고 WAS에 등록하는 과정   
  모바일 앱: 앱스토어 업로드     
  웹 애플리케이션: WAR형태로 패키징한 후 아파치 톰캣에 전달해 실행   
  
</details>

<details>
<summary>Ch3</summary>
  
  ## HTML
  클라이언트가 서버로부터 수신하는 데이터 구조   
  
  ## 하이퍼텍스트   
  다른정보와 연결된 텍스트를 의미
  
  ## 마크업 언어   
  텍스트에 의미를 부여하기 위해 태그를 사용하여 문서에 주석을 다는 표현 시스템   
  
  ## XML   
  HTML보다 범용적으로 사용할수 있는 마크업 언어
  
  ## 태그
  <>를 사용하여 나타냄   
  일반적으로 시작과 끝 2개의쌍, 종료태그는 /로 표현
  모든태그가 종료태그를 가지는건 아님
  대소문자 구분X, 추가적인 정보 부여는 속성 사용
  시작 종료 사이를 *태그 보디* 라고함
  
  ## 속성
  태그에 추가 정보를 제공하기 위해 사용함   
  사용할 수 있는 속성역시 정해져있음
  
  ## 시맨틱 태그
  특별한 의미를 가지는 태그, 문서 구조 정의하는데 주로 사용   
  ex. header footer 
  
  ## CSS   
  디자인 담당, 디자인만 바꾸거나 내용만 변경하기 용이
  선택자와 선언부로 구성 선언부는 {} 블록 사용 각속성 정의는 ;으로 끝남   
  ex.   
  |선택자|선언부|   
  |:---:|:---:|   
  |h1|{color: red; font-size = 15px;|
  
  ## CSS 적용법
  인라인 스타일 시트: HTML 태그에 CSS 속성정의   
  내장 스타일 시트: head부분에 CSS정의 부분을 포함   
  외장 스타일 시트: 별도의 CSS 파일 생성후 HTML문서에 링크로 포함
  
  ## 자바스크립트 
  동적으로 변경되는 부분을 담당 웹 브라우저에서 해석되는 인터프리터 언어
  
  ## 자바스크립트의 특징   
  동적, 타입명시 필요없는 인터프리터 언어   
  객체지향, 함수형 프로그래밍 모두 표현가능   
  HTML 내용, 속성, 스타일을 변경할 수 있음   
  이벤트를 처리하고 사용자와의 상호작용을 가능하게 함   
  서버와 실시간 통신 기능을 제공
  
  ## 문서 객체 모델 (DOM)
  자바스크립에서는 DOM을 통해 HTML 요소에 접근   
  DOM은 HTML 문서 구조 전체를 객체화한 것을 의미
  
</details>

<details>
<summary>Ch4</summary>

</details>

<details>
<summary>Ch5</summary>
  
  ## 서블릿   
  |장점|단점|   
  |:---:|:---:|   
  |자바를 기반으로 하여 자바 API를 모두 사용할수 있음|HTML 응답을 위해서는 출력문으로 문자열 결합을 사용해야함|
  |운영체제,하드웨어 영향을 받지않음|서블릿에서 HTML을 포함할 경우 화면 수정이 어려움|
  |다양한 오픈소스 라이브러리와 개발도구를 활용할 수 있음|HTML폼 Form의 데이터 처리가 불편함|
  ||기본적으로 단일 요청과 응답을 처리하는 구조로 다양한 경로의 URL 접근을 하나의 클래스에서 처리하기 어려움|   
  ## 실제 자바 웹 개발에서의 서블릿 조합   
  화면 구성을 위해 JSP와 같은 템플릿 엔진을 사용함   
  REST AOI 구현을 위해서는 JAX-RS를 사용함   
  복잡한 서비스 구현을 위해 프런트 컨트롤러 모델 등을 사용함   
  ## HttpServletRequest   
  HTTP 프로토콜의 request 정보를 서블릿에 전달하기 위한 목적으로 사용
  서블릿 컨테이너에서 생성 클라이언트 요청이 doGet(), doPost()로 전달 될떄 인자로 함께 전달   
  서블릿에서 클라이언트와 연결해 처리할 작업은 모두 HttpServletRequest를 통해야 함   
  
  ## 주요메서드
  |메서드|설명|   
  |:---:|:---:|   
  |getParameter(name)|name 속성으로 전달된 파라미터 값|   
  |getParameterValues(name)|동일한 name 속성으로 전달된 모든 파라미터값|   
  |getMethod()|GET,POST등의 HTTP메서드|   
  ## HttpServletResponse   
  서버에서 클라이언트로 전달하려는 목적을 위한 기능으로 구성   
  서블릿 컨테이너는 요청 클라이언트에 응답을 보내기 위한 HttpServletResponse 객체를 생성하여 서블릿에 전달   
  서블릿은 해당 객체를 이용하여 content type, 응답코드, 응답 메시지 등을 전송   
  |메서드|설명|   
  |:---:|:---:|   
  |sendRedirect(String location)|클라이언트에 리다이렉트 응답을 보낸후 특정 URL로 다시 요청하게 함|
  |getWriter()|클라이언트로 데이터를 보내기 위한 출력 스트림을 리턴| 
  ## web.xml에 서블릿 등록
  ```
  <servlet>
      <servlet-name>HelloWorld</servlet-name>                     //서블릿 이름
      <servlet-class>jwbook.servlet.HelloServlet</servlet-class> //서블릿 클래스 지정
  </servlet>
  
  <servlet-mapping>
    <servlet-name>HelloWorld</servlet-name>                     //서블릿 이름 메핑
    <url-pattern>/hello</url-pattern>                           //서블릿 요청 주소 매핌
  </servlet-mapping>
  ```
  ## 서블릿 자바 애너테이션 등록
  ```
  @WebServlet("/hello")
  ```
  ```
  @WebServlet(description = "Hello World Servlet", urlPatterns ="/hello")
  ```
  ## 서블릿 초기화: init()
  초기에 한번만 실행   
  해당 서블릿이 컨테이너 메모리에 있는지 확인후 없을때 메모리에 적제하며 호출   
  서블릿은 종료 Destroy되고 다시 시작되면 init() 메서드 호출   
  ## 요청/응답: service() 메서드   
  service() 메서드를 통해 각각 doGet()이나 doPost()로 분기됨   
  이떄 파라미터로 HttpServletRequest와 HttpServletResponse 클래스 타입인 request와 response 객체가 제공됨   
  ## 서블릿 종료: destroy()   
  컨테이너로부터 서블릿 종료 요청이 있을 떄 destroy() 메서드를 호출함  
  ## 페이지 이동   
  데이터를 포함하지 않는 경우
  ```
  response.sendRedirect("main.jsp");
  ```
  데이터를 포함하는 경우   
  request 속성으로 데이터를 넣은후 원하는 페이지로 포워딩   
  JSP
  ```
  <%
    request.setAttribute("member",m);
    pageContext.forwared("userInfo.jsp");
  %>
  ```   
  서블릿
  ```
  doGet(...){
    ...
    request.setAttribute("member",m);
    RequestDispatcher dispatcher = request.getRequestDispatcher("userInfo.jsp");
    dispatcher.forward(request,response);
  }
  ```
  
  
  

</details>

<details>
<summary>Ch6</summary>

  ## JSP의 특징
  HTML페이지에 자바 코드르 직접 사용함   
  서블릿 컨테이너에 의해 관리되는 내장 객체의 생명 주기를 이용하여 페이지 간 속성을 관리함   
  커스텀 태그 기술을 사용하여 코드를 태그화(action, JSTL등) 함   
  EL Expression Language을 통해 데이터를 표현함
  
  ## JSP 구성요소
  지시어   
  액션   
  템플릿 데이터   
  스크립트 요소   
  커스텀 태그   
  ## JSP가 서블릿으로 컴파일되고 실행되는 과정
  7페이지   
  ## JSP 장단점
  |장점|단점|   
  |:---:|:---:|   
  |HTML파일에 자바 기술을 거의 무한대로 사용할수 있으며 비교적 쉽게 프로그래밍 가능|화면 구성요소를 변경하면 JSP → 자바 → 클래스 → 서블릿 실행 과정을 거치므로개발 과정에서 사소한 UI 변경일지라도 매번 확인하는 데 시간이 소요됨|   
  |커스텀 태그 라이브러리등 확장 태그 구조를 사용할 수 있음|개발자와 디자이너 간 역할 분담에 제약이 있음|   
  |서블릿으로 변환되어 실행되므로 서블릿 기술의 장점을 모두 가짐|JSP 파일의 화면 디자인 확인에도 반드시 서블릿 컨테이너의 실행이 필요함|   
  |MVC패턴, 스프링 프레임워크 등 잘 설계된 구조를 적용할 수 있어 개발 생산성이 향상되고 성능이 보장됨||   
  |모든 개발이 서버에서 이루어지므로 개발의 집중화를 통한 효율이 오름||   
  ## JSP 지시어
  JSP 파일의 속성을 기술하는 요소   
  지시어는 크게 page, includem taglib로 나눌 수 있으며 각각 속성이 다름
  ```
  <%@ 지시어 속성="값" %>
  ```
  ## page 지시어
  JSP페이지를 컨테이너에서 처리(서블릿으로 변환)하는 데 필요한 각종 속성을 기술함
  ```
  <@ page languge="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*" errorPage="error.jsp"%>
  ```
  language: 현재 페이지의 스크립트 언어를 지정하는 속성   
  contentType: 현재 페이지의 파일 형식을 지정하는 속성(클라이언트 요청에 응답할 때 전달하는 HTTP 헤더 정보가 됨)   
  pageEncoding: JSP 파일을 컨테이너가 처리할 때 사용하는 캐릭터 인코딩을 지정하는 속성   
  import: JSP 파일 내에서 자바 코드(스크립트릿)를 직접 사용하는 경우 일반 자바 코드와 마찬가지로 클래스에 대한 패키지 import가 필요함   
  errorPage: 현재 JSP 요청 처리 중에 에러가 발생하는 경우 서버 에러를 클라이언트에 전달하지 않고 별도의 페이지에서 처리하기 위한 속성   
  ## include 지시어   
  다른 파일을 포함하기 위한 지시어   
  사용된 위치에 특정 파일(html, jsp)을 불러옴     
  ```
  <%@ include file="파일위치" %>
  ```
  ## taglib 지시어
  JSP의 태그 확장 메커니즘인 커스텀 태그를 활용하기 위한 지시어   
  ```
  <%@ taglib uri="태그라이브러리경로" prefix="태그 접두어" %>   
  <%@ taglib tagdir="태그라이브러리경로" prefix="태그 접두어" %>
  ```
  uri: 태그 라이브러리 위치로 태그를 정의하고 있는 .tld파일 경로를 나타냄   
  tagdir: 태그 파일로 태그를 구현한 경우 태그 파일 경로를 나타냄   
  prefix: 해당 태그를 구분해서 사용하기 위한 접두어   
  구현예시   
  ```  
  <%@ taglib tagdir="/WEB-INF/tags" prefix="m" %>
  ...
  <h2><m:printData /></h2>
  ```
  ## 템플릿 데이터   
  JSP의 화면 구성요소   
  시작 부분의 page 지시어를 제외하면 JSP 파일의 전반적인 구조는 HTML의 문서 구조를 따름. 따라서 일반적인 HTML 파일처럼 CSS, 자바스크립트도 사용할 수 있음   
  주의할 점) React, Vue와 같은 자바스크립트 요소는 프런트엔드 개발 기술로 JSP와 함꼐 사용하지 않음   ## 스크립트 요소   
  JSP는 HTML과 자바코드를 섞어 사용할 수 있는데, 이떄 사용되는 자바 코드를 의미함   
  자주 쓰이는 스크립트 요소: <%! %>, <%= %>, <% %>   
  ## <%! %>   
  선언 태그
  JSP가 서블릿 코드로 변환될 때 _ jspService( ) 메서드 안에 들어가게 되므로 JSP에서는 일반 자바 코드와 달리 멤버 변수나 메서드 선언은 기본적으로 불가능함   
  멤버 변수나 메서드 선언이 필요하다면 사용할 수는 있으나 권장하지 않음   
  ## <%= %>
  표현(Expression) 태그   
  웹 브라우저를 통해 클라이언트에 전달될(HTML 응답에 포함될) 자바 표현식을 포함   
  out.println( )의 인자로 적합한 모든 자바 코드가 가능함 사칙연산, 메서드 호출, 변숫값 출력 등에 사용됨   
  EL로 대체할 수 있음   
  ## <% %>
  스크립트릿(Scriptlet) 태그   
  모든 자바 코드의 사용이 가능함   
  서블릿 코드로 변환될 때 모든 HTML은 out.write( ) 형태로 변경됨 HTML과 스크립트릿을 중간에 섞어 사용하는 것도 가능함   
  MVC 패턴 적용과 JSTL + EL로 대체할 수 있음  
    
</details>

<details>
<summary>예문</summary>

 ## 쿠키와 세션 차이
 쿠키는 서버에서 생성, 클라이언트에서 저장 사용   
 세션은 서버 쪽에 생성되는 공간으로 내부적으로는 세션 아이디를 통해 참조됨   
 ## 코드완성1
 ```
  <script>
		function addItem(){
			let todo = document.getElementById("item");
			let list = document.getElementById("todolist");
			let listitem = document.createElement("li");
			listitem.className = "d-flex list-group-item list-group-item-action list-group-item-warnig";
			let xbtn = document.createElement("button");
			xbtn.className = "btn-close ms-auto";
			
			xbtn.onclick =function(e){
				let pnode = e.target.parentNode;
				list.removeChild(pnode);
			}
			
			listitem.innerText = todo.value;
			listitem.appendChild(xbtn);
			list.appendChild(listitem);
			todo.value = "";
			todo.focus();
		}
	</script>
  ```
  ``` 
  <button type="button" class="btn btn-primary" onclick="???">할일 추가</button>
  ```
  addItem()   
  ## 코드완성2
  ```
  @WebServlet("/calc")
  ```
  ```
  <form method="post" ???>
  ```
  action="/jwbook/calc"   
   ## 서블릿 등록
   ```   
   <servlet>
      <servlet-name>calculate</servlet-name>
      <servlet-class>ch05.CalcServlet</servlet-class>
   </servlet>

   <servlet-mapping>
      <servlet-name>calculate</servlet-name>
      <url-pattern>/calc</url-pattern>
   </servlet-mapping>
  ```
  ## tld
  ```
  <%@ taglib uri="/WEB-INF/tld/ItemTag.tld" prefix="mytag" %> 
  ```
  ## tag
  ```
  <%@ taglib tagdir="/WEB-INF/tags" prefix="mytag" %>
  ```
</details>
<details>
<summary>Ch7</summary>   
	
## 액션태그     	
jsp접두어   	
|액션 태그|설명|  
|:---:|:---:|
|jsp:forward|request와 response객체를 포함해 다른 페이지로 포워드|
|jsp:include|다른 페이지의 실행 결과를 포함시킴|
|jsp:useBean|자바 빈즈 객체를 생성하거나 불러옴|
|jsp:setProperty|자바 빈즈 객체의 속성(멤버변수)에 값을 할당함|
|jsp:getProperty|자바 빈즈 객체의 속성값을 출력함|
|jsp:param|include, forward 액션 사용시 파라미터 값을 수정하거나 추가함|

## 자바 빈 클래스   
* 인자가 없는 생성자(기본 생성자)로 수성된다   
* 파일 혹은 네트워크를 통해 객체를 주고받을수 있는 직렬화 구조가 가능하다.
* getter, setter 메서드를 통해 멤버 변수(속성)에 접근한다.   
 EX.Member 클래스 자바 빈 구조   
	
```
class Member{				//클래스 선언   
	private int id;   
	private int name;   
	private int email;   
	...   
	public void setId(int id){	// setter 메서드 선언   
		this.id = id;   
	}   
	public int getId(){		// getter 메서드 선언   
		return id;   
	}   
	...   
}   
```
## useBean 액션
	<jsp:useBean od="instanceName" scope="page | request | session | application" 
		class ="packageName.className" type="packageName.className"
		beanName="packageName.className">
	</jsp:useBean>
1. useBean을 이용해 만든 객체의 범위를 지정하는 속성인 scope에 주어진 id의 객체가 있는지 확인한다.   
2. 객체가 없다면 새로 객체를 생성하고 해당 scope에 저장한다   
* id: 특정 scope에 저장하거나 가져올때 사용하는 이름   
* scope: 해당 클래스 타입의 객체를 저장하거나 가져오는 범위로 내장객체의 일부   
* class: 생성하거나 참조하려는 객체의 클래스명이며 반드시 패키지명까지 명시. 추상클래스, 인터페이스는 사용불가   
* type: 특정 타입의 클래스를 명시할 때 사용. 추상 클래스나 인터페이스, 일반 클래스가 될수 있으며 class 속성의 클래스에서 상속 혹은 구현이 이루어져야 한다.   
* beanName: type 과 beanName 사용을 통해 class 속성을 대체할 수 있다.   
## useBean 활용   
HTML 폼에서 입력한 값을 자바 객체로 연동할 때 useBean을 주로 활용   
ex.회원가입시 아이디, 이름 등등 정보들을 입력하는경우 Member 객체에 넣고 이를 저장하기 위한 메서드 호출에 인자로 전달
```
<jsp:useBean id="m" class="com.my.Member" />
<jsp:setProperty name="m" property="*" />
<%
   MemberDAO dao = new MemberDAO();
   dao.insertDB(m);
%>
```   
* page scope로 새로운 Member 클래스 인스턴스를 생성한 후 m이라는 이름으로 속성에 저장한다   
* setProperty는 HTML <form> 태그의 name 속성값을 해당 객체의 setter 메서드를 이용해 저장한다   
* property 속성에는 멤버 변수명 혹은 *을 사용해 전체 변수를 한번에 지정할수 있다
## include, forward 액션   
* include 액션: include된 파일을 각각 호출해 처리된 결과만 포함해 보여줌   
```
// main.jsp	
<jsp:include page="header.jsp">
 <jsp:param name="title" value="My Homepage" />
</jsp:include>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// header.jsp
<h2><%= request.getParameter("title") %> </h2>
```
* forward 액션: 서버 내부적으로 새로운 페이지로 이동하고 그 페이지의 내용을 클라이언트에게 응답으로 전달한다. 리디렉션과 기능적으로 유사 최초 request를 유지하거나 속성값을 저장한 경우 이를 유지하며 이동하기위해 사용.   
```
// main.jsp	
<jsp:forward page="result.jsp">
 <jsp:param name="title" value="My Homepage" />
</jsp:forward>
~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
// result.jsp
<h2><%= request.getParameter("title") %> </h2>
```
## EL태그 	
* scope object에 저장된 자바 빈 객체를 손쉽게 접근하고 사용할수 있게 해준다
* 단순한 출력 외에도 사칙연산, 비교연산, 논리연산, 3항 연산등을 지원
* null 객체를 참조할때 에러가 발생하지 않는다
```
${저장이름.변수명}
```
ex. 멤버 클래스 접근
```
<h2> 멤버정보</h2>
이름: {m.name}
```
이미 sessuin에 'm'이라는 이름으로 저장된 Member 객체가 있으므로 해당 객체를 사용하여 접근   
EL을 사용하지 않을 경우 표현식이나 액션으로 출력가능
```
이름: <%= m.name %> <br> // 표현식 사용
~~~
이름: <jsp:getProperty name="m" property="name" /> <br>
```
## JSTL
자바 코드 블록을 사용하지않고 HTML 형식을 유지하면서 조건문, 반복문, 간단한 연산 등 기능을 손쉽게 사용할수 있도록 지원하기 위해 만들어진 표준 커스텀 태그 라이브러리
```
<c:forEach [var="참조 객체"] [varStatus="상태 정보 변수"] begin="시작" end="종료"
[step="반복 단계 증가 값, 1이 기본"]>
반복 출력되는 부분
<c/:forEach>
~~~
//멤버예제
<c:forEach var="m" items="${members}" varStatus="status" begin="0" end="5">
index: ${status.index} /
count: ${status.count} <BR>
name: ${status.name} <BR>
email: ${status.email} <BR>
<HR>
<c/:forEach>
```   
## Maven
pom.xml 파일에 빌드 설정을 작성   
```
<dependencies>
	<dependency>
		<groupId>javax.servlet</groupId>
		<artifactId>jstl</artifactId>
		<version>1.2</version>
	</dependency>
</dependencies>
```
</details>
<details>
<summary>Ch8</summary>
	
## MVC 패턴
* 모델
데이터를 처리하는 영역. 데이터 베이스와 연동을 위한 DAO, DO, 엔티티 클래스 드으로 구성   
뷰나 컨트롤러에 독립적인 구조   
* 뷰
화면 구성을 담당하는 영역. JSP, html, css 등   
* 컨트롤러
MVC 패턴의 핵심 모든 사용자 요천의 중심에 위치.   
요청 -> 컨트롤러 -> 뷰   
요청에 따라 모델을 통해 데이터베이스와 연동하여 데이터를 처리하고 뷰에 전달   
뷰에 전달하기 위해 데이터가 들어있는 DO 혹은 List<DO> 형태의 객체를 request에 저장한후 포워딩   
JSP, 서브릿으로 구형 가능, 향후 확장과 스프링 프레임워크로의 확장등을 고려하면 서블릿 기반 구혀을 추천

# ch10에서의 MVC    
* 모델: News.java, NewsDAO.java   
* 컨트롤러: NewsController.java   
* 뷰: newsList.jsp, newsView.jsp   
## 컨트롤러를 구성하는 세가지 방법
* 사용자 요청마다 컨트롤러를 만드는것 
* 하나의 컨트롤러 안에서 여러 요청 단위를 구분해 처리
* 프런트 컨트롤러를 따로 두어 모든 요청을 하나의 컨트롤러로 모은 다음 요청에 따라 구현된 컨트롤러 호출
</details>
