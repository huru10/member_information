package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.aforce.bean.Information;
import jp.co.aforce.dao.LoginDAO;

/**
 * Servlet implementation class Test
 */
@WebServlet("/views/test")
public class Test extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		LoginDAO dao = new LoginDAO();
		ArrayList<Information> list = new ArrayList<Information>();
		list = dao.searchAll();
		for (Information info : list) {
			System.out.println(info.getMail());
		}
	}

}
