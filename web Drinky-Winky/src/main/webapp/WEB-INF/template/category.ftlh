<!DOCTYPE html>
<html lang="pl" ng-app="agendaEditor">
<head>
    <meta charset="UTF-8">
    <#include "css.ftlh">

    <title>Welcome <#--${user.getName()}--></title>
    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</head>
<body ng-controller="formCtrl">

<nav class="navigation">
    <div class="container">
        <ul>
            <li><a href="#gallery">Drinks</a></li>
            <li><a href="#about">About application</a></li>
            <li><a href="#contact">Contacts</a></li>
            <li><a href="Age-query">Age query</a></li>
            <li><a href="Start">Start</a></li>
            <li><a href="Category-list1">Search By Category<</a></li>

            <input class="search" type="text" placeholder="Search.." onfocus="this.placeholder=''"
                   onblur="this.placeholder='Search...'">
        </ul>
        <button onclick="goBack()" class="btn2">Go Back</button>
    </div>
</nav>
<section class="add" id="Category List">
    <h2 class="section-title">Category List</h2>
    <div class="gallery-wrapper">

        <figure class="add-drink"></figure>
        <figure class="gallery-item">
            <img src="https://images.pexels.com/photos/1128259/pexels-photo-1128259.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                 alt="image">
        </figure>


        <figure>
            <form method="get" action="Drink-view" id="mySelect">
                <fieldset>
                    <legend> Choose Drink to view</legend>

                    <label for="names-choice">Name: <br/><input list="categories" id="names-choice" type="text" placeholder="Search.." name="name"
                                                                required/><br/></label>

                    <datalist id="categories">
                        <#if categories??>
                            <#list categories>
                                <ul>
                                    <#items as drink>
                                    <option value="${drink.getName()}">
                                        </#items>
                                </ul>
                            </#list>
                        </#if>
                    </datalist>

                    <div class="upload-btn-wrapper">
                        <input class="btn2" type="submit" value="Show"/><br/><br/>
                    </div>

                </fieldset>
            </form>
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

</body>
</html>