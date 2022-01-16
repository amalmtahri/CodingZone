<%@ page import="com.coding.codingzone.model.Question" %>
<%@ page import="java.util.ArrayList" %><%--
<%--
  Created by IntelliJ IDEA.
  User: adm
  Date: 16/01/2022
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

</head>
<body>
<div class="container mt-sm-5 my-1">
    <div>
        <form action="nextQuestion" method="post">
            <%=
            request.getAttribute("question")
            %>
            <div class="d-flex align-items-center pt-3">
                <button class="btn btn-success" type="submit">Next</button>
            </div>
        </form>

    </div>
    <%//}%>

</div>
</body>
</html>
