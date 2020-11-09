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

                    <img src="${name.getImageUrl()}"  alt="Zdjecie drinka" style="width: 200px;" />
                </li>
            </#items>
        </ul>
    </#list>

</body>
</html>