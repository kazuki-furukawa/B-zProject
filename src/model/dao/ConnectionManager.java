package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベース管理クラス
 */
public class ConnectionManager {

	// URL・ユーザ名・パスワードの設定
	private final static String URL = "jdbc:mysql://localhost:3306/bz_db";
	private final static String USER = "root";
	private final static String PASSWORD = "root";

	private Connection connection = null;

	private static ConnectionManager instance = new ConnectionManager();

	/**
	 * コンストラクタ.
	 */
	private ConnectionManager() {
	}

	protected static synchronized ConnectionManager getInstance() {
		return instance;
	}

	/**
	 * DBの接続.
	 *
	 * @return コネクション
	 * @throws Exception
	 */
	public Connection getConnection() throws Exception {

		String drv = "com.mysql.jdbc.Driver";
		try {
			// JDBCドライバのロード
			Class.forName(drv);
		} catch(ClassNotFoundException e) {
			System.out.println("ドライバがありません" + e.getMessage());
		}

		try {
			// ロードに失敗した場合の例外処理
			if (connection == null || connection.isClosed()) {
				connection = DriverManager.getConnection(URL, USER, PASSWORD);
			}
		} catch (Exception e) {
			e.printStackTrace();
			connection = null;
			throw e;
		}

		return connection;
	}

	/**
	 * DBの切断.
	 */
	public void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection = null;
		}
	}
}