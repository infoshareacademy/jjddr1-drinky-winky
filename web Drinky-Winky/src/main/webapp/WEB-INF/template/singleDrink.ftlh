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
            <div class="col-lg-8, text-left">
                <div class="text-center">
                    <h2 class="text-primary">Drink:</h2>
                    <h3 class="text-danger">${drink.getName()}</h3>
                </div>
                <h6>Id: ${drink.getId()} </h6>
                <br>
<#--                <h4>Kategoria: ${drink.getCategory()} </h4>-->
                <h4>Rodzaj: ${drink.getDrinkType()} </h4>
                <h4>Szklanka: ${drink.getGlassType()} </h4>
                <h4>Przepis: ${drink.getRecipe()} </h4>
                <h4>Data modyfikacji: ${drink.getModificationDate()} </h4>
                <img src="${drink.getImageUrl()}" alt="Zdjecie drinka"/>
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
