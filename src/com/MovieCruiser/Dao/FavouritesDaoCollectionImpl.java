package com.MovieCruiser.Dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.MovieCruiser.model.Favourites;
import com.MovieCruiser.model.MovieItem;

/**
 * @author Lavanya_K
 *
 */

public class FavouritesDaoCollectionImpl implements FavouritesDao {
	private static HashMap<Long, Favourites> userFavourites;

	public FavouritesDaoCollectionImpl() {

		if (userFavourites == null) {
			userFavourites = new HashMap<Long, Favourites>();
			try {

				List<MovieItem> movieItemList = new ArrayList<MovieItem>();
				Favourites favourites = new Favourites(movieItemList, 0);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void addFavouritesItem(long userId, long movieItemId) {
		// TODO Auto-generated method stub
		List<MovieItem> movieItemList;
		MovieItemDaoCollectionImpl movieItemDaoCollectionImpl = new MovieItemDaoCollectionImpl();
		MovieItemDao movieItemDao = movieItemDaoCollectionImpl;
		// MenuItem menuitem = menuItemDao.getMenuItem(menuItemId);
		Long userid = new Long(userId);
		MovieItem movieItem = movieItemDao.getMovieItem(movieItemId);
		if (userFavourites.containsKey(userId)) {
			Favourites favourites = userFavourites.get(userId);
			movieItemList = favourites.getMovieItemList();
			movieItemList.add(movieItem);
			favourites.setMovieItemList(movieItemList);
			// cart.setTotal(cart.getTotal() + menuItem.getPrice());
			userFavourites.put(userId, favourites);

		} else {
			movieItemList = new CopyOnWriteArrayList<MovieItem>();
			movieItemList.add(movieItem);

			Favourites favourites = new Favourites(movieItemList,
					movieItem.getBoxOffice());
			userFavourites.put(userId, favourites);

		}

	}

	@Override
	public List<MovieItem> getAllFavouritesItem(long userId)
			throws FavouritesEmptyException {
		// TODO Auto-generated method stub
		Favourites favourites = userFavourites.get(new Long(userId));
		if (favourites == null) {
			throw new FavouritesEmptyException("Favourites is empty");
		}

		List<MovieItem> movieItemList = favourites.getMovieItemList();
		if (movieItemList == null || movieItemList.size() == 0) {
			throw new FavouritesEmptyException("Favourites is empty");
		}
		long total = 0;
		total = total + movieItemList.size();

		favourites.setTotal(total);

		// TODO Auto-generated method stub
		return movieItemList;

	}

	@Override
	public void removeFavouritesItem(long userId, long movieItemId) {
		// TODO Auto-generated method stub
		if (userFavourites.containsKey(userId)) {
			Favourites favourites = userFavourites.get(userId);
			List<MovieItem> movieItemList = favourites.getMovieItemList();
			for (MovieItem movieItem : movieItemList) {
				if (movieItem.getId() == movieItemId) {
					movieItemList.remove(movieItem);
				}
			}
			favourites.setMovieItemList(movieItemList);
			userFavourites.put(userId, favourites);
		}

	}

}
