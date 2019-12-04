package com.MovieCruiser.model;

import java.util.List;

/**
 * @author Lavanya_K
 *
 */

public class Favourites {

	private List<MovieItem> movieItemList;
	private long total;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((movieItemList == null) ? 0 : movieItemList.hashCode());
		result = prime * result + (int) (total ^ (total >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Favourites other = (Favourites) obj;
		if (movieItemList == null) {
			if (other.movieItemList != null)
				return false;
		} else if (!movieItemList.equals(other.movieItemList))
			return false;
		if (total != other.total)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Favourites [movieItemList=" + movieItemList + ", total="
				+ total + "]";
	}

	public Favourites(List<MovieItem> movieItemList, long total) {
		super();
		this.movieItemList = movieItemList;
		this.total = total;
	}

	public List<MovieItem> getMovieItemList() {
		return movieItemList;
	}

	public void setMovieItemList(List<MovieItem> movieItemList) {
		this.movieItemList = movieItemList;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}
}
