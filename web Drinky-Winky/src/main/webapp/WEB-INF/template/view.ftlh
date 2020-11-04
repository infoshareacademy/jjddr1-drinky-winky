<html>
<head>
    <title>View DRINK</title>
</head>
<body>

<#list names>
    <ul>
        <#items as name>
            <li>
                ${name.getName()}
                ${name.getModificationDate()}

                <#list ing>
                    <ul>
                        <#items as name>
                            <li>
                                ${name.getName()}
                        </#items>
                    </ul>
                </#list>


            </li>
        </#items>
    </ul>
</#list>

</body>
</html>