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
import com.MovieCruiser.Dao.FavouritesEmptyException;
import com.MovieCruiser.model.MovieItem;

/**
 * @author Lavanya_K
 *
 */

/**
 * Servlet implementation class ShowFavouritesServlet
 */
@WebServlet("/ShowFavouritesServlet")
public class ShowFavouritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowFavouritesServlet() {
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
		System.out.println("Inside doGet of ShowFavouritesServlet");
		try {
			System.out.println("1");
			List<MovieItem> movieItemList = favouritesDao
					.getAllFavouritesItem(userId);
			System.out.println("2");
			request.setAttribute("favouritesMovieList", movieItemList);
			System.out.println("3");
			request.getRequestDispatcher("favorites.jsp").forward(request,
					response);
			System.out.println("4");

		}

		catch (FavouritesEmptyException e) {
			System.out.println("inside catch block :" + request);
			request.getRequestDispatcher("favorites-empty.jsp").forward(
					request, response);
			e.printStackTrace();

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
