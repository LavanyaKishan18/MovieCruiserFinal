package com.MovieCruiser.Dao;

import java.text.ParseException;
import java.util.List;

import com.MovieCruiser.model.MovieItem;
import com.MovieCruiser.util.DateUtil;

/**
 * @author Lavanya_K
 *
 */

public class MovieItemDaoSqlImplTest {
	public static void main(String args[]) throws ParseException {
		testGetMovieItemlistAdmin();
		testGetMovieItemListCustomer();
		testModifyMenuItem();

	}

	public static void testGetMovieItemlistAdmin() {
		MovieItemDaoSqlImpl movieItemDaoSqlImpl = new MovieItemDaoSqlImpl();
		List<MovieItem> movieItemList = movieItemDaoSqlImpl
				.getMovieItemListAdmin();
		for (MovieItem movieItem : movieItemList) {
			System.out.println("MovieItem:" + movieItem);
		}
	}

	public static void testGetMovieItemListCustomer() {
		MovieItemDaoSqlImpl movieItemDaoSqlImpl = new MovieItemDaoSqlImpl();
		List<MovieItem> movieItemList = movieItemDaoSqlImpl
				.getMovieItemListCustomer();
		for (MovieItem menuItem : movieItemList) {
			System.out.println("MovieItem:" + menuItem);
		}
	}

	public static void testModifyMenuItem() throws ParseException {
		MovieItemDaoSqlImpl movieItemDaoSqlImpl = new MovieItemDaoSqlImpl();
		try {
			MovieItem movieItem = new MovieItem(3, "Thor-DarkWorld",
					2345678901l, false, DateUtil.convertTodate("11/12/2018"),
					"Superhero", true);
			movieItemDaoSqlImpl.modifyMovieItem(movieItem);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// MovieItemDaoSqlImpl movieItemDaoSqlImpl = new MovieItemDaoSqlImpl();
		MovieItem movieItem = movieItemDaoSqlImpl.getMovieItem(3);
		System.out.println("MenuItem:" + movieItem);

	}

}
