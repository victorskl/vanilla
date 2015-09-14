<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<html>
<body>

<h1>Add a car</h1>

<sf:form method="POST" modelAttribute="car">
    <p>
        Name:
        <input type="text" name="name"/>
        <sf:errors path="name" cssclass="error"></sf:errors>
    </p>

    <p>
        Price:
        <input type="text" name="price"/>
        <sf:errors path="price" cssclass="error"></sf:errors>
    </p>

    <input type="submit"/>
</sf:form>

</body>
</html>