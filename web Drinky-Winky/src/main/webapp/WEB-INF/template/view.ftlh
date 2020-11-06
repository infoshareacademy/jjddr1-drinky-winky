<html>
<head>
    <title>View DRINK</title>
</head>
<body>

<h3>Test of getRequestDrinkList method</h3>
<#list boundedList>
    <ul>
        <#items as drink>
        <li>
            ${drink.getName()}
            </#items>
    </ul>
</#list>

<h3>All drinks from DB</h3>
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