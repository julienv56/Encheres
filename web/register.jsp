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
    <title>Register</title>
</head>
<body>
<form class="form-group" action="<%=request.getContextPath()%>/register" method="post">
    Pseudo:<input type="text" name="pseudo"/><br/>
    Nom:<input type="text" name="nom"/><br/>
    prenom:<input type="text" name="prenom"/><br/>
    Email:<input type="text" name="email"/><br/>
    Téléphone:<input type="text" name="telephone"/><br/>
    Rue:<input type="text" name="rue"/><br/>
    Code postal:<input type="text" name="codePostal"/><br/>
    Ville:<input type="text" name="ville"/><br/>
    Mot de passe:<input type="password" name="MotDePasse"/><br/>
    Credit:<input type="number" name="credit"/><br/>
    Administrateur:<input type="checkbox" name="admin"/><br/>
    <br/>
    <input type="submit" value="Register"/>
</form>
</body>
</html>
