<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>

<head>
<link rel="stylesheet" href="style\stylemovie.css">
<title>Favourites</title>
</head>
<body>

	<header class="header container-fluid">
		<h1 class="header-itemleft">Movie Cruiser</h1>
		<img class="header-img" src="images\reel.png"> <a
			class="header-itemright-Fav" href="ShowFavouritesServlet">Favorites</a>
		<a class="header-itemright-Mov"
			href="ShowMovieItemListCustomerServlet">Movies</a>
	</header>

	<section class="body-main">
		<h1>Favourites</h1>
		<c:if test="${removeFavouritesStatus}">
			<h2 style="color: #00b300; text-align: center;">Movie removed
				from Favourites successfully</h2>
		</c:if>
		<table width="100%">
			<tr>
				<th class="th-allignleft">Title</th>
				<th class="th-allignright">Box Office</th>
				<th>Genre</th>
				<th></th>
			</tr>
			<c:set var="sum" value="${0}"></c:set>
			<c:forEach var="fav" items="${favouritesMovieList}">
				<tr>

					<td class="td-allignleft">${fav.title}</td>


					<td class="td-allignright"><fmt:setLocale value="en_US"
							scope="session" />
						<fmt:formatNumber type="currency" value="${fav.boxOffice}" /></td>
					<c:set var="sum" value="${sum+1}"></c:set>
					<td>${fav.genre}</td>
					<td><a href="RemoveFavouritesServlet?movieId=${fav.id }">Delete</a>
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td class="td-allignleft"><h3>
						No. of Favorites:
						<c:out value="${sum}" />
					</h3></td>

			</tr>
		</table>
	</section>
	<footer>
		<p>Copyright © 2019</p>
	</footer>
</body>
</html>

