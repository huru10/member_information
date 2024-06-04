package jp.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jp.co.aforce.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */

@WebServlet("/views/passupdate")
public class PassUpdateServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mail = request.getParameter("mail");
		String question = request.getParameter("question");
		String answer = request.getParameter("answer");
		String pass = request.getParameter("pass");
		String passcheck = request.getParameter("passcheck");

		System.out.println(mail + " " + question + " " + answer + " " + pass + " " + passcheck);

		// DAOの生成
		LoginDAO dao = new LoginDAO();
		// Beanの生成

		int check = 0;
		try {
			check = dao.updatePassword(mail, question, answer, pass, passcheck);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if (check == 0) {
			request.setAttribute("errormsg", "パスワードの変更が完了しました。");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		} else if (check == 1) {
			request.setAttribute("errormsg", "パスワードの値が一致しませんでした。");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		} else {
			request.setAttribute("errormsg", "入力されたアカウントがみつかりませんでした。");
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		}
	}

}
