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
 * Servlet implementation class LoginServlet
 */

@WebServlet("/views/registarServlet")
public class RegistrationServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String username = request.getParameter("username");
		String fm = request.getParameter("fm");
		int y_birth = Integer.parseInt(request.getParameter("y_birth"));
		int d_birth = Integer.parseInt(request.getParameter("d_birth"));
		String mail = request.getParameter("mail");
		String zipCode = request.getParameter("zipCode");
		String address = request.getParameter("address");
		String pass = request.getParameter("pass");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");

		// ここで会員登録のロジックを実装する

		LoginDAO dao = new LoginDAO();
		int count = 0;
		ArrayList<Information> list = dao.searchAll();
		System.out.println("1");
		boolean flag = true;
		for (Information info : list) {
			System.out.println(info.getMail());
			System.out.println(mail);
			if (info.getMail().equals(mail)) {
				flag = false;
				break;
			}
		}
		if (flag) {
			count = dao.insert(userId, username, fm, y_birth, d_birth, mail, zipCode, address, pass, question, answer);
		}
		String message = null;
		if (count > 0) {
			message = "新規登録が完了しました";
		} else {
			message = "新規登録に失敗しました";
		}
		// 登録が成功した場合は、成功ページにリダイレクトする
		request.setAttribute("errormsg", message);
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		//response.sendRedirect("newuseranswer.jsp");
	}
}
