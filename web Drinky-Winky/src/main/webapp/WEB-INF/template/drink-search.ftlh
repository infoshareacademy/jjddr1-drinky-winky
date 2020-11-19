<html>

<head>
    <meta name="description" content="drink-search"/>
    <link rel="stylesheet" href="styles/drink-search.css" type="text/css"/>
    <link rel="drink-search" href="//cdnjs.cloudflare.com/ajax/libs/normalize/2.0.1/normalize.css">
    <link href='https://fonts.googleapis.com/css?family=PT+Sans' rel='stylesheet' type='text/css'>
    <title>Drink Search</title>
    <meta charset=utf-8>

</head>

<body>
<center>
<form action="search-drink" method="get"; style="">
    <input pattern=".{3,}" required title="3 characters minimum" type="text" name="drinkSearch" id="drinkSearchPost"
           placeholder="What would you like to drink?">
    <button type="submit">Search</button>
</form>
</center>
<div class="tabbed">
    <input type="radio" name="tabs" id="tab-nav-1" checked>
    <label for="tab-nav-1">Search by name</label>
    <input type="radio" name="tabs" id="tab-nav-2">
    <label for="tab-nav-2">Search by category</label>
    <input type="radio" name="tabs" id="tab-nav-3">
    <label for="tab-nav-3">Search by type</label>
    <input type="radio" name="tabs" id="tab-nav-4">
    <label for="tab-nav-4">Search by ingredient</label>
    <input type="radio" name="tabs" id="tab-nav-5" checked>
    <label for="tab-nav-5">Search by glass type</label>
    <div class="tabs">
        <div>
            <div>
                <h1 style="marker-mid: none"> Drinks found by name </h1>
                <h2> Results found: ${result1}</h2>
            </div>
            <div>
                <#if names??>
                    <#list names>
                        <#items as name>
                            <div class="szereg-4">
                            <figure style="padding: 5px">
                                <img src=${name.getImageUrl()} alt="image" style="width: 200px;">
                                <a href="Drink-view?name=${name.getName()}">
                                    <figcaption>${name.getName()}</figcaption>
                                </a>
                            </figure>
                            </div>
                        </#items>
                    </#list>
                </#if>
            </div>
        </div>

        <div>

            <div>
                <h1> Find by type</h1>
                <h2> Results found: ${result2}</h2>
            </div>
            <#if categories??>
                <#list categories>
                    <ul>
                        <#items as category>
                            <li>
                                <figure>
                                    <img src=${category.getImageUrl()} alt="image"
                                         style="width: 200px;">
                                    <a href="Drink-view?name=${category.getName()}">
                                        <figcaption>${category.getName()}</figcaption>
                                    </a>
                                </figure>
                            </li>
                        </#items>
                    </ul>
                </#list>
            </#if>


        </div>
        <div>
            <div class="types">

                <h1> Drinks found by type </h1>

                <h2> Results found:${result5} </h2>

                <#if types??>
                    <#list types>
                        <ul>
                            <#items as type>
                                <li>
                                    <figure>
                                        <img src=${type.getImageUrl()} alt="image" style="width: 200px;">
                                        <a href="Drink-view?name=${type.getName()}">
                                            <figcaption>${type.getName()}</figcaption>
                                        </a>
                                    </figure>
                                </li>
                            </#items>
                        </ul>
                    </#list>
                </#if>
            </div>
        </div>
        <div>
            <div class="ingredients">

                <h1> Drinks containing the specified ingredient </h1>

                <h2> Results found: ${result4}</h2>

                <#if ingredients??>
                    <#list ingredients>
                        <ul>
                            <#items as ingredient>
                                <li>
                                    <figure>
                                        <img src=${ingredient.getImageUrl()} alt="image"
                                             style="width: 200px;">
                                        <a href="Drink-view?name=${ingredient.getName()}">
                                            <figcaption>${ingredient.getName()}</figcaption>
                                        </a>
                                    </figure>
                                </li>
                            </#items>
                        </ul>
                    </#list>
                </#if>
            </div>
        </div>
        <div>
            <div class="glasstypes">
                <h1> Drinks found by type of glass</h1>
                <h2> Results found: ${result3}</h2>

                <#if glassTypes??>
                    <#list glassTypes>
                        <ul>
                            <#items as glassType>
                                <li>
                                    <figure>
                                        <img src=${glassType.getImageUrl()} alt="image"
                                             style="width: 200px;">
                                        <a href="Drink-view?name=${glassType.getName()}">
                                            <figcaption>${glassType.getName()}</figcaption>
                                        </a>
                                    </figure>
                                </li>
                            </#items>
                        </ul>
                    </#list>
                </#if>
            </div>
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/prefixfree/1.0.6/prefixfree.min.js"></script>
</body>


</html>