package com.MovieCruiser.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MovieCruiser.Dao.FavouritesDao;
import com.MovieCruiser.Dao.FavouritesDaoSqlImpl;
import com.MovieCruiser.Dao.MovieItemDao;
import com.MovieCruiser.Dao.MovieItemDaoSqlImpl;
import com.MovieCruiser.model.MovieItem;

/**
 * @author Lavanya_K
 *
 */

/**
 * Servlet implementation class RemoveFavouritesServlet
 */
@WebServlet("/RemoveFavouritesServlet")
public class RemoveFavouritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RemoveFavouritesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		long userId = 1;
		FavouritesDaoSqlImpl favouritesDaoSqlImpl = new FavouritesDaoSqlImpl();
		FavouritesDao favouritesDao = favouritesDaoSqlImpl;
		String movieItemId = request.getParameter("movieId");
		System.out.println(movieItemId);
		int movieitemid = Integer.parseInt(movieItemId);
		System.out.println("after parsing" + movieitemid);
		favouritesDao.removeFavouritesItem(1, movieitemid);
		MovieItemDaoSqlImpl movie = new MovieItemDaoSqlImpl();

		MovieItemDao movieItemDao = movie;
		// List<MenuItem> menuItemList
		// =cartDao.removeCartItem(userId,Long.parseLong(menuItemId));
		try {
			List<MovieItem> movieItemList = favouritesDao
					.getAllFavouritesItem(1);

			request.setAttribute("removeFavouritesStatus", true);
			request.setAttribute("favouritesMovieList", movieItemList);
			request.getRequestDispatcher("favorites.jsp").forward(request,
					response);
		} catch (Exception e) {
			request.getRequestDispatcher("favorites-empty.jsp").forward(
					request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
