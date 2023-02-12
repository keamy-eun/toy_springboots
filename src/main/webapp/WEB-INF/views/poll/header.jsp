<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link
      href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
      rel="stylesheet"
      integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
      crossorigin="anonymous"
    />
    <link rel="stylesheet" href="./css/commons.css" />
  </head>
  <body>
    <div class="container-fluid p-4">
      <div class="pb-2 d-flex justify-content-between">
        <nav class="navbar navbar-light">
          <a href="/poll" class="fs-2 navbar-brand"
            >이어폰 사용설문 및 통계시스템</a
          >
        </nav>
        <div class="d-flex justify-content-around">
        <div><a href="/Logout" class="" onclick="alert('로그아웃 되었습니다!');" > 로그아웃</a></div>
        </div>
      </div>
      <div class="fs-4 mt-4 mb-4">
        <nav class="nav d-flex justify-content-around">
          <a href="/Main" class="nav-link text-dark">HOME</a>
          <a href="/staticsServlet" class="nav-link text-dark">통계</a>
          <a href="/surveyServlet" class="nav-link text-dark">설문</a>
          <a href="/Login" class="nav-link text-dark">로그인</a>
          <a href="/SignUp" class="nav-link text-dark">회원가입</a>
          <a href="/poll/list" class="nav-link text-dark">관리자 페이지</a>
        </nav>
      </div>
    </div>

    <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
      crossorigin="anonymous"
    ></script>
  </body>
</html>
