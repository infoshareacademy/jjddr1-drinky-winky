<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">
    <#include "js-head.ftlh">

    <meta charset="utf-8">
    <title>Drinky-Winky WebApp</title>

</head>
<body>

<nav class="navigation">
    <div class="container">
        <ul>
            <li><a href="#about">About application</a></li>
            <li><a href="#features">Drinks</a></li>
            <li><a href="#quotes">Recipes</a></li>
            <li><a href="#gallery">Gallery</a></li>
            <li><a href="#contact">Contacts</a></li>

            <form method="get" action="Navigation-servlet">
                <input type="submit" name="navigator" value="admin"/>
                <input type="submit" name="navigator" value="user"/>
            </form>



            <form action="search-drink2" method="get">
                <label for="drinkSearchPost">Drink Search:</label> <input pattern=".{3,}" required title="3 characters minimum" type="text" name="drinkSearch" id="drinkSearchPost" placeholder="*What would you like to drink?">
                <button type="submit">Find</button>
            </form>

            <form action="filters" method="get">
                <button type="submit">More Filters</button>
            </form>
        </ul>

            <form method="get" action="Navigation-servlet" style="float: none; margin-right: 20px" >
                <input class="btn2" type="submit" name="navigator" value="Login"/>
                <input class="btn2" type="submit" name="navigator" value="Register"/>
            </form>

    </div>
</nav>

<section class="splash">
    <div class="page-intro">
        <h1 class="main-title">Welcome to our Drinks Library!</h1>
        <h2 class="main-subtitle">DRINKY-WINKY</h2>
        <a class="btn btn-solid" href="#about">CLICK ME</a>
    </div>
</section>

<#include "about.ftlh">

<#include "features.ftlh">

<section class="statement">
    <div class="container">
        <p>Drink or not to drink.. that is the question</p>
    </div>
</section>

<#include "quotes.ftlh">

<#include "gallery.ftlh">

<#include "contact.ftlh">

<#include "footer.ftlh">

<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
<script src="scripts/main.js"></script>

</body>
</html>