<!doctype html>
<html lang="pl" ng-app="agendaEditor">
<head>

    <#include "css.ftlh">
    <#include "js-head.ftlh">

    <meta charset="utf-8">
    <title>AdminMode</title>
</head>
<body ng-controller="formCtrl">

<#include "navi.ftlh">

<section class="splash" id="load"
         style="background-image: url('https://images.pexels.com/photos/339696/pexels-photo-339696.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940');">

    <div class="page-intro">
        <div class="container">
            <h1 class="main-title">Admin Panel</h1>

            <form action="Json-upload" method="post" enctype="multipart/form-data">
                <div style="display: flex; flex-direction: row;">
                    <input style="margin: auto; display: block; float: none;" class="btn btn-solid" type="file"
                           name="drinks">
                    <button style="margin: auto; display: block; float: none;" class="btn btn-solid" type="submit"
                            class="">Upload
                    </button>
                </div>
            </form>

        </div>
    </div>

</section>

<section class="add" id="add">
    <h2 class="section-title">ADD NEW DRINK</h2>
    <div class="gallery-wrapper">

        <figure class="add-drink"></figure>
        <figure class="gallery-item">
            <img src="https://img.wonderhowto.com/img/original/31/78/63586557575482/0/635865575754823178.jpg"
                 alt="image">
            <figcaption>Alcohol Only 18+</figcaption>
        </figure>

        <figure>

            <form method="post" action="New-drink" id="mySelect">

                <fieldset>

                    <legend> Fill all fields</legend>


                    Name: <input type="text" name="name" required/><br/>

                    <label for="category-choice">Category: <input list="categories" id="category-choice" type="text"
                                                                  name="category" required/><br/></label>

                    <datalist id="categories">
                        <#if categories??>
                            <#list categories>
                                <ul>
                                    <#items as category>
                                    <option value="${category.getName()}">
                                        </#items>
                                </ul>
                            </#list>
                        </#if>
                    </datalist>


                    Glass: <input type="text" name="glassType" required/><br/>
                    <label> Image <input type="url" name="imageUrl" required/><br/></label>
                    Alcoholic:
                    <label style="float: right"> <input type="radio" name="drinkType" value="Non alcoholic" required> No
                    </label>
                    <label style="float: right"> <input type="radio" name="drinkType" value="Alcoholic" required> Yes
                    </label>
                    <br/>

                    Recipe: <textarea type="text" name="recipe"
                                      style="width: 185px; height: 120px; float: right" required></textarea><br/>


                    <table>
                        <tr>
                            <td>Ingredient</td>
                            <td>Measures</td>
                        </tr>
                        <tr ng-repeat="item in list" ng-click="$last && addItem()">
                            <td><input type="text" name="ingredient" ng-model="item.ingredient" required></td>
                            <td><input type="text" name="measure" ng-model="item.measure" required></td>
                            <td ng-if="!$first">
                                <button ng-click="list.splice($index, 1)">-</button>
                            </td>
                        </tr>
                    </table>
                    <br/>

                    <!--                <button ng-click="addItem()">Add</button>-->

                    <#--                    <div class="upload-btn-wrapper">-->
                    <#--                        <button class="btn2">Upload a file</button>-->
                    <#--                        <input class="file_btn" type="file" name="image"/><br/><br/>-->
                    <#--                    </div>-->
                    <br/><br/>

                    <div class="upload-btn-wrapper">
                        <input class="btn2" type="submit" name="save" value="save"/><br/><br/>
                    </div>

                    <br/>


                </fieldset>

            </form>

        </figure>


        <figure class="add-drink"></figure>

    </div>
</section>

<#include "log.ftlh">

<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>

</body>
</html>

