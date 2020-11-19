<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">

    <meta charset="utf-8">
    <title>Welcome </title>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>

</head>
<body>

<section class="gallery" id="gallery">
    <h2 class="section-title">${loggedUser} favourite drink list</h2>

    <div class="container">
        <ul class="social-links">
            <#if pageNumber??>
                <#list pageNumber>
                    <#items as page>
                        <li style="margin-right: 20px; margin-left: 20px;">
                            <form method="get" action="Favourite-list">
                                <input class="btn2" type="submit" name="page" value="${page}">
                            </form>
                        </li>
                    </#items>
                </#list>
            </#if>
        </ul>
    </div>

    <div class="gallery-wrapper">
        <#if drinkList??>
            <#list drinkList>
                <#items as drink>

                    <figure class="gallery-item" style="padding: 5px">
                        <img src=${drink.getImageUrl()} alt="image">
                        <a href="Drink-view?name=${drink.getName()}">
                            <figcaption>${drink.getName()}</figcaption>
                        </a>
                    </figure>

                </#items>
            </#list>
        </#if>
    </div>
</section>
<div style="float: none; width: 55%" >
    <button onclick="goBack()" class="btn2" style="float: right">Go Back</button>
</div>
</body>
</html>