package com.app.dao;

public class DAOFactory {
	public static DAO getInstance() {
		return new DAOImpl();
	}
}
