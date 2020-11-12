<nav class="navigation">
    <div class="container">
        <ul>
            <li><a href="#load">Load file</a></li>
            <li><a href="#add">Add drink</a></li>
            <li><a href="#remove">Remove drink</a></li>
            <li><a href="#logs"><i class="fa fa-fw fa-user"></i> Login</a></li>
            <li><a href="Age-query">Age query</a></li>
            <li><a href="Start">Start</a></li>

            <form action="Drink-view" method="get">
                <input name="name" list="names" class="search" type="text" placeholder="Search.."
                       onfocus="this.placeholder=''"
                       onblur="this.placeholder='Search...'" required>
                <button type="submit"><i class="fa fa-search"></i></button>
            </form>

            <datalist id="names">
                <#if drinks??>
                    <#list drinks>
                        <ul>
                            <#items as name>
                            <option value="${name.getName()}">
                                </#items>
                        </ul>
                    </#list>
                </#if>
            </datalist>

        </ul><br/>
        <button onclick="goBack()" class="btn2">Go Back</button>
    </div>
</nav>