<html>
<head>
    <title>More Filters</title>
</head>
<body>
<section class="add" id="add">
    <h2 class="section-title">Find drink</h2>
    <div class="gallery-wrapper">

        <figure class="add-drink"></figure>
        <figure class="gallery-item">
        </figure>


        <figure>
            <form method="get" action="find-by-filters" id="mySelect">
                <fieldset>


                    <label for="category-choice">Category: <input list="categories" id="category-choice" type="text"
                                                                  name="category" /><br/></label>

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


                    <label for="glass-choice">Glass: <input list="glasses" id="glass-choice" type="text"
                                                            name="glassType" /><br/></label>

                    <datalist id="glasses">
                        <#if glasses??>
                            <#list glasses>
                                <ul>
                                    <#items as glass>
                                    <option value="${glass.getGlassType()}">
                                        </#items>
                                </ul>
                            </#list>
                        </#if>
                    </datalist>

                    Alcoholic:
                    <label style="float: right"> <input type="radio" name="drinkType" value="Non alcoholic"
                                                        > No </label>
                    <label style="float: right"> <input type="radio" name="drinkType" value="Alcoholic" >
                        Yes</label><br/>

                    <br/><br/>

                    <div class="upload-btn-wrapper">
                        <input class="btn2" type="submit" name="Find" value="find"/><br/><br/>
                    </div>

                    <br/>


                </fieldset>

            </form>

        </figure>

    </div>
</section>
</body>
</html>