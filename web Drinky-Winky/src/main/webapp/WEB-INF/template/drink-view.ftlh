<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">

    <meta charset="utf-8">
    <title>${drink.getName()}</title>

</head>
<body>

<div>
    ${drink.getName()}<br/>
    ${drink.getRecipe()}<br/>
    ${drink.getDrinkType()}<br/>
    ${drink.getGlassType()}<br/>
    ${drink.getModificationDate()}<br/>
    ${drink.getCategory().getName()}<br/>
</div>

<div>
    <figure class="gallery-item" style="padding: 5px">
        <img src="${drink.getImageUrl()}" alt="image"><br/>
        <figcaption>${drink.getName()}</figcaption>
    </figure>
</div>

<div>
    <#list ingredients>
        <ul>
            <#items as ingredient>
                <li>
                    ${ingredient.getName()}
                    ${ingredient.getMeasure()}
                </li>
            </#items>
        </ul>
    </#list>
</div>

<form action="Add-favourite" method="get">
<div class="upload-btn-wrapper">
    <a href="Add-favourite?name=${drink.getName()}"> DODAJ DO ULUBIONYCH  ${favourite}</a>
<#--    <input class="btn2" type="submit" name="save" value="save"/><br/><br/>-->
</div>
</form>

</body>
</html>