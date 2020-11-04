<!DOCTYPE html>

<html>
<head>

    <#include "css.ftlh">

</head>
<body>

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

                    <label for="category-choice">Category: <input list="categories" id="category-choice" type="text" name="category" required/><br/></label>

                    <datalist id="categories">

                        <#list categories>
                                                    <ul>
                        <#items as category>
                        <option value="${category.getName()}">
                            </#items>
                                                        </ul>
                            </#list>

                    </datalist>


                    Glass: <input type="text" name="glassType" required/><br/>
                    <label> Image <input type="url" name="imageUrl" required/><br/></label>
                    Alcoholic:
                    <label style="float: right"> <input type="radio" name="drinkType" value="Non alcoholic" required> No </label>
                    <label style="float: right"> <input type="radio" name="drinkType" value="Alcoholic" required> Yes </label>
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


<#--<#list categories>-->
<#--    <ul>-->
<#--        <#items as category>-->
<#--            <li>-->
<#--                ${category.getName()}-->
<#--            </li>-->
<#--        </#items>-->
<#--    </ul>-->
<#--</#list>-->

</body>
</html>