<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">
    <meta charset="utf-8">

</head>
<body>


<section class="about" id="logs">
    <div class="container">
        <h2 class="section-title"></br> You signed out correctly</br></br></h2>
        <p>See you next time!</p>
    </div>
    <script>
        var timer = setTimeout(function() {
            window.location='/Start'
        }, 4000);
    </script>

</section>
</body>
</html>