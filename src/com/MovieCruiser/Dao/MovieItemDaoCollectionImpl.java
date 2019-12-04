package com.MovieCruiser.Dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.MovieCruiser.model.MovieItem;
import com.MovieCruiser.util.DateUtil;

/**
 * @author Lavanya_K
 *
 */

public class MovieItemDaoCollectionImpl implements MovieItemDao {
	static List<MovieItem> movieItemList;

	public MovieItemDaoCollectionImpl() {
		if (movieItemList == null) {
			try {
				movieItemList = new ArrayList<MovieItem>();
				movieItemList.add(new MovieItem(1, "Avatar", 2356787934l, true,
						DateUtil.convertTodate("15/03/2017"),
						"Science Fiction", true));
				movieItemList.add(new MovieItem(2, "The Avengers", 1518812988l,
						true, DateUtil.convertTodate("23/12/2017"),
						"Superhero", false));
				movieItemList.add(new MovieItem(3, "Titanic", 2187463844l,
						true, DateUtil.convertTodate("21/08/2018"), "Romance",
						false));
				movieItemList.add(new MovieItem(4, "Jurrasic World",
						1671713208l, false, DateUtil
								.convertTodate("02/07/2017"),
						"Science Fiction", true));
				movieItemList
						.add(new MovieItem(5, "Avengers: Endgame", 2750760348l,
								true, DateUtil.convertTodate("02/11/2022"),
								"Superhero", true));
			} catch (Exception e) {
				System.out.println(e);

			}
		}
	}

	@Override
	public List<MovieItem> getMovieItemListAdmin() {
		// TODO Auto-generated method stub
		return movieItemList;
	}

	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		// TODO Auto-generated method stub
		List<MovieItem> mpl = new ArrayList<MovieItem>();
		Date today = new Date();
		for (MovieItem movieItem : movieItemList) {
			if (movieItem.getDateOfLaunch().getTime() <= today.getTime()
					&& movieItem.isActive()) {
				mpl.add(movieItem);
			}
		}
		return mpl;
	}

	@Override
	public void modifyMovieItem(MovieItem movieItem) {
		// TODO Auto-generated method stub
		for (MovieItem movie_item_modify : movieItemList) {
			if (movieItem.getId() == movie_item_modify.getId()) {

				movie_item_modify.setTitle(movieItem.getTitle());
				movie_item_modify.setGenre(movieItem.getGenre());
				movie_item_modify.setDateOfLaunch(movieItem.getDateOfLaunch());
				movie_item_modify.setBoxOffice(movieItem.getBoxOffice());
				movie_item_modify.setActive(movieItem.isActive());
				movie_item_modify.setHasTeaser(movieItem.isHasTeaser());

			}
		}
	}

	@Override
	public MovieItem getMovieItem(long movieItemId) {
		// TODO Auto-generated method stub
		for (MovieItem movie_item : movieItemList) {
			if (movieItemId == movie_item.getId()) {
				return movie_item;
			}
		}
		return null;
	}

}
