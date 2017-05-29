package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BzManagerServlet
 */
@WebServlet("/Bz")
public class BzManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BzManagerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub

    	/* エンコーディング指定 */
    	request.setCharacterEncoding("UTF-8");
    	response.setCharacterEncoding("UTF-8");

    	/* リクエストACTIONの値を取得 */
    	String action = request.getParameter("ACTION");

    	/* セッションが存在するか確認し、なければセッションオブジェクトを取得 */
    	HttpSession session = request.getSession(false);
    	if(session == null) {
    		session = request.getSession(true);
    	}

    	/* 移譲先を格納する変数 */
    	String url = null;

    	/* リクエストACTIONの値を判定し、移譲先をurlに格納 */
    	if(("お客様情報登録").equals(action)) {
    		url = "Insert.jsp";
    	}
    	else if(("メニューに戻る").equals(action)){
    		url = "MainMenu.jsp";
    	}
    	else if(("卓管理").equals(action)){
    		url = "TableMain.jsp";
    	}else if(("カード管理").equals(action)){
    		url = "Card.jsp";
    	}else if(("情報参照").equals(action)){
    		url = "InfoMain.jsp";
    	}else if(("経費").equals(action)){
    		url = "KeihiMain.jsp";
    	}else if(("経費使用").equals(action)){
    		url = "Keihi.jsp";
    	}else if (("売上取得").equals(action)){
    		url = "Earnings.jsp";
    	}


    	/* 指定した移譲先に移譲する */
    	RequestDispatcher rd = request.getRequestDispatcher(url);
    	rd.forward(request, response);
    }

}
