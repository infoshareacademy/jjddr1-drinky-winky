<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">
    <meta charset="utf-8">

</head>
<body>


<section class="about" id="logs">
    <div class="container">
        <h2 class="section-title"></br> You signed in correctly!</br></br></h2>
        <p>Please wait a sec for redirection</p>
    </div>
    <script>
        var timer = setTimeout(function() {
            window.location='/User-view?page=1'
        }, 1500);
    </script>

</section>
</body>
</html>