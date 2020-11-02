<!DOCTYPE html>
<html lang="pl" ng-app="agendaEditor">
<head>

    <#include "css.ftlh">
    <#include "js-head.ftlh">

</head>
<body ng-controller="formCtrl">

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

            <form method="post" action="NewDrinkServlet" id="mySelect">

                <fieldset>

                    <legend> Fill all fields</legend>


                    Name: <input type="text" name="name"/><br/>
                    Category: <input type="text" name="category"/><br/>
                    Glass: <input type="text" name="glassType"/><br/>
                    <label> Image <input type="text" name="imageUrl"/><br/></label>
                    Alcoholic:
                    <label style="float: right"> <input type="radio" name="drinkType" value="Non alcoholic"> No </label>
                    <label style="float: right"> <input type="radio" name="drinkType" value="Alcoholic"> Yes </label>
                    <br/>

                    Recipe: <textarea type="text" name="recipe"
                                      style="width: 185px; height: 120px; float: right"></textarea><br/>


                    <table>
                        <tr>
                            <td>Ingredient</td>
                            <td>Measures</td>
                        </tr>
                        <tr ng-repeat="item in list" ng-click="$last && addItem()">
                            <td><input type="text" name="ingredient" ng-model="item.ingredient"></td>
                            <td><input type="text" name="measure" ng-model="item.measure"></td>
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

<#include "contact.ftlh">

<#include "footer.ftlh">

<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
<script src="scripts/main.js"></script>

</body>
</html>