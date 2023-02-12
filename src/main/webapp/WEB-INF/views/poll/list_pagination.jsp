<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous" />

<%@ include file= "header.jsp" %>
    <div class="text-primary display-6 text-center pt-5">회원 목록 보기</div>
    <hr>
    
      <div class="container ms-1 p-2 pb-3">
		<form action="/poll/form" method="get">
			<button class="btn btn-default btn-lg btn-success">Add New User</button>
		</form>
    <div class="row">
    <div class="col">
    <form action="/poll/formMulti" method="get">
			<button class="btn btn-default btn-lg btn-success">Add New User MultiType</button>
		</form>
    </div>
    <div class="col">
    <%-- 테스트 유저 추가 --%>
    <form action="/poll/addTestUser" method="get">
			<button class="btn btn-default btn-lg btn-secondary">Add Test User + 25</button>
		</form>
    </div>
    </div>

<%-- pagination / 추가자료:pagination.jsp git --%>
<nav aria-label="Page navigation example">
<c:set var="_pagination" value="${resultMap.paginations}" />
  <span>전체 회원수 : ${_pagination.totalCount}</span>
  <ul class="pagination">
    <li class="page-item">
      <a class="page-link" href="/poll/listPagination/${_pagination.previousPage}" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
        <span class="sr-only">Previous</span>
      </a>
    </li>
	<%-- for(int i=0; i>9; i++) --%>
	<c:forEach var="pageNum" begin="${_pagination.blockStart}" end="${_pagination.blockEnd}" varStatus="loop">
    <c:set var="color" value="" />
    <c:if test="${currentPage eq pageNum}">
        <c:set var="color" value="bg-secondary bg-opacity-25" />
    </c:if>
    <li class="page-item"><a class="page-link ${color}" href="/poll/listPagination/${pageNum}">${pageNum}</a></li>
	</c:forEach>
    <li class="page-item">
      <a class="page-link" href="/poll/listPagination/${_pagination.nextPage}" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
        <span class="sr-only">Next</span>
      </a>
    </li>
  </ul>
</nav>

      </div>
        <div class="container-fluid">
        <table class="table table-bordered table-primary table-hover text-center">
          <thead>
            <tr>
              <th>사용자고유번호</th>
              <th>이름</th>
              <th>아이디</th>
              <th>비밀번호</th>
              <th>전화번호</th>
              <th>생년월일</th>
              <th>이메일</th>
              <th>문자수신여부</th>
              <th>이메일수신여부</th>
              <th>회원정보수정</th>
              <th>회원삭제</th>
            </tr>
          </thead>
          <tbody>
		  		
		<c:forEach items="${resultMap.resultList}" var="resultData" varStatus="loop">
              <tr>
                <th>${resultData.USER_UID}</th>
                <td>${resultData.NAME}</td>
                <td>${resultData.ID}</td>
                <td>${resultData.PASSWORD}</td>
                <td>${resultData.PHONE_NUMBER}</td>
                <td>${resultData.BIRTHDAY}</td>
                <td>${resultData.EMAIL}</td>
                <td>${resultData.SMS_AD}</td>
                <td>${resultData.EMAIL_AD}</td>
                <td>
                <div class="container">
					<form action="/poll/edit/${resultData.USER_UID}" method="get">
					<button class="btn btn-primary">update</button>
					</form>
                </div>
                </td>
                <td>
                  <div class="container">
					<form action="/poll/delete/${resultData.USER_UID}" method="post">
					<button class="btn btn-danger">Delete</button>
					</form>
                  </div>
                </td>
                </tr>
		</c:forEach>
        </tbody>
      </table>
      </div>
    
    <%@ include file= "footer.jsp" %>