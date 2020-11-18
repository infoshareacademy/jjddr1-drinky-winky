<section class="add" id="remove">
    <h2 class="section-title"> ADD TO FAVOURITE </h2>
    <div class="gallery-wrapper">

        <figure class="add-drink"></figure>
        <figure class="gallery-item">
            <img src="https://img.wonderhowto.com/img/original/31/78/63586557575482/0/635865575754823178.jpg"
                 alt="image">
            <#--            <figcaption>${name.getName()}</figcaption>-->
        </figure>


        <figure>
            <form method="get" action="Add-favourite" id="mySelect">
                <fieldset>
                    <legend> Choose a drink to add favourite </legend>

                    <label for="names-choice">Name: <br/><input list="drinkList" id="names-choice" type="text" name="name"
                                                                required/><br/></label>

                    <datalist id="drinkList">
                        <#if drinkList??>
                            <#list drinkList>
                                <ul>
                                    <#items as name>
                                    <option value="${name.getName()}">
                                        </#items>
                                </ul>
                            </#list>
                        </#if>
                    </datalist>

                    <div class="upload-btn-wrapper">
                        <input class="btn2" type="submit" value="ADD FAV"/><br/><br/>
                    </div>

                </fieldset>
            </form>
        </figure>
    </div>
</section>