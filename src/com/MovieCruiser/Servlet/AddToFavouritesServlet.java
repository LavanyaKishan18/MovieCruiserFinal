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
 * Servlet implementation class AddToFavouritesServlet
 */
@WebServlet("/AddToFavouritesServlet")
public class AddToFavouritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddToFavouritesServlet() {
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

		System.out.println("inside do get");
		String movieItemId = request.getParameter("movieId");
		int movieitemid = Integer.parseInt(movieItemId);
		FavouritesDaoSqlImpl favouritesDaoSqlImpl = new FavouritesDaoSqlImpl();
		FavouritesDao favouritesDao = favouritesDaoSqlImpl;
		favouritesDao.addFavouritesItem(1, movieitemid);
		MovieItemDaoSqlImpl movie = new MovieItemDaoSqlImpl();

		MovieItemDao movieItemDao = movie;
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListCustomer();

		request.setAttribute("addFavouritesStatus", true);
		request.setAttribute("customerMovieItemList", movieItemList);
		request.getRequestDispatcher("movie-list-customer.jsp").forward(
				request, response);
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
