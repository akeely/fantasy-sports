<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<body>

<h1>Spring security Sample Home Page</h1>

<h3>Technical Information</h3>
<p>
Your principal object is....: <%= request.getUserPrincipal() %>
</p>
<p><a href="j_spring_security_logout">Logout</a>
</body>
</html>
