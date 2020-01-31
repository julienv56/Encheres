<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../header.jsp"%>

<div class="jumbotron">
    <div class="container text-center">
        <h3>Détail enchère</h3>
    </div>
</div>
<div class="jumbotron">
    <div class="container">
        <aside class="col-sm-7">
            <article class="card-body p-5">
                <h3 class="title mb-3">${article.getNomArticle()}</h3>
                <h3 class="title mb-3">${retrait.getArticle().getNomArticle()}</h3>

                <dl class="item-property">
                    <dt>Description</dt>
                    <dd><p>${retrait.getArticle().getDescription()}</p></dd>
                </dl>
                <dl class="param param-feature">
                    <dt>Categorie</dt>
                    <dd>${retrait.getArticle().getCategorie().getLibelle()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <dl class="param param-feature">
                    <dt>Meilleur offre</dt>
                    <dd>${retrait.getArticle().getPrixVente()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <dl class="param param-feature">
                    <dt>Mise à Prix</dt>
                    <dd>${retrait.getArticle().getMiseAPrix()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <hr>
                <dl class="param param-feature">
                    <dt>Fin de l'enchère</dt>
                    <dd>${retrait.getArticle().getDateFinEncheres()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <hr>
                <dl class="param param-feature">
                    <dt>Retrait</dt>
                    <dd>${retrait.getRue()}</dd>
                    <dd>${retrait.getCode_postal()} - ${retrait.getVille()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <dl class="param param-feature">
                    <dt>Vendeur</dt>
                    <dd>${retrait.getArticle().getUtilisateur().getPseudo()}</dd>
                </dl>  <!-- item-property-hor .// -->
                <hr>
                <form action="<%=request.getContextPath()%>/encheres" method="post">
                    <dl class="param param-inline">
                        <dt>Ma Proposition:</dt>
                        <dd>
                            <input class="form-control" type="number" name="proposition">
                        </dd>
                    </dl>  <!-- item-property .// -->
                    <button type="submit" class="btn btn-lg btn-primary text-uppercase">Enchérir</button>
                    <% if (request.getAttribute("error") != null) {%>
                    <div class="error">
                        <script> alert("<%=request.getAttribute("error")%>");
                        </script>
                    </div>
                    <%}%>
                </form>

            </article> <!-- card-body.// -->
        </aside> <!-- col.// -->
    </div>
</div>
</body>
</html>
