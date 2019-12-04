package com.MovieCruiser.Dao;

import java.util.List;

import com.MovieCruiser.model.MovieItem;

/**
 * @author Lavanya_K
 *
 */

public interface FavouritesDao {
	void addFavouritesItem(long userId, long movieItemId);

	List<MovieItem> getAllFavouritesItem(long userId)
			throws FavouritesEmptyException;

	void removeFavouritesItem(long userId, long movieItemId);

}
