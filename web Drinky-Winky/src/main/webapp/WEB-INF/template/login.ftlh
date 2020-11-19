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

        <form method="post" action="Auth" id="log" style="width: 100%">
            <label for="login" style="margin-left: -50px"> Login: </label>
            <input style="float: none; margin-left: 10px" type="text" id="login" name="login" required></br></br>
            <label for="password" style="margin-left: -78px"> Password: </label>
            <input style="float: none; margin-left: 10px" type="password" id="password" name="password"
                   required></br></br>

            <div class="upload-btn-wrapper" style="float: none; margin-left: 5px">
                <input class="btn2" type="submit" name="save" value="Sign in"/><br/><br/>
            </div>
        </form>

        <div class="upload-btn-wrapper" style="float: none; margin-left: 5px">
            <form method="get" action="Navigation-servlet" style="width: 100%">
                <input class="btn2" type="submit" name="navigator" value="Register"/>
            </form>
        </div>

    </div>
</section>
</body>
</html>