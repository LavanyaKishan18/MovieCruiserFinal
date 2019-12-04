package com.MovieCruiser.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.MovieCruiser.model.Favourites;
import com.MovieCruiser.model.MovieItem;

/**
 * @author Lavanya_K
 *
 */

public class FavouritesDaoSqlImpl implements FavouritesDao {
	public void addFavouritesItem(long userId, long movieItemId) {
		// TODO Auto-generated method stub

		Connection conn = ConnectionHandler.getConnection();
		PreparedStatement preparedStatement = null;

		try {
			if (conn != null) {

				preparedStatement = conn
						.prepareStatement("insert into favourites values(default,?,?)");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieItemId);
				System.out.println("userId: " + userId + " movieItemId: "
						+ movieItemId);
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void removeFavouritesItem(long userId, long movieItemId) {
		// TODO Auto-generated method stub

		Connection connection = null;
		PreparedStatement preparedStatement;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {
				preparedStatement = connection
						.prepareStatement("delete from favourites where fv_us_id=? and  fv_pr_id=?");
				preparedStatement.setLong(1, userId);
				preparedStatement.setLong(2, movieItemId);
				preparedStatement.executeUpdate();
				System.out.println("Record deleted successfully");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public List<MovieItem> getAllFavouritesItem(long userId)
			throws FavouritesEmptyException {
		// TODO Auto-generated method stub
		Connection connection = null;
		List<MovieItem> movieItemList = new ArrayList<MovieItem>();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;

		MovieItem movieItem = null;
		try {
			connection = ConnectionHandler.getConnection();
			if (connection != null) {

				Favourites favourites = new Favourites(movieItemList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT movie.mo_id, movie.mo_title  , movie.mo_box_office ,movie.mo_active,movie.mo_date_of_launch,movie.mo_genre, movie.mo_has_teaser FROM movie ")
						.append("INNER JOIN favourites ON movie.mo_id = favourites.fv_pr_id WHERE favourites.fv_us_id = ?");
				// System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = connection.prepareStatement(sqlBuffer
						.toString());

				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();

				while (resultSet.next()) {
					int movieItemId = resultSet.getInt(1);
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					Date date_of_launch = resultSet.getDate(5);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);

					if (active != null && active.equals("Yes"))
						activeFlag = true;
					else
						activeFlag = false;
					if (hasTeaser != null && hasTeaser.equals("Yes"))
						hasTeaserFlag = true;
					else
						hasTeaserFlag = false;
					movieItem = new MovieItem(movieItemId, title, boxOffice,
							activeFlag, date_of_launch, genre, hasTeaserFlag);
					movieItemList.add(movieItem);
					System.out.println("added item:" + movieItem);
				}
				favourites.setMovieItemList(movieItemList);
				favourites.setTotal(getFavouritesCount(userId, connection));
				System.out.println("Records fetched successfully");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (movieItemList.size() == 0) {
			throw new FavouritesEmptyException("Favourites is Empty");
		}

		return movieItemList;

	}

	private long getFavouritesCount(long userId, Connection conn) {
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		long noOfFavourites = 0;
		List<MovieItem> movieItemList = new ArrayList<MovieItem>();
		try {
			if (conn != null) {
				Favourites favourites = new Favourites(movieItemList, 0);
				StringBuffer sqlBuffer = new StringBuffer();
				sqlBuffer
						.append("SELECT count(movie.mo_id) FROM movie INNER JOIN favourites ON movie.mo_id = favourites.fv_pr_id ")
						.append("WHERE favourites.fv_us_id = ?");
				// System.out.println("SqlString:" + sqlBuffer.toString());

				preparedStatement = conn.prepareStatement(sqlBuffer.toString());
				preparedStatement.setLong(1, userId);
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					noOfFavourites = resultSet.getLong(1);
				}
				System.out.println("Number of Favourites has been changed ");
			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return noOfFavourites;
	}

}
