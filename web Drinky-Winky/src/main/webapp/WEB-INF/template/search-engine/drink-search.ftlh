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
                    <figure class="gallery-item" style="padding: 5px">
                        <img src=${name.getImageUrl()} alt="image" style="width: 200px;">
                        <a href="http://localhost:8080/Drink-view?name=${name.getName()}">
                            <figcaption>${name.getName()}</figcaption>
                        </a>
                    </figure>
                </li>
            </#items>
        </ul>
    </#list>


</body>
</html>