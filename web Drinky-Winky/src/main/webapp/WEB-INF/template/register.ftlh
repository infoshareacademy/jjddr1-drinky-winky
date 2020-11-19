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
        <form method="post" action="RegUser" id="log">
            <label for="login" style="margin-left: -55px"> Login: </label>
            <input style="float: none; margin-left: 10px" type="text" id="login" name="login" required=""></br></br>
            <label for="name" style="margin-left: -55px"> Name: </label>
            <input style="float: none; margin-left: 10px" type="text" id="name" name="name" required=""></br></br>
            <label for="surname" style="margin-left: -79px"> Surname: </label>
            <input style="float: none; margin-left: 10px" type="text" id="surname" name="surname" required=""></br></br>
            <label for="password" style="margin-left: -84px"> Password: </label>
            <input style="float: none; margin-left: 10px" type="password" minlength="7" id="password" name="password" placeholder="min 7 char" required=""></br></br>
            <label for="password" style="margin-left: -144px">Confirm password: </label>
            <input style="float: none; margin-left: 10px" type="password" id="passwordConfirm" name="passwordConfirm" placeholder="min 7 char" required=""></br></br>

            <script>
                var log_password = document.getElementById("password")
                    , passwordConfirm = document.getElementById("passwordConfirm");

                function validatePassword() {
                    if (log_password.value != passwordConfirm.value) {
                        passwordConfirm.setCustomValidity("Passwords Don't Match");
                    } else {
                        passwordConfirm.setCustomValidity('');
                    }
                }

                log_password.onchange = validatePassword;
                passwordConfirm.onkeyup = validatePassword;
            </script>

            <div class="upload-btn-wrapper" style="float: none">
                <input class="btn2" type="submit" name="save" value="Sign up"/><br/><br/>
            </div>
        </form>
        <div class="upload-btn-wrapper" style="float: none">
            <form method="get" action="Navigation-servlet" style="width: 100%">
                <input class="btn2" type="submit" name="navigator" value="Login"/>
            </form>
        </div>
    </div>
</section>
</body>
</html>