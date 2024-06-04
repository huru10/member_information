package jp.co.aforce.servlet;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jp.co.aforce.bean.Information;
import jp.co.aforce.dao.LoginDAO;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/views/userupdate")
public class UserUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mail = request.getParameter("mail");
		String zipCode = request.getParameter("zipCode");
		String address = request.getParameter("address");
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");

		// DAOの生成
		LoginDAO dao = new LoginDAO();
		String message = "userId = '" + userId + "'";
		System.out.println(message);
		ArrayList<Information> list = dao.searchSQL(message);
		System.out.println(list);
		for (Information info : list) {
			System.out.println(info.getMail() + " " + info.getZipCode() + " " + info.getAddress());
			if (mail.equals("")) {
				mail = info.getMail();
			}

			if (zipCode.equals("")) {
				zipCode = info.getZipCode();
			}

			if (address.equals("")) {
				address = info.getAddress();
			}

		}
		int count = 0;
		try {
			count = dao.update(mail, zipCode, address, userId);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		if (count > 0) {
			request.setAttribute("message", "会員情報の変更が完了しました。");
			request.getRequestDispatcher("/views/menu.jsp").forward(request, response);
		} else {
			request.setAttribute("message", "会員情報の変更が完了しませんでした。");
			request.getRequestDispatcher("/views/menu.jsp").forward(request, response);
		}
	}

}
