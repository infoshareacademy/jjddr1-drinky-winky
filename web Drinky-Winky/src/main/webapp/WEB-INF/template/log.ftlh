<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">


    <meta charset="utf-8">

</head>
<body>


<section class="about" id="logs">
    <div class="container">
        <h2 class="section-title">Welcome!</br> Log in here. </h2>
        <form method="post" action="Auth"  id="log">
            <label for="login"> Login: </label>
            <input style="float: none" type="text" id="login" name="login" required></br></br>
            <label for="password"> Password: </label>
            <input style="float: none" type="password" id="password" name="password" required></br></br>

            <div class="upload-btn-wrapper" style="float: none">
                <input class="btn2" type="submit" name="save" value="Sign in"/><br/><br/>
            </div>

        </form>
    </div>
</section>
</body>
</html>