<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="../header.jsp"%>
<form action="<%=request.getContextPath()%>/edit" method="post">
    <table id="table1" class="table">
        <tbody>
        <tr>
            <th scope="row">Pseudo</th>
            <td><input required="required" name="pseudoEdited" class="form-control" type="text"
                       value="${sessionScope.user.pseudo}"></td>
            <th scope="row">Nom</th>
            <td><input required="required" name="nomEdited" class="form-control" type="text"
                       value="${sessionScope.user.nom}"></td>
        </tr>
        <tr>
            <th scope="row">Prenom</th>
            <td><input required="required" name="prenomEdited" class="form-control" type="text"
                       value="${sessionScope.user.prenom}"></td>
            <th scope="row">Email</th>
            <td><input required="required" name="emailEdited" class="form-control" type="text"
                       value="${sessionScope.user.email}"></td>
        </tr>
        <tr>
            <th scope="row">Telephone</th>
            <td><input required="required" name="telephoneEdited" class="form-control" type="text"
                       value="${sessionScope.user.telephone}">
            </td>
            <th scope="row">Rue</th>
            <td><input required="required" name="rueEdited" class="form-control" type="text"
                       value="${sessionScope.user.rue}"></td>
        </tr>
        <tr>
            <th scope="row">Code Postal</th>
            <td><input required="required" name="codePostalEdited" class="form-control" type="text"
                       value="${sessionScope.user.code_postal}">
            </td>
            <th scope="row">Ville</th>
            <td><input required="required" name="villeEdited" class="form-control" type="text"
                       value="${sessionScope.user.ville}"></td>
        </tr>
        <tr>
            <th scope="row" id="actualPwd">Mot de passe actuel</th>
            <td><input required="required" name="password" class="form-control" type="password"></td>
            <c:if test="${!empty sessionScope.message}" var="erreur">
                <script>
                    alert('Mot de passe incorrect');
                    document.getElementById("actualPwd").style.backgroundColor = "red";
                    document.getElementById("actualPwd").style.color = "white";
                </script>
            </c:if>

            <th>Credit</th>
            <td>${sessionScope.user.credit}</td>
        </tr>
        <tr>
            <th scope="row">Nouveau mot de passe</th>
            <td><input required="required" name="newPasswordEdited" class="form-control" type="password"
                       id="newPassword"></td>
            <th scope="row">Confirmation</th>
            <td><input required="required" name="confirmNewPasswordEdited" class="form-control" type="password"
                       id="confirmPassword"></td>
            <script>
                var password = document.getElementById("newPassword")
                    , confirm_password = document.getElementById("confirmPassword");

                function validatePassword() {
                    if (password.value !== confirm_password.value) {
                        confirm_password.setCustomValidity("Le mot de de passe ne correspond pas");
                    } else {
                        confirm_password.setCustomValidity('');
                    }
                }

                password.onchange = validatePassword;
                confirm_password.onkeyup = validatePassword;
            </script>
        </tr>
        </tbody>
    </table>
    <div style="text-align: center">
        <button type="button" class="btn btn-primary" data-toggle="modal"
                data-target="#modalCenterSave">
            Enregistrer
        </button>
        <button type="button" class="btn btn-danger" data-toggle="modal"
                data-target="#modalCenterSupp">
            Supprimer profil
        </button>
    </div>
    <!-- Modal save -->
    <div class="modal fade" id="modalCenterSave">
        <div class="modal-dialog modal-dialog-centered" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title">Confirmation</h3>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    Etes-vous sur de vouloir enregistrer le profil ? <br>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">
                        Enregistrer
                    </button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                        Fermer
                    </button>
                </div>
            </div>
        </div>
    </div>

</form>
<!-- Modal supp -->
<div class="modal fade" id="modalCenterSupp">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h3 class="modal-title">Confirmation
                    suppression</h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Etes-vous sur de vouloir supprimer le profil ?
            </div>
            <div class="modal-footer">
                <form action="<%=request.getContextPath()%>/ServletProfil" method="post">
                    <button type="submit" class="btn btn-danger" href="/ServletProfil">
                        Supprimer
                    </button>
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">
                        Fermer
                    </button>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="../footer.jsp"%>