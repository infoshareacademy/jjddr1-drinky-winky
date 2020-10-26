<html>
<body>
<h1>Add Drink from addDrink.html</h1>
 <% String name = (String)request.getAttribute("drinkName"); %>
<h2>Cześć, jestem <%= name %></h2>
<form method="post" action="/addDrink">
    drinkName: <input type="text" name="drinkName"/><br/><br/>
    glass: <input type="text" name="glass"/><br/><br/>
    <input type="submit" name="save" value="save"/><br/><br/>
</form>
</body>
</html>