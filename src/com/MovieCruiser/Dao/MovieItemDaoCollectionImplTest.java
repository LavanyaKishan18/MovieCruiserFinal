package com.MovieCruiser.Dao;

import java.text.ParseException;
import java.util.List;

import com.MovieCruiser.model.MovieItem;
import com.MovieCruiser.util.DateUtil;

/**
 * @author Lavanya_K
 *
 */

public class MovieItemDaoCollectionImplTest {
	public static void main(String args[]) throws ParseException {
		testGetMovieItemlistAdmin();
		testGetMovieItemListCustomer();
		testModifyMenuItem();

	}

	public static void testGetMovieItemlistAdmin() {
		MovieItemDaoCollectionImpl MovieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> movieItems = MovieItemDao.getMovieItemListAdmin();
		for (MovieItem movieItem : movieItems) {
			System.out.println(movieItem.toString());
		}
	}

	public static void testGetMovieItemListCustomer() {
		MovieItemDaoCollectionImpl MovieItemDao = new MovieItemDaoCollectionImpl();
		List<MovieItem> movieItems = MovieItemDao.getMovieItemListCustomer();
		for (MovieItem movieItem : movieItems) {
			System.out.println(movieItem.toString());
		}

	}

	public static void testModifyMenuItem() throws ParseException {
		MovieItemDaoCollectionImpl movieitemcollectionimpl = new MovieItemDaoCollectionImpl();
		MovieItem movieItem = new MovieItem(2, "Titanic", 2187463844l, true,
				DateUtil.convertTodate("21/08/2018"), "Romance", false);
		MovieItemDao movieitemdao = movieitemcollectionimpl;
		movieitemdao.modifyMovieItem(movieItem);
		System.out.println("Modify Movie Item : "
				+ movieitemdao.getMovieItem(2));

	}

}
