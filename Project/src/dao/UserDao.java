package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDao {

	//ログインIDとパスワードをもとにIDとname情報を返す
	public User findByLoginInfo(String loginId, String password) {
		Connection conn = null;
		try {
			//データベースに接続
			conn = DBManager.getConnection();

			//SELECT文を準備
			String sql = "SELECT* FROM user WHERE login_id = ? and password = ?";

			//SELECTを実行し結果を取得
			PreparedStatement pStmt = conn.prepareStatement(sql);
			pStmt.setString(1, loginId);
			pStmt.setString(2, password);
			ResultSet rs = pStmt.executeQuery();

			//IDとpasswordが一致するユーザーがいない場合nullを返す
			if(!rs.next()) {
				return null;
			}

			//取得した結果のIDとnameを有するインストラクタを返す
			String loginIdData = rs.getString("login_id");
			String nameData = rs.getString("name");
			return new User(loginIdData, nameData);
		}
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {

			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
	}

	//すべてのユーザ情報を取得
	public List<User> findAll(){
		Connection conn = null;
		List<User> userList = new ArrayList<User>();

		try {
			//データベースに接続
			conn = DBManager.getConnection();

			//SELECT文を準備
			//TODO:　未実装：　管理者以外を取得するようSQLを変更する
			String sql = "SELECT* FROM USER";

			//SELECT分を実行し結果を取得
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			//取得した情報をUserインスタンスに設定しArrayListインスタンスに追加
			while(rs.next()) {
				int id = rs.getInt("id");
				String loginId = rs.getString("login_id");
				String name = rs.getString("name");
				Date birthday = rs.getDate("birth_date");
				String password = rs.getString("password");
				String createDate = rs.getString("create_date");
				String updateDate = rs.getString("update_date");
				User user = new User(id, loginId, name, birthday, password, createDate, updateDate);

				userList.add(user);
			}
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			//データベース切断
			if(conn != null) {
				try {
					conn.close();
				}catch(SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return userList;
	}
}
