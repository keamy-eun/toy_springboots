<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
  </head>
  <body>
    <%@ include file= "header.jsp" %>

    <c:choose>
      <c:when test="${empty resultMap}">
        <c:set var="form_action" value="insert" />
        <c:set var="read" value="" />
        <div class="text-primary display-6 text-center pt-5">신규 회원 설정</div>
      </c:when >
      <c:otherwise >
        <c:set var="form_action" value="update" />
        <c:set var="read" value="readonly" />
        <div class="text-primary display-6 text-center pt-5">회원 정보 수정</div>
      </c:otherwise >
    </c:choose>

    <hr>
      <div class="container-fluid">
      <table class="table table-bordered table-primary table-hover">
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
            <th></th>
          </tr>
        </thead>
            <form action="/poll/${form_action}" method="post">
            <td>
                <div>
                <input type="text" class="form-control" name="USER_UID" value="${resultMap.USER_UID}" 
                placeholder="${resultMap.USER_UID}" ${read} />
                </div>
            </td>
            <td>
                <div>
                <input type="text" class="form-control" name="NAME" value="${resultMap.NAME}"/>
                </div>
            </td>
            <td>
                <div>
                <input type="text" class="form-control" name="ID" value="${resultMap.ID}"  />
                </div>
            </td>
            <td>
                <div>
                <input type="text" class="form-control" name="PASSWORD" value="${resultMap.PASSWORD}" />
                </div>
            </td>
            <td>
                <div>
                <input type="text" class="form-control" name="PHONE_NUMBER" value="${resultMap.PHONE_NUMBER}" />
                </div>
            </td>
            <td>
                <div>
                <input type="text" class="form-control" name="BIRTHDAY" value="${resultMap.BIRTHDAY}"  />
                </div>
            </td>
            <td>
                <div>
                <input type="text" class="form-control" name="EMAIL" value="${resultMap.EMAIL}" />
                </div>
            </td>
            <td>
                <div class="form-check">
                <input type="checkbox" class="form-check-input" name="SMS_AD"
                ${resultMap.SMS_AD == true ? 'checked': ''} />
                </div>
            </td>
            <td>
                <div class="form-check">
                <input type="checkbox" class="form-check-input" name="EMAIL_AD"
                ${resultMap.EMAIL_AD == true ? 'checked': ''} />
                </div>
            </td>
            <td>
                <button class="btn btn-dark container-fluid">${form_action}</button>
            </td>
          </form>
          </tbody>
        </table>
        <div class="container d-flex justify-content-end align-items-end">
          <a href="/poll/list/1" class="btn btn-primary" style="text-decoration:none">Prev</a></button></td>
        </div>
        <%@ include file= "footer.jsp" %>
  </body>
</html>
