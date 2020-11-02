<!DOCTYPE html>

<html>
<head>

</head>
<body>
<h1>Category list</h1>

<#list categories>
    <ul>
        <#items as category>
            <li>
                ${category.getName()}
            </li>
        </#items>
    </ul>
</#list>

</body>
</html>