package com.MovieCruiser.Dao;

import java.util.List;

import com.MovieCruiser.model.MovieItem;

/**
 * @author Lavanya_K
 *
 */

public class FavouritesDaoCollectionImplTest {
	public static void main(String[] args) throws FavouritesEmptyException {
		// TODO Auto-generated method stub

		testAddFavouritesItem();
		testRemoveFavouritesItem();
		testGetAllFavouritesItems();

	}

	static void testAddFavouritesItem() throws FavouritesEmptyException {

		FavouritesDaoCollectionImpl favouritesDaoCollectionImpl = new FavouritesDaoCollectionImpl();
		FavouritesDao favouritesDao = favouritesDaoCollectionImpl;
		favouritesDao.addFavouritesItem(2, 4);
		favouritesDao.addFavouritesItem(2, 3);
		List<MovieItem> movieItemList = favouritesDao.getAllFavouritesItem(2);
		System.out.println("MovieItem list :" + movieItemList);

	}

	static void testGetAllFavouritesItems() throws FavouritesEmptyException {
		FavouritesDaoCollectionImpl favouritesDaoCollectionImpl = new FavouritesDaoCollectionImpl();
		FavouritesDao favouritesDao = favouritesDaoCollectionImpl;
		List<MovieItem> movieItemList = favouritesDao.getAllFavouritesItem(2);
		System.out.println("MovieItem list :" + movieItemList);
	}

	static void testRemoveFavouritesItem() throws FavouritesEmptyException {
		FavouritesDaoCollectionImpl favouritesDaoCollectionImpl = new FavouritesDaoCollectionImpl();
		FavouritesDao favouritesDao = favouritesDaoCollectionImpl;
		try {
			favouritesDao.removeFavouritesItem(2, 4);
			List<MovieItem> movieItemList = favouritesDao
					.getAllFavouritesItem(2);
			System.out.println("MovieItem list after removed:" + movieItemList);
		} catch (Exception e) {
			throw new FavouritesEmptyException("Favourites is empty");
		}

	}

}
