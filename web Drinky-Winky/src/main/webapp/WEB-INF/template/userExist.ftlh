<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">
    <meta charset="utf-8">

</head>
<body>


<section class="about" id="logs">
    <div class="container">
        <h2 class="section-title"></br> User with this login already exists, try again</h2>
        <p>You will be redirected again to register panel in 5 seconds</p>
    </div>
    <script>
        var timer = setTimeout(function() {
            window.location='/Register'
        }, 5000);
    </script>

</section>
</body>
</html>