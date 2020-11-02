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