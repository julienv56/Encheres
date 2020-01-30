<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="entete.jsp" %>
<form class="form-group" action="<%=request.getContextPath()%>/register" method="post">
    Pseudo:<input required="required" type="text" name="pseudo"/><br/>
    Nom:<input required="required" type="text" name="nom"/><br/>
    prenom:<input required="required" type="text" name="prenom"/><br/>
    Email:<input required="required" type="text" name="email"/><br/>
    Téléphone:<input required="required" type="text" name="telephone"/><br/>
    Rue:<input required="required" type="text" name="rue"/><br/>
    Code postal:<input required="required" type="text" name="codePostal"/><br/>
    Ville:<input required="required" type="text" name="ville"/><br/>
    Mot de passe:<input required="required" type="password" name="MotDePasse"/><br/>
    <input type="checkbox" name="admin" hidden/><br/>
    <input type="number" name="credit" value="0" hidden/><br/>
    <br/>
    <input type="submit" value="Register"/>
</form>
<%@include file="footer.jsp" %>