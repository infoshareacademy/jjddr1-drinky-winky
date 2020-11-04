<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">
    <#include "js-head.ftlh">

    <meta charset="utf-8">
    <title>Drinky-Winky WebApp</title>

</head>
<body>

<table style="margin-left: auto; margin-right: auto; width: 800px;">
    <tr>
        <td colspan="2" style="text-align:center;">
            <h2 class="text-primary">Drink: ${drink.getName()}</h2>
        </td>
    </tr>

    <tr>
        <td style="padding: 10px;width: 400px;">
            <h4>Kategoria: ${category.getName()} </h4>
            <h4>Rodzaj: ${drink.getDrinkType()} </h4>
            <h4>Szklanka: ${drink.getGlassType()} </h4>
            <h4>Data modyfikacji: ${drink.getModificationDate()} </h4>
            <h6>Testowo i kontrolnie pokazuje tutaj Id: ${drink.getId()} </h6>
        </td>
        <td style="padding: 10px;width:400px;">
            <img src="${drink.getImageUrl()}"  alt="Zdjecie drinka" style="width: 380px;" />
            <h4>Przepis: ${drink.getRecipe()} </h4>
            <h4>Skladniki:</h4>
            <#list ingredients>
                <ul>
                    <#items as ing>
                        <li>
                            <h4>${ing.getName()} - ${ing.getMeasure()}</h4>
                        </li>
                    </#items>
                </ul>
            </#list>
        </td>
    </tr>
</table>

<#include "contact.ftlh">
<#include "footer.ftlh">

<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
<script src="scripts/main.js"></script>

</body>
</html>
