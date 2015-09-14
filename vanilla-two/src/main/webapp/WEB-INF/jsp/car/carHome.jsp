<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Car Home</title>
<body>

<h1>Cars</h1>

<c:forEach items="${carList}" var="car">
    <p>
            ${car.name}: $${car.price}
    </p>
</c:forEach>

<br/>
<br/>
<hr/>
<br/>

<fieldset>
    <legend>debug</legend>

    <ul>
        <li>javax.servlet.forward.servlet_path: ${requestScope['javax.servlet.forward.servlet_path']}</li>
        <li>javax.servlet.forward.request_uri:  ${requestScope['javax.servlet.forward.request_uri']}</li>
        <li>pageContext.request.servletPath:  ${pageContext.request.servletPath}</li>
    </ul>

</fieldset>

</body>
</html>