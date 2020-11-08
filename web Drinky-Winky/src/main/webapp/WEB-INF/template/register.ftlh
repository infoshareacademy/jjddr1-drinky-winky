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
            <input style="float: none" type="text" id="name" name="name" required></br></br>
            <label for="surname"> Surname: </label>
            <input style="float: none" type="text" id="surname" name="surname" required></br></br>
            <label for="login"> Login: </label>
            <input style="float: none" type="text" id="login" name="login" required></br></br>
            <label for="password"> Password: </label>
            <input style="float: none" type="password" id="password" name="password" placeholder="min 7 char" required></br></br>
            <label for="password">Confirm password: </label>
            <input style="float: none" type="password" id="passwordConfirm" name="passwordConfirm" placeholder="min 7 char" required></br></br>

            <script>
                var log_password = document.getElementById("password")
                    , passwordConfirm = document.getElementById("passwordConfirm");

                function validatePassword(){
                    if(log_password.value != passwordConfirm.value) {
                        passwordConfirm.setCustomValidity("Passwords Don't Match");
                    } else {
                        passwordConfirm.setCustomValidity('');
                    }
                }

                log_password.onchange = validatePassword;
                passwordConfirm.onkeyup = validatePassword;
            </script>

            <div class="upload-btn-wrapper" style="float: none">
                <input class="btn2" type="submit" name="save" value="save"/><br/><br/>
            </div>

        </form>
    </div>
</section>



</body>
</html>