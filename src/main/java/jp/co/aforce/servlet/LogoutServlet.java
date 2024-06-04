package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/views/logoutServlet")
public class LogoutServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		request.setAttribute("message", "ログアウトしました。");
		session.removeAttribute("userId");
		session.removeAttribute("username");
		request.getRequestDispatcher("/views/menu.jsp").forward(request, response);
	}

}
