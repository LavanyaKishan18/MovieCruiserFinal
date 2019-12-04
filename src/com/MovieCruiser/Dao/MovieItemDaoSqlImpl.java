package com.MovieCruiser.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * @author Lavanya_K
 *
 */

import com.MovieCruiser.model.MovieItem;

public class MovieItemDaoSqlImpl implements MovieItemDao {
	@Override
	public List<MovieItem> getMovieItemListAdmin() {
		// TODO Auto-generated method stub
		ConnectionHandler ch = new ConnectionHandler();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<MovieItem> movieItemList = new ArrayList<MovieItem>();
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		try {
			conn = ch.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select mo_id,mo_title,mo_active,mo_date_of_launch,mo_box_office,mo_genre,mo_has_teaser from movie");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					int id = resultSet.getInt("mo_id");
					String title = resultSet.getString("mo_title");
					Date dateOfLaunch = resultSet.getDate("mo_date_of_launch");
					String active = resultSet.getString("mo_active");
					long box_office = resultSet.getLong("mo_box_office");
					String genre = resultSet.getString("mo_genre");
					String hasTeaser = resultSet.getString("mo_has_teaser");
					if (hasTeaser != null && hasTeaser.equals("Yes")) {
						hasTeaserFlag = true;
					} else {
						hasTeaserFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					MovieItem movieItem = new MovieItem(id, title, box_office,
							activeFlag, dateOfLaunch, genre, hasTeaserFlag);
					/*
					 * emp1.setEmployee_id(empid); emp1.setName(name);
					 * emp1.setDate_of_birth(date); emp1.setSalary(sal);
					 */
					System.out.println(movieItem);
					movieItemList.add(movieItem);
				}
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

		return movieItemList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItemListCustomer()
	 */
	@Override
	public List<MovieItem> getMovieItemListCustomer() {
		// TODO Auto-generated method stub
		ConnectionHandler ch = new ConnectionHandler();
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		List<MovieItem> movieItemList = new ArrayList<MovieItem>();
		ResultSet resultSet;
		boolean activeFlag, hasTeaserFlag;
		try {
			conn = ch.getConnection();
			if (conn != null) {
				preparedStatement = conn
						.prepareStatement("select * from movie where mo_date_of_launch <= now() and mo_active='Yes'");
				resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					int id = resultSet.getInt(1);
					String title = resultSet.getString(2);
					Date dateOfLaunch = resultSet.getDate(5);
					String active = resultSet.getString(4);
					Long boxOffice = resultSet.getLong(3);
					String genre = resultSet.getString(6);
					String hasTeaser = resultSet.getString(7);
					if (hasTeaser != null && hasTeaser.equals("Yes")) {
						hasTeaserFlag = true;
					} else {
						hasTeaserFlag = false;
					}
					if (active != null && active.equals("Yes")) {
						activeFlag = true;
					} else {
						activeFlag = false;
					}
					MovieItem movieItem = new MovieItem(id, title, boxOffice,
							activeFlag, dateOfLaunch, genre, hasTeaserFlag);
					/*
					 * emp1.setEmployee_id(empid); emp1.setName(name);
					 * emp1.setDate_of_birth(date); emp1.setSalary(sal);
					 */
					System.out.println(movieItem);
					movieItemList.add(movieItem);
				}
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

		return movieItemList;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cognizant.truyum.dao.MenuItemDao#modifyMenuItem(com.cognizant.truyum
	 * .model.MenuItem)
	 */
	@Override
	public void modifyMovieItem(MovieItem movie) {
		// TODO Auto-generated method stub
		Connection conn = ConnectionHandler.getConnection();
		String sql = "update movie set mo_title=?,mo_box_office=?,mo_active=?,mo_date_of_launch=?,mo_has_teaser=?,mo_genre=? where mo_id=?";
		try {
			if (conn != null) {
				PreparedStatement preparedStatement = conn
						.prepareStatement(sql);
				preparedStatement.setString(1, movie.getTitle());
				preparedStatement.setLong(2, movie.getBoxOffice());
				if (movie.isActive()) {
					preparedStatement.setString(3, "Yes");
				} else {
					preparedStatement.setString(3, "No");
				}
				preparedStatement.setDate(4, new java.sql.Date(movie
						.getDateOfLaunch().getTime()));

				if (movie.isHasTeaser()) {
					preparedStatement.setString(5, "Yes");
				} else {
					preparedStatement.setString(5, "No");
				}
				preparedStatement.setString(6, movie.getGenre());
				preparedStatement.setLong(7, movie.getId());
				preparedStatement.executeUpdate();

			}
		} catch (SQLException sq) {
			sq.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cognizant.truyum.dao.MenuItemDao#getMenuItem(long)
	 */
	@Override
	public MovieItem getMovieItem(long movieItemId) {
		// TODO Auto-generated method stub
		ConnectionHandler ch = new ConnectionHandler();
		Connection connection = ch.getConnection();
		PreparedStatement preparedStatement;
		ResultSet resultSet;
		MovieItem movieItem = null;
		if (connection != null) {
			try {
				preparedStatement = connection
						.prepareStatement("select * from movie where mo_id=?");
				preparedStatement.setLong(1, movieItemId);

				resultSet = preparedStatement.executeQuery();
				boolean activeFlag, hasTeaserFlag;
				Date date_of_launch;
				while (resultSet.next()) {
					String title = resultSet.getString(2);
					long boxOffice = resultSet.getLong(3);
					String active = resultSet.getString(4);
					date_of_launch = resultSet.getDate(5);
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
		return movieItem;

	}

}
