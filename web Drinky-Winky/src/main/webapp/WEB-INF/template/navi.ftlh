<nav class="navigation">
    <div class="container">
        <ul>
            <li><a href="#load">Load file</a></li>
            <li><a href="#add">Add drink</a></li>
            <li><a href="#remove">Remove drink</a></li>
            <li><a href="#logs"><i class="fa fa-fw fa-user"></i> Login</a></li>
            <li><a href="Age-query">Age query</a></li>
            <li><a href="Start">Start</a></li>

            <input list="names" class="search" type="text" placeholder="Search.." onfocus="this.placeholder=''"
                   onblur="this.placeholder='Search...'" required>

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

        </ul>
    </div>
</nav>