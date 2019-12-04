package com.MovieCruiser.Servlet;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ShowMovieItemListAdminServlet
 */
@WebServlet("/ShowMovieItemListAdminServlet")
public class ShowMovieItemListAdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowMovieItemListAdminServlet() {
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
		MovieItemDaoSqlImpl movieItemDaoSqlImpl = new MovieItemDaoSqlImpl();
		MovieItemDao movieItemDao = movieItemDaoSqlImpl;
		List<MovieItem> movieItemList = movieItemDao.getMovieItemListAdmin();
		request.setAttribute("adminMovieItemList", movieItemList);
		request.getRequestDispatcher("Movie-list-admin.jsp").forward(request,
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
