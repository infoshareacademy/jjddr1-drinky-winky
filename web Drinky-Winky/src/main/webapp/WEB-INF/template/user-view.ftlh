<!DOCTYPE html>
<html lang="pl" xmlns="http://www.w3.org/1999/html">
<head>

    <#include "css.ftlh">

    <meta charset="utf-8">
    <title>Welcome <#--${user.getName()}--></title>

</head>
<body>

<nav class="navigation">
    <div class="container">
        <ul>
            <li><a href="#load">Welcome</a></li>
            <li><a href="#gallery">Drinks</a></li>
            <li><a href="#about">About application</a></li>
            <li><a href="#contact">Contacts</a></li>

            <form method="get" action="Logout">
                <input type="submit" name="navigator" value="logout"/>
            </form>

            <input list="allDrink" class="search" type="text" placeholder="Search.." onfocus="this.placeholder=''"
                   onblur="this.placeholder='Search...'" required>

            <datalist id="allDrink">
                <#if allDrik??>
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
    </div>
</nav>

<section class="splash" id="load"
         style="background-image: url('https://images.pexels.com/photos/616836/pexels-photo-616836.jpeg?cs=srgb&dl=pexels-toni-cuenca-616836.jpg&fm=jpg');">

    <div class="page-intro">
        <div class="container">
            <h1 class="main-title">Welcome user</h1>
        </div>
    </div>

</section>

<section class="statement">
    <div class="container">
        <p>Drink or not to drink.. that is the question</p>
    </div>
</section>

<section class="gallery" id="gallery">
    <h2 class="section-title">Drink list</h2>
    <div class="gallery-wrapper">

        <#if drinkList??>
            <#list drinkList>
                <#items as drink>

                    <figure class="gallery-item" style="padding: 5px">
                        <img src=${drink.getImageUrl()} alt="image">
                        <a href="http://localhost:8080/Drink-view?name=${drink.getName()}">
                            <figcaption>${drink.getName()}</figcaption>
                        </a>
                    </figure>

                </#items>
            </#list>
        </#if>

    </div>
</section>

<#include "add-favourite.ftlh">

<section class="statement">
    <div class="container">
        <p>Drink or not to drink.. that is the question</p>
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