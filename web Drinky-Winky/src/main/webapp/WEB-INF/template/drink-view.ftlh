<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">

    <meta charset="utf-8">
    <title>${drink.getName()}</title>

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