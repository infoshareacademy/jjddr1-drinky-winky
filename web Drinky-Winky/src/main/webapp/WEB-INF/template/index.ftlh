<!DOCTYPE html>
<html lang="pl">
<head>

    <#include "css.ftlh">
    <#include "js-head.ftlh">

    <meta charset="utf-8">
    <title>Drinky-Winky WebApp</title>

</head>
<body>

<nav class="navigation">
    <div class="container">
        <ul>
            <li><a href="#about">O aplikacji</a></li>
            <li><a href="#features">Drinki</a></li>
            <li><a href="#quotes">Przepisy</a></li>
            <li><a href="#gallery">Galeria</a></li>
            <li><a href="#contact">Kontakt</a></li>

<#--            <li><a href="#add">Add_Drink</a></li>-->
            <form method="get" action="NavigationServlet">
            <input type="submit" name="navigator" value="add-drink"/>
            </form>

            <li><a href="#logs"><i class="fa fa-fw fa-user"></i> Login</a></li>
            <input class="search" type="text" placeholder="Search.." onfocus="this.placeholder=''"
                   onblur="this.placeholder='Search...'">
        </ul>
    </div>
</nav>

<section class="splash">
    <div class="page-intro">
        <h1 class="main-title">WITAJ W NASZEJ APLIKACJI</h1>
        <h2 class="main-subtitle">DRINKY-WINKY</h2>
        <a class="btn btn-solid" href="#about">CLICK ME</a>
    </div>
</section>

<section class="about" id="about">
    <div class="container">
        <h2 class="section-title">COŚ O DRINKY-WINKY</h2>
        <p class="section-intro">Aplikacja powstała jako... bla bla bla...</p>
    </div>
</section>


<section class="about">

    <!-- REJESTRACJA   -->
</section>


<section class="features" id="features">
    <div class="container">
        <h2 class="section-title">DRINKI BAZA DANYCH</h2>
        <p class="section-intro">Tutaj jest miejsce na wyszukiwanie itp....
            <div class="features-wrapper">
                <article class="feature">
                    <i class="fas fa-wine-glass-alt"></i>
                    <h3 class="feature-title">NAGŁÓWEK 1</h3>
        <p class="feature-description">Tekst do napisania...</p>
        </article>
        <article class="feature">
            <i class="fas fa-cocktail"></i>
            <h3 class="feature-title">NAGŁÓWEK 2</h3>
            <p class="feature-description">Tekst do napisanie...</p>
        </article>
        <article class="feature">
            <i class="fas fa-glass-whiskey"></i>
            <h3 class="feature-title">NAGŁÓWEK 3</h3>
            <p class="feature-description">Tekst do napisania</p>
        </article>
    </div>
    </div>
</section>

<section class="statement">
    <div class="container">
        <p>Chluśniem bo uśniem</p>
    </div>
</section>

<section class="quotes" id="quotes">
    <div class="container">
        <h2 class="section-title">PRZEPISY</h2>
        <div class="quotes-wrapper">
            <article class="quote">
                <blockquote>
                    <q>Rub the rim of the glass with the lime slice to make the salt stick to it. Take care to moisten
                        only the outer rim and sprinkle the salt on it. The salt should present to the lips of the
                        imbiber and never mix into the cocktail. Shake the other ingredients with ice, then carefully
                        pour into the glass.</q>
                    <footer>Margarita</footer>
                </blockquote>
            </article>
            <article class="quote">
                <blockquote>
                    <q>Rub rim of cocktail glass with lime juice. Dip rim in coarse salt. Shake tequila, blue curacao,
                        and lime juice with ice, strain into the salt-rimmed glass, and serve.</q>
                    <footer>Blue Margarita</footer>
                </blockquote>
            </article>
            <article class="quote">
                <blockquote>
                    <q>Shake and strain into a chilled cocktail glass.</q>
                    <footer>Tommy's Margarita</footer>
                </blockquote>
            </article>
        </div>
    </div>
</section>

<section class="gallery" id="gallery">
    <h2 class="section-title">GALERIA</h2>
    <div class="gallery-wrapper">
        <figure class="gallery-item">
            <img src="https://naszedrinki.pl/wp-content/uploads/2013/12/margarita.jpg" alt="image">
            <figcaption>Margarita</figcaption>
        </figure>
        <figure class="gallery-item">
            <img src="https://www.thecocktaildb.com/images/media/drink/bry4qh1582751040.jpg" alt="image">
            <figcaption>Blue Margarita</figcaption>
        </figure>
        <figure class="gallery-item">
            <img src="https://www.thecocktaildb.com/images/media/drink/loezxn1504373874.jpg" alt="image">
            <figcaption>Tommy's Margarita</figcaption>
        </figure>
        <figure class="gallery-item">
            <img src="https://www.thecocktaildb.com/images/media/drink/srpxxp1441209622.jpg" alt="image">
            <figcaption>Whitecap Margarita</figcaption>
        </figure>
    </div>
</section>


<section class="about" id="logs">
    <div class="container">
        <h2 class="section-title">LOGOWANIE</h2>
        <form method="post" action="/log" enctype="multipart/form-data" id="log">
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


<#include "contact.ftlh">

<#include "footer.ftlh">

<script src="https://unpkg.com/flickity@2/dist/flickity.pkgd.min.js"></script>
<script src="scripts/main.js"></script>

</body>
</html>