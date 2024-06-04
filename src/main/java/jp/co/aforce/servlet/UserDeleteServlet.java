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

@WebServlet("/views/userdeleteServlet")
public class UserDeleteServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		String userId = (String) session.getAttribute("userId");
		System.out.println(userId);
		LoginDAO dao = new LoginDAO();
		int count = dao.delete(userId);
		String message;
		if (count > 0) {
			message = "アカウントを削除しました。";
		} else {
			message = "アカウントの削除に失敗しました。";
		}
		session.removeAttribute("userId");
		session.removeAttribute("username");
		request.setAttribute("message", message);
		request.getRequestDispatcher("/views/menu.jsp").forward(request, response);
	}

}
