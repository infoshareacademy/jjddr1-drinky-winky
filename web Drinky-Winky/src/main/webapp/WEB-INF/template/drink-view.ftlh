<!DOCTYPE html>
<html lang="pl" xmlns="http://www.w3.org/1999/html">
<head>

    <#include "css.ftlh">

    <meta charset="utf-8">
    <title>Welcome <#--<--${user.getName()}&ndash;&gt;--></title>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>


</head>
<body>

<nav class="navigation">
    <div class="container">
        <ul>
            <li><a href="#load">Welcome</a></li>
            <li><a href="#about">About application</a></li>
            <li><a href="#contact">Contacts</a></li>

            <form action="Drink-view" method="get">
                <input name="name" list="allDrink" class="search" type="text" placeholder="Search.."
                       onfocus="this.placeholder=''"
                       onblur="this.placeholder='Search...'" required>
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>

            <datalist id="allDrink">
                <#if allDrink??>
                    <#list allDrink>
                        <ul>
                            <#items as drink>
                            <option value="${drink.getName()}">
                                </#items>
                        </ul>
                    </#list>
                </#if>
            </datalist>
        </ul>
        <br/>

        <#if favourite.isEmpty()>

        <form action="Add-favourite?name=${drink.getName()}" method="post">
            <input class="btn2" type="submit" name="${drink.getName()}" value="ADD FAV"/>
            <button onclick="goBack()" class="btn2">Go Back</button>
        </form>

        <#elseif favourite.isPresent()>

        <form action="Add-favourite?name=${drink.getName()}" method="post">
            <input class="btn2" type="submit" name="${drink.getName()}" value="REMOVE FAV"/>
            <button onclick="goBack()" class="btn2">Go Back</button>
        </form>

        </#if>

    </div>
</nav>
<section class="splash" id="load"
         style="background-image:url('https://images.pexels.com/photos/239466/pexels-photo-239466.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');">
    <div class="page-intro">
        <div class="container"></div>
    </div>
</section>
<section class="add" id="Drink view">
    <h2 class="section-title">${drink.getName()}</h2>
    <div class="gallery-wrapper">

        <figure class="add-drink"></figure>
        <figure class="gallery-item" style="padding: 5px">
            <img src="${drink.getImageUrl()}" alt="image"><br/>
            <figcaption>${drink.getName()}</figcaption>
        </figure>

        <figure class="add-drink1">
            <div class="container1">
                <B>${drink.getName()}</B><br/>
                <B>Recipe:</B> ${drink.getRecipe()}<br/>
                <B>Drink type:</B> ${drink.getDrinkType()}<br/>
                <B>Glass type:</B> ${drink.getGlassType()}<br/>
                <B>When added:</B> ${drink.getModificationDate()}<br/>
                <B>Category:</B> ${drink.getCategory().getName()}<br/>
                <br/>
                <B>Ingredient with measure:</B><br/>
                <#list ingredients>
                    <ul>
                        <#items as ingredient>
                            <li>
                                ${ingredient.getName()}
                                ${ingredient.getMeasure()}
                            </li>
                        </#items>
                    </ul>
                </#list>

            </div>
        </figure>

        <figure>
            <div></div>
        </figure>

    </div>
</section>


<#include "about.ftlh">

<section class="statement">
    <div class="container">
        <p>Drink or not to drink.. that is the question</p>
    </div>
</section>

<#include "contact.ftlh">
<#include "footer.ftlh">

<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
<script src="scripts/main.js"></script>

</body>
</html>