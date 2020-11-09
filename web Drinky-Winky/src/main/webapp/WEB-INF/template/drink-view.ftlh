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

</body>
</html>