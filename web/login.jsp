<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="ISO-8859-1">
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>log in</title>
</head>
<body>
<form class="form-group" action="<%=request.getContextPath()%>/login" method="post">
    Pseudo:<input type="text" name="pseudo"/><br/>
    Mot de passe:<input type="password" name="MotDePasse"/><br/>
    <br/>
    <input type="submit" value="Se connecter"/>
</form>
</body>
</html>
