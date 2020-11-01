<!DOCTYPE html>
<html lang="pl">

<head>

    <#include "css.ftlh">
    <#include "js-head.ftlh">

    <meta charset="utf-8">
    <title>Drinky-Winky WebApp</title>

</head>
<body>

<div id="wrapper">

    <div class="container">
        <div class="center-block">
<#--            <div class="col-lg-4">-->
<#--                <img src="${book.cover!}" class="img-fluid" alt="Okładka">-->
<#--            </div>-->
            <div class="col-lg-8, text-left">
                <div class="text-center">
                    <h2 class="text-primary">Drink:</h2>
                    <h3 class="text-danger">${drink.getName()}</h3>
                </div>
                <br>
                <h4>Autor: ${drink.getName()} </h4>
                <h4>Epoka: ${drink.getName()} </h4>
                <h4>Wersja audio: ${drink.getName()}</h4>
                <h4>Rodzaj: ${drink.getName()}</h4>
                <h4>Typ literatury: ${drink.getName()}</h4>
            </div>
        </div>
    </div>
</div>


<#include "contact.ftlh">

<#include "footer.ftlh">

<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
<script src="scripts/main.js"></script>


</body>
</html>
