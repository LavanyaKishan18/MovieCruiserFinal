package com.MovieCruiser.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.MovieCruiser.Dao.MovieItemDao;
import com.MovieCruiser.Dao.MovieItemDaoSqlImpl;
import com.MovieCruiser.model.MovieItem;

/**
 * @author Lavanya_K
 *
 */

/**
 * Servlet implementation class ShowEditMovieItemServlet
 */
@WebServlet("/ShowEditMovieItemServlet")
public class ShowEditMovieItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowEditMovieItemServlet() {
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
		MovieItemDaoSqlImpl movieSqlImpl = new MovieItemDaoSqlImpl();
		MovieItemDao movieDao = movieSqlImpl;
		long movieid = Long.parseLong(request.getParameter("movieId"));
		MovieItem movies = movieDao.getMovieItem(movieid);
		System.out.println("Menu Item===" + movies);
		request.setAttribute("MovieItem", movies);
		request.getRequestDispatcher("edit-movie.jsp").forward(request,
				response);

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
