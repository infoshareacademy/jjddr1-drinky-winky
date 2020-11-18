<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">
    <meta charset="utf-8">

</head>
<body>


<section class="about" id="logs">
    <div class="container">
        <h2 class="section-title"></br> Success! You signed up!</br>Now you can Log in to your account</br></h2>
        <p>WELCOME IN THE WORLD OF AMAZING DRINKS! </p>
    </div>
    <script>
        var timer = setTimeout(function() {
            window.location='/User-view?page=1'
        }, 2000);
    </script>

</section>
</body>
</html>