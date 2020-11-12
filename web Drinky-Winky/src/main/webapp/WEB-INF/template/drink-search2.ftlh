<html>
<body>

<form method="get" action="search-drink2">
    <section class="quotes" id="quotes">
        <div class="container">
            <h2 class="section-title">RECIPES</h2>
            <div class="quotes-wrapper">


                <article class="quote">
                    <blockquote>
                        <div class="names">
                            <h1> Drinks found by name.</h1>
                            <h2> Results found: ${result1}</h2>
                            <#if names??>
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
                            </#if>
                        </div>


                    </blockquote>
                </article>


                <article class="quote">
                    <blockquote>
                        <div class="categories">
                            <h1> Drinks found by category</h1>
                            <h2> Results found: ${result2}</h2>

                            <#if categories??>
                                <#list categories>
                                    <ul>
                                        <#items as category>
                                            <li>
                                                <figure class="gallery-item" style="padding: 5px">
                                                    <img src=${category.getImageUrl()} alt="image"
                                                         style="width: 200px;">
                                                    <a href="http://localhost:8080/Drink-view?name=${category.getName()}">
                                                        <figcaption>${category.getName()}</figcaption>
                                                    </a>
                                                </figure>
                                            </li>
                                        </#items>
                                    </ul>
                                </#list>
                            </#if>
                        </div>

                    </blockquote>
                </article>

                <article class="quote">
                    <blockquote>
                        <div class="types">
                            <h1> Drinks found by type</h1>
                            <h2> Results found:${result5} </h2>

                            <#if types??>
                                <#list types>
                                    <ul>
                                        <#items as type>
                                            <li>
                                                <figure class="gallery-item" style="padding: 5px">
                                                    <img src=${type.getImageUrl()} alt="image" style="width: 200px;">
                                                    <a href="http://localhost:8080/Drink-view?name=${type.getName()}">
                                                        <figcaption>${type.getName()}</figcaption>
                                                    </a>
                                                </figure>
                                            </li>
                                        </#items>
                                    </ul>
                                </#list>
                            </#if>
                        </div>
                    </blockquote>
                </article>

                <article class="quote">
                    <blockquote>
                        <div class="ingredients">
                            <h1> Drinks containing the specified ingredient</h1>
                            <h2> Results found: ${result4}</h2>

                            <#if ingredients??>
                                <#list ingredients>
                                    <ul>
                                        <#items as ingredient>
                                            <li>
                                                <figure class="gallery-item" style="padding: 5px">
                                                    <img src=${ingredient.getImageUrl()} alt="image"
                                                         style="width: 200px;">
                                                    <a href="http://localhost:8080/Drink-view?name=${ingredient.getName()}">
                                                        <figcaption>${ingredient.getName()}</figcaption>
                                                    </a>
                                                </figure>
                                            </li>
                                        </#items>
                                    </ul>
                                </#list>
                            </#if>
                        </div>
                    </blockquote>
                </article>

                <article class="quote">
                    <blockquote>
                        <div class="glasstypes">

                            <h1> Drinks found by type of glass</h1>
                            <h2> Results found: ${result3}</h2>

                            <#if glassTypes??>
                                <#list glassTypes>
                                    <ul>
                                        <#items as glassType>
                                            <li>
                                                <figure class="gallery-item" style="padding: 5px">
                                                    <img src=${glassType.getImageUrl()} alt="image"
                                                         style="width: 200px;">
                                                    <a href="http://localhost:8080/Drink-view?name=${glassType.getName()}">
                                                        <figcaption>${glassType.getName()}</figcaption>
                                                    </a>
                                                </figure>
                                            </li>
                                        </#items>
                                    </ul>
                                </#list>
                            </#if>
                        </div>
                    </blockquote>
                </article>

            </div>
        </div>
    </section>
</form>


<#include "footer.ftlh">


</body>
</html>