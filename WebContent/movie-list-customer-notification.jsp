<%@ page import="com.MovieCruiser.model.MovieItem"%>
<%@ page import="com.MovieCruiser.Dao.MovieItemDaoCollectionImpl"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>

<head>
<link rel="stylesheet" href="style\stylemovie.css">
<title>Movie list customer notification</title>
</head>
<body>

	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img class="header-img" src="images\reel.png"> <a
			class="header-itemright-Fav" href="favorites.html">Favorites</a> <a
			class="header-itemright-Mov" href="movie-list-customer.html">Movies</a>
	</header>

	<section class="body-main">
		<h1>Movies</h1>
		<c:if test="${addCartStatus}">
			<h2 style="color: green; text-align: center;">Movies added to
				Favourites Successfully</h2>
		</c:if>

		<table width="100%">
			<tr>
				<th class="th-allignleft">Title</th>
				<th class="th-allignright">Box Office</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>

			<tr>
				<td class="td-allignleft">Avatar</td>
				<td class="td-allignright">$2,787,965,087</td>
				<td>Science Fiction</td>
				<td>Yes</td>
				<td><a href="movie-list-customer-notification.html">Add to
						Favorite</a></td>
			</tr>

			<tr>
				<td class="td-allignleft">The Avengers</td>
				<td class="td-allignright">$1,518,812,988</td>
				<td>Superhero</td>
				<td>No</td>
				<td><a href="movie-list-customer-notification.html">Add to
						Favorite</a></td>
			</tr>

			<tr>
				<td class="td-allignleft">Titanic</td>
				<td class="td-allignright">$2,187,463,944</td>
				<td>Romance</td>
				<td>No</td>
				<td><a href="">Add to Favorite</a></td>
			</tr>
		</table>
	</section>
	<footer>
		<p>Copyright � 2019</p>
	</footer>
</body>
</html>

