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
            <form method="post" action="New-drink" id="mySelect">
                <fieldset>
                    <legend> Fill all fields</legend>

                    <label for="names-choice">Name: <input list="names" id="names-choice" type="text" name="name"
                                                           placeholder="Find drink by name"
                                                           required/><br/></label>

                    <datalist id="names">
                        <#if names??>
                            <#list names>
                                <ul>
                                    <#items as name>
                                    <option value="${name.getName()}">
                                        </#items>
                                </ul>
                            </#list>
                        </#if>
                    </datalist>

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


                    <label for="glass-choice">Glass: <input list="glasses" id="glass-choice" type="text"
                                                            name="glassType" required/><br/></label>

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
                                                        required> No </label>
                    <label style="float: right"> <input type="radio" name="drinkType" value="Alcoholic" required>
                        Yes</label><br/>

                    <br/><br/>

                    <div class="upload-btn-wrapper">
                        <input class="btn2" type="submit" name="Find" value="find"/><br/><br/>
                    </div>

                    <br/>


                </fieldset>

            </form>

        </figure>


        <figure class="find-drink"></figure>
    </div>
</section>
</body>
</html>