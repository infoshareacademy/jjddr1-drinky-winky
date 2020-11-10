<section class="add" id="Category List">
    <h2 class="section-title">Category List</h2>
    <div class="gallery-wrapper">

        <figure class="add-drink"></figure>
        <figure class="gallery-item">
            <img src="https://images.pexels.com/photos/1128259/pexels-photo-1128259.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
                 alt="image">
        </figure>


        <figure>
            <form method="get" action="Category-list" id="mySelect">
                <fieldset>
                    <legend> Choose category to view</legend>

                    <label for="names-choice">Name: <br/><input list="categories" id="names-choice" type="text" type="text" placeholder="Search.." name="name"
                                                                required/><br/></label>

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

                    <div class="upload-btn-wrapper">
                        <input class="btn2" type="submit" value="Search"/><br/><br/>
                    </div>

                </fieldset>
            </form>
        </figure>
    </div>
</section>