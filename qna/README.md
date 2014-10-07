소스 코드의 호출 순서 및 흐름
1. Client Browser에서 http://localhost를 8080포트로 호출한다.
2. 컨테이너가 webapp/WEB_INF/web.xml을 읽는다.
3. web.xml에 ServletContextLoader 로 ServletContext가 init 되는 시점에서 생성되고 contextInitialized 메소드로 ServletContext에 Url과 Controller Map 정보를 저장한다  
4. ServletContextListener로 Context 초기화되는 시점에 DB를 execute한다.
5. index.jsp를 호출하게 되면 리다이렉션으로 list.next를 호출하게 한다.
6. 서블릿에서 Map에 미리 저장된 Url정보로 해당 콘트롤러의 execute 메소드를 실행한다. 