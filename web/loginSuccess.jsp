<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta http-equiv="refresh" content="3;/Encheres"/>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script
            src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>login success</title>
    <style>
        @import url(https://fonts.googleapis.com/css?family=Roboto:300);

        html {
            height: 90%;
        }

        body {
            background: #3F485B;
            display: flex;
            align-items: center;
            height: 90%;
        }

        .back {
            margin: 1em auto;
            font-family: "Roboto";
        }

        .back span {
            font-size: 3em;
            color: #F2C640;
            background: #262B37;
            display: table-cell;
            box-shadow: inset 0 0 5px rgba(0, 0, 0, 0.3), 0 5px 0 #ccc;
            padding: 0 15px;
            line-height: 100px;
            animation: jumb 2s infinite;
        }

        @keyframes jumb {
            0% {
                transform: translateY(0px)
            }
            50% {
                transform: translateY(-30px);
                box-shadow: 0 15px 0 rgb(242, 198, 64);
            }
            100% {
                transform: translateY(0px)
            }
        }

        .back span:nth-child(1) {
            animation-delay: 0s;
        }

        .back span:nth-child(2) {
            animation-delay: .1s;
        }

        .back span:nth-child(3) {
            animation-delay: .2s;
        }

        .back span:nth-child(4) {
            animation-delay: .3s;
        }

        .back span:nth-child(5) {
            animation-delay: .4s;
        }

        .back span:nth-child(6) {
            animation-delay: .5s;
        }

        .back span:nth-child(7) {
            animation-delay: .6s;
        }
    </style>
</head>
<body>
<c:if test="${!empty sessionScope.user}">
    <span class="back">
        <span>L</span>
        <span>o</span>
        <span>a</span>
        <span>d</span>
        <span>i</span>
        <span>n</span>
        <span>g</span>
        </span>
</c:if>
<br>
</body>
</html>
