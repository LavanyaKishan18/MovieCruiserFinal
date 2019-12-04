package com.MovieCruiser.Dao;

import java.util.List;

import com.MovieCruiser.model.MovieItem;

/**
 * @author Lavanya_K
 *
 */

public class FavouritesDaoSqlImplTest {
	public static void main(String[] args) throws FavouritesEmptyException {
		// TODO Auto-generated method stub

		testAddFavouritesItem();
		testRemoveFavouritesItem();
		testGetAllFavouritesItems();

	}

	public static void testAddFavouritesItem() throws FavouritesEmptyException {
		FavouritesDaoSqlImpl favouritesDaoSqlImpl = new FavouritesDaoSqlImpl();
		favouritesDaoSqlImpl.addFavouritesItem(1, 1);
		System.out.println("MovieItem added to the favourites successfully");
	}

	private static void testGetAllFavouritesItems()
			throws FavouritesEmptyException {
		FavouritesDaoSqlImpl favouritesDaoSqlImpl = new FavouritesDaoSqlImpl();
		try {
			List<MovieItem> movieItemList = favouritesDaoSqlImpl
					.getAllFavouritesItem(2);
			System.out.println(movieItemList);
		} catch (FavouritesEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static void testRemoveFavouritesItem()
			throws FavouritesEmptyException {

		FavouritesDaoSqlImpl favouritesDaoSqlImpl = new FavouritesDaoSqlImpl();
		favouritesDaoSqlImpl.removeFavouritesItem(1, 5);
		System.out.println("MovieItem deleted");

	}

}
