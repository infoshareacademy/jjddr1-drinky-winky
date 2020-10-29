<!DOCTYPE html>
<html>
<head>
    <title>Welcome User</title>
</head>
<body>
<#list drinks>
    <#items as drinks>
        <p> ${drinks.name}</p>

    </#items>
</#list>
<#list categories>All categories
    <#items as categories>
        <p>${categories.name}</p>
    </#items>
</#list>
All checked recipies and ingredients
<#list checkedCategoriesAndIngredients>
    <#items as checkedCategoriesAndIngredients>
        <p>${checkedCategoriesAndIngredients}</p>
    </#items>
</#list>
</body>
</html>