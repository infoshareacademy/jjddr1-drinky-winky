<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">
    <#include "js-head.ftlh">

    <meta charset="utf-8">

</head>
<body>


<section class="about" id="logs">
    <div class="container">
        <h2 class="section-title">Welcome!</br> Log in here. </h2>
        <form method="get" action="User-view"  id="log">
            <label for="login"> Login: </label>
            <input style="float: none" type="email" id="login" name="login"></br></br>
            <label for="password"> Password: </label>
            <input style="float: none" type="password" id="password" name="password"></br></br>

            <div class="upload-btn-wrapper" style="float: none">
                <input class="btn2" type="submit" name="save" value="save"/><br/><br/>
            </div>

        </form>
    </div>
</section>
</body>
</html>