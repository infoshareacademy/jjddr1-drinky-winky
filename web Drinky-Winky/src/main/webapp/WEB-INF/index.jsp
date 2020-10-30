<!doctype html>
<html lang="pl">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <title>adminMode</title>
</head>
<body>

<div class="jumbotron jumbotron-fluid ">
    <div class="container">
        <h1 class="display-3">Admin Panel</h1>
    </div>
</div>
<div class="btn btn-secondary btn-lg active" role="button" aria-pressed="true">
    <form id="form-upload" action="/json-upload" method="post" enctype="multipart/form-data">
        <input type="file" name="drinks">
        <button type="submit" class="btn btn-secondary">Upload</button>
    </form>
</div>
</body>
</html>
