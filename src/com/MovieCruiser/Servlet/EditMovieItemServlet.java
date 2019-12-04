package com.MovieCruiser.Servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class EditMovieItemServlet
 */
@WebServlet("/EditMovieItemServlet")
public class EditMovieItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieItemServlet() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean activeFlag;

		String movieItemId = request.getParameter("movieId");
		System.out.println(movieItemId);
		String title = request.getParameter("title");
		System.out.println(title);
		String boxOffice = request.getParameter("gross");
		System.out.println(boxOffice);
		String active = request.getParameter("available");
		if (active.equals("yes"))
			activeFlag = true;
		else
			activeFlag = false;
		System.out.println(active);

		String dateOfLaunch = request.getParameter("date");
		System.out.println(dateOfLaunch);

		String genre = request.getParameter("genre");
		System.out.println(genre);
		boolean hasTeaser = request.getParameter("hasTeaser") != null;
		System.out.println(hasTeaser);

		try {

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date dateLaunch = sdf.parse(dateOfLaunch);
			MovieItem movieItem = new MovieItem(Long.parseLong(movieItemId),
					title, Long.parseLong(boxOffice), activeFlag, dateLaunch,
					genre, hasTeaser);
			System.out.println("MovieItem To be updated is" + movieItem);
			MovieItemDaoSqlImpl movieItemDaoSqlImpl = new MovieItemDaoSqlImpl();
			MovieItemDao movieItemDao = movieItemDaoSqlImpl;
			movieItemDao.modifyMovieItem(movieItem);
			System.out.println("After updated"
					+ movieItemDao.getMovieItemListAdmin());
			request.getRequestDispatcher("edit-movie-status.jsp").forward(
					request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
