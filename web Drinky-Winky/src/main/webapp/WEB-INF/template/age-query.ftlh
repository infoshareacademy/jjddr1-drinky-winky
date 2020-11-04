<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Age-Query</title>

    <#include "css.ftlh">

</head>
<body>


<section class="splash"
         style="background-image: url('https://images.pexels.com/photos/715995/pexels-photo-715995.jpeg?auto=compress&cs=tinysrgb&dpr=3&h=750&w=1260');">
    <div class="page-intro">
        <h1 class="main-title">THE SITE CONTAINS CONTENT FOR PEOPLE OVER 18+</h1>
        <h2 class="main-subtitle">ENTRY 18+</h2>

        <form method="get" action="Adult-check">

            <div style="display: flex; flex-direction: row;">
                <input src="Start" style="margin: auto; display: block; float: none;" class="btn btn-solid" type="submit"
                       name="age" value="18+"/>
                <input src="Say-goodbye" style="margin: auto; display: block; float: none;" class="btn btn-solid" type="submit"
                       name="age" value="NO"/>
            </div>

        </form>

    </div>
</section>

</body>
</html>