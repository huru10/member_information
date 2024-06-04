package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/views/loginServlet")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("/MemberInformation/views/login.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");

		System.out.println(userId + " : " + password);
		// DAOの生成
		LoginDAO dao = new LoginDAO();
		// Beanの生成
		HttpSession session = request.getSession();

		String username = null;
		try {
			username = dao.search(userId, password);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println(username);
		if (username != null && !username.equals("")) {
			session.setAttribute("username", username);
			session.setAttribute("userId", userId);
			request.getRequestDispatcher("/views/menu.jsp").forward(request, response);
		} else {
			request.setAttribute("errormsg", "ユーザーIDもしくはパスワードが違います。");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

}
