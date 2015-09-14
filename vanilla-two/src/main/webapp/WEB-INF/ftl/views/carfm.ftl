<html>
<head><title>FreeMarker</title>
<body>

<div id="header">
    <h2>FreeMarker Spring MVC Hello World</h2>
</div>

<table border="1">
    <tr>
        <th>Name</th>
        <th>Price</th>
    </tr>

<#list model["carList"] as c>
    <tr>
        <td>${c.name}</td>
        <td>${c.price}</td>
    </tr>
</#list>

</table>

</body>
</html>