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

    <style>
        .dropdown-content {
            display: none;
            position: absolute;
            color: #227093;
        }

        .dropdown-content a {
            padding: 12px 16px;
            display: block;
            background-color: black;
            opacity: 0.75;
            border-radius: 10px;
            font-size: 14px;
        }

        .dropdown-content a:hover {
            background-color: black;
            opacity: 0.4;
            border-radius: 10px;
            font-size: 18px;
        }

        .dropdown:hover .dropdown-content {
            display: block;
            color: #227093;
        }
    </style>

</head>
<body>

<nav class="navigation">
    <div class="container">
        <ul>
            <li><a href="#load">Welcome</a></li>
            <li><a href="#gallery">Drinks</a></li>
            <li><a href="#about">About application</a></li>
            <li><a href="#contact">Contacts</a></li>

            <li class="dropdown"><a>Search By</a>
                <div class="dropdown-content">
                    <a href="#category">Drink</a>
                    <a href="#category">Category</a>
                    <a href="#category">Ingredient</a>
                </div>
            </li>


            <form action="Drink-view" method="get">
                <input name="name" list="allDrink" class="search" type="text" placeholder="Search.." onfocus="this.placeholder=''"
                       onblur="this.placeholder='Search...'" required>
                <button type="submit" style="float: none; margin-bottom: 8px; width: 30px; height: 28px"><i class="fa fa-search"></i></button><i class="fa fa-search"></i>
                </button>
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
        <form method="get" action="Logout" style="float: none;" >
            <button onclick="goBack()" class="btn2">Go Back</button>
            <input class="btn2" type="submit" name="navigator" value="Logout"/>
        </form>
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
</section>

<section class="gallery" id="gallery">
    <h2 class="section-title">Drink list</h2>

    <div class="container">
        <ul class="social-links">
            <#if pageNumber??>
                <#list pageNumber>
                    <#items as page>
                        <li style="margin-right: 20px; margin-left: 20px;">
                            <form method="get" action="User-view">
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

<#include "add-favourite.ftlh">
<section id="category">
<#include "category1.ftlh">
</section>
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