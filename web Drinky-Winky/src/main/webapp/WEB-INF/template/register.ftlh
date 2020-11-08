<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">


    <meta charset="utf-8">

</head>
<body>


<section class="about" id="logs">
    <div class="container">
        <h2 class="section-title">Welcome!</br> Register in here. </h2>
        <form method="post" action="RegUser"  id="log">
            <label for="name"> Name: </label>
            <input style="float: none" type="text" id="name" name="name"></br></br>
            <label for="surname"> Surname: </label>
            <input style="float: none" type="text" id="surname" name="surname"></br></br>
            <label for="login"> Login: </label>
            <input style="float: none" type="text" id="login" name="login"></br></br>
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