<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">

    <meta charset="utf-8">
    <title>Welcome <#--${user.getName()}--></title>

</head>
<body>

<nav class="navigation">
    <div class="container">
        <ul>
            <li><a href="#gallery">Drinks</a></li>
            <li><a href="#about">About application</a></li>
            <li><a href="#contact">Contacts</a></li>

            <input class="search" type="text" placeholder="Search.." onfocus="this.placeholder=''"
                   onblur="this.placeholder='Search...'">
        </ul>
    </div>
</nav>


<section class="gallery" id="gallery">
    <h2 class="section-title">Drink list</h2>
    <div class="gallery-wrapper">

        <#if drinkList??>
            <#list drinkList>
                <#items as drink>

                    <figure class="gallery-item">
                        <img src= ${drink.getImageUrl()} alt="image">
                        <figcaption>${drink.getName()}</figcaption>
                    </figure>

                </#items>
            </#list>
        </#if>

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

</body>
</html>