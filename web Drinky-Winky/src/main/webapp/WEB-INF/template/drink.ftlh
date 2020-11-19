<!DOCTYPE html>
<html>
<head>

    <link href="/styles/style.css" rel="stylesheet" type="text/css">


    <title> Drink </title>

</head>
<body>

<h1> Drinki po name </h1>

<#list drinks>
    <div>
        <#items as drink>
            <li>
                <a>${drink.getName()}</a>
            </li>
        </#items>
    </div>
</#list>

</body>
</html>