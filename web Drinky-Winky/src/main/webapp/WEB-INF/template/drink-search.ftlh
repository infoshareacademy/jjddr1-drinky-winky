<html>
<head>
    <title>View DRINK</title>
</head>
<body>
<form method="get" action="search-drink">

    <#list names>
        <ul>
            <#items as name>
                <li>
                    ${name.getName()}
                    ${name.getName()}
                    ${name.getName()}
                </li>
            </#items>
        </ul>
    </#list>

</body>
</html>