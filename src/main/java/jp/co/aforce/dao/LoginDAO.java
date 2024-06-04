package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import jp.co.aforce.bean.Information;

public class LoginDAO extends DAO {

	public String search(String userId, String password) throws Exception { //ログイン時に使うサーチ機能

		Information info = null;

		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement(
				"SELECT * FROM informations WHERE userId= ? and pass= ?");
		st.setString(1, userId);
		st.setString(2, password);
		System.out.println(userId + " : " + password);
		ResultSet rs = st.executeQuery();

		int count = 0;
		if (rs.next()) {
			info = new Information();
			info.setUsername(rs.getString("name"));
			count++;
		}

		String rtn = null;
		if (count != 0) {
			rtn = info.getUsername();
		}
		System.out.println(rtn);
		st.close();
		con.close();
		return rtn;

	}

	public ArrayList<Information> searchSQL(String message) { //特定のデータでユーザー検索を行う機能

		Connection con;
		ArrayList<Information> infoList = new ArrayList<Information>();
		try {
			con = getConnection();
			PreparedStatement st;
			st = con.prepareStatement(
					"SELECT * FROM informations WHERE " + message + " ;");
			//st.setString(1, message);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Information info = new Information();
				System.out.println(rs.getString("userId"));
				info.setUserId(rs.getString("userId"));
				info.setUsername(rs.getString("name"));
				info.setFm(rs.getString("fm"));
				info.setY_birth(rs.getInt("y_birth"));
				info.setD_birth(rs.getInt("d_birth"));
				info.setMail(rs.getString("mail"));
				info.setZipCode(rs.getString("yuubin"));
				info.setAddress(rs.getString("city"));
				info.setPass(rs.getString("pass"));
				info.setQuestion(rs.getString("question"));
				info.setAnswer(rs.getString("answer"));
				infoList.add(info);
			}
			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return infoList;

	}

	public ArrayList<Information> searchAll() { //DBに入っている全ユーザー情報を取得

		ArrayList<Information> infoList = new ArrayList<Information>();
		Connection con;
		try {
			con = getConnection();

			PreparedStatement st;
			st = con.prepareStatement(
					"SELECT * FROM informations ;");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Information info = new Information();
				System.out.println(rs.getString("userId"));
				info.setUserId(rs.getString("userId"));
				info.setUsername(rs.getString("name"));
				info.setFm(rs.getString("fm"));
				info.setY_birth(rs.getInt("y_birth"));
				info.setD_birth(rs.getInt("d_birth"));
				info.setMail(rs.getString("mail"));
				info.setZipCode(rs.getString("yuubin"));
				info.setAddress(rs.getString("city"));
				info.setPass(rs.getString("pass"));
				info.setQuestion(rs.getString("question"));
				info.setAnswer(rs.getString("answer"));
				infoList.add(info);
			}

			rs.close();
			st.close();
			con.close();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return infoList;

	}

	public int insert(String userId, String username, String fm, int y_birth, int d_birth, String mail, String zipCode,
			String address, String pass, String question, String answer) { //ユーザー新規登録
		// TODO 自動生成されたメソッド・スタブ
		int count = 0;
		System.out.println("2");

		Connection con;
		try {
			con = getConnection();
			PreparedStatement st;
			st = con.prepareStatement(
					"INSERT INTO informations  VALUES(?,?,?,?,?,?,?,?,?,?,?) ;");
			st.setString(1, userId);
			st.setString(2, username);
			st.setString(3, fm);
			st.setInt(4, y_birth);
			st.setInt(5, d_birth);
			st.setString(6, mail);
			st.setString(7, zipCode);
			st.setString(8, address);
			st.setString(9, pass);
			st.setString(10, question);
			st.setString(11, answer);
			count = st.executeUpdate();
			System.out.println("3");

			st.close();
			con.close();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return count;

	}

	public int updatePassword(String mail, String question, String answer, String pass, String passcheck) //質問を元にパスワードを変更する
			throws Exception {
		int check = 0;
		System.out.println(mail + " " + question + " " + answer + " " + pass + " " + passcheck);
		if (!pass.equals(passcheck)) {
			check = 1;
		} else {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(
					"SELECT * FROM informations WHERE mail= ? and question = ? and answer = ?;");
			st.setString(1, mail);
			st.setString(2, question);
			st.setString(3, answer);
			ResultSet rs = st.executeQuery();

			int count = 0;
			if (rs.next()) {
				st = con.prepareStatement(
						"UPDATE informations SET pass = ? WHERE  mail= ? ;");
				st.setString(1, pass);
				st.setString(2, mail);
				count = st.executeUpdate();
			}

			if (count == 0) {
				check = 2;
			}
			rs.close();
			st.close();
			con.close();

		}

		return check;
	}

	public int update(String mail, String zipCode, String address, String userId) //設定されているユーザー情報を更新する
			throws Exception {
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(
				"UPDATE informations SET mail = ? , yuubin = ? , city = ? WHERE  userId= ? ;");
		st.setString(1, mail);
		st.setString(2, zipCode);
		st.setString(3, address);
		st.setString(4, userId);
		int count = 0;
		count = st.executeUpdate();

		st.close();
		con.close();
		return count;

	}

	public int delete(String userId) { //ユーザー退会
		// TODO 自動生成されたメソッド・スタブ
		int count = 0;
		System.out.println("2");

		Connection con;
		try {
			con = getConnection();
			PreparedStatement st;
			st = con.prepareStatement(
					"DELETE FROM informations WHERE userId = ? ;");
			st.setString(1, userId);
			count = st.executeUpdate();
			System.out.println("3");

			st.close();
			con.close();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return count;

	}

}