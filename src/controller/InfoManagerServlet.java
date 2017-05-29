package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.InfoDAO;
import model.entity.GuestBean;
import model.entity.TableBean;

/**
 * Servlet implementation class InfoManagerServlet
 */
@WebServlet("/DB")
public class InfoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InfoManagerServlet() {
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
		InfoDAO dao = new InfoDAO();

		//System.out.println(action+"ok");
		/* セッションが存在するか確認し、なければセッションオブジェクトを取得 */
		HttpSession session = request.getSession(false);
		if(session == null) {
			session = request.getSession(true);
		}

		/* 移譲先を格納する変数 */
		String url = null;

		/* リクエストACTIONの値を判定し、移譲先をurlに格納 */
		if(("登録").equals(action)){
			String name = request.getParameter("name");
			String kanaName = request.getParameter("kanaName");
			int mg =Integer.parseInt(request.getParameter("mg"));


			try {
				dao.insertGuest(name, kanaName,mg);
				url = "CompInsert.jsp";
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		}
		else if(("スタート！").equals(action)){
			int a = Integer.parseInt(request.getParameter("guestEast"));
			int b = Integer.parseInt(request.getParameter("guestWest"));
			int c = Integer.parseInt(request.getParameter("guestNorth"));
			int d = Integer.parseInt(request.getParameter("guestSouth"));

			//System.out.println(a+"."+b+"."+c+"."+d+".");
			if(a==1){

				try {
					TableBean tb = dao.startTable((String)session.getAttribute("tableNum"), request.getParameter("guestEast"), request.getParameter("guestSouth"), request.getParameter("guestWest"), request.getParameter("guestNorth"));

					String s="Table"+(String)session.getAttribute("tableNum");
					session.setAttribute(s, tb);


				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				url = "TableGameNow.jsp";
			}
			else if(a != b && a!=c && a!=d && b!=c && b!=d && c!=d){
				try {
					TableBean tb = dao.startTable((String)session.getAttribute("tableNum"), request.getParameter("guestEast"), request.getParameter("guestSouth"), request.getParameter("guestWest"), request.getParameter("guestNorth"));

					String s="Table"+(String)session.getAttribute("tableNum");
					session.setAttribute(s, tb);


				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				url="TableGameNow.jsp";
			}
			else{
				url="TableMain.jsp";
			}

		}else if(("ラスト！").equals(action)){
			String s="Table"+(String)session.getAttribute("tableNum");
			TableBean tb = (TableBean)session.getAttribute(s);
			if(tb.getEast()!=1){
			try {
				dao.Last(tb);
				//dao.accountControl(5, 0, 2200);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			//if(session.getAttribute(s)==null)System.out.println("ok!");
			url = "Last.jsp";
			}
			else{
				int set = 0;
				try {
					set = dao.LastSet(tb);
					set = (int)((double)set*0.01);
					set = set * 100;
					dao.debt(-set, 1);
					//dao.accountControl(6,0, set);
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
				session.setAttribute("set", set);
				session.removeAttribute(s);
				url = "LastSet.jsp";
			}
		}
		else if(("ゲーム中止").equals(action)){
			String s="Table"+(String)session.getAttribute("tableNum");
			TableBean tb = (TableBean)session.getAttribute(s);

			try {
				dao.deleteGame(tb);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

			session.removeAttribute(s);

			url = "TableMain.jsp";
		}
		else if(("続行").equals(action)||("卓割れ").equals(action)){
			String s="Table"+(String)session.getAttribute("tableNum");
			TableBean tb = (TableBean)session.getAttribute(s);
			try {
				dao.setRank(Integer.parseInt(request.getParameter("top")),Integer.parseInt(request.getParameter("las")), dao.getGameTime(tb));
			} catch (NumberFormatException e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			} catch (Exception e1) {
				// TODO 自動生成された catch ブロック
				e1.printStackTrace();
			}
			if(("続行").equals(action)){
				int id = tb.getEast();
				tb.setEast(tb.getSouth());
				tb.setSouth(tb.getWest());
				tb.setWest(tb.getNorth());
				tb.setNorth(id);

				try {
					tb = dao.startTable((String)session.getAttribute("tableNum"), String.valueOf(tb.getEast()), String.valueOf(tb.getSouth()), String.valueOf(tb.getWest()), String.valueOf(tb.getNorth()));
				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				session.setAttribute(s, tb);
				url = "TableGameNow.jsp";
			}
			else{

				session.removeAttribute(s);
				url = "TableGame.jsp";
			}
		}
		else if(("カード買入れ").equals(action)){
			try {
				ArrayList<GuestBean> member = dao.getMember();
				session.setAttribute("member"+session.getAttribute("tableNum"), member);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "BuyTheCard.jsp";
		}
		else if(("買入れ").equals(action)){
			int id = Integer.parseInt(request.getParameter("guest"));
			int amount = 10000*Integer.parseInt(request.getParameter("amount_man"))+1000*Integer.parseInt(request.getParameter("amount_senn"))+100*Integer.parseInt(request.getParameter("amount_hyaku"));
			try {
				dao.buyTheCard(amount,id);
				//dao.accountControl(3, id, amount);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "Card.jsp";
		}
		else if(("アウト").equals(action)){
			try {
				ArrayList<GuestBean> member = dao.getMember();
				session.setAttribute("member"+session.getAttribute("tableNum"), member);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "Out.jsp";
		}
		else if(("出金").equals(action)){
			int id = Integer.parseInt(request.getParameter("guest"));
			int amount = 10000*Integer.parseInt(request.getParameter("amount_man"))+1000*Integer.parseInt(request.getParameter("amount_senn"))+100*Integer.parseInt(request.getParameter("amount_hyaku"));
			try {
				dao.debt(amount,id);
				//dao.accountControl(2, id, amount);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "Card.jsp";
		}
		else if(("精算/入金").equals(action)){
			try {
				ArrayList<GuestBean> member = dao.getMember();
				session.setAttribute("member"+session.getAttribute("tableNum"), member);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "PayOff.jsp";
		}
		else if(("精算・入金").equals(action)){
			int id = Integer.parseInt(request.getParameter("guest"));
			int amount_s = 10000*Integer.parseInt(request.getParameter("amount_man_s"))+1000*Integer.parseInt(request.getParameter("amount_senn_s"))+100*Integer.parseInt(request.getParameter("amount_hyaku_s"));
			int amount_n = 10000*Integer.parseInt(request.getParameter("amount_man_n"))+1000*Integer.parseInt(request.getParameter("amount_senn_n"))+100*Integer.parseInt(request.getParameter("amount_hyaku_n"));
			try {
				dao.payOff(-amount_n, amount_s,id);
				//dao.accountControl(4, id, -amount_s);
				//dao.accountControl(1, id, amount_n);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "Card.jsp";
		}
		else if(("役満").equals(action)){
			try {
				ArrayList<GuestBean> member = dao.getMember();
				session.setAttribute("member"+session.getAttribute("tableNum"), member);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "Yakuman.jsp";
		}
		else if(("祝儀").equals(action)){
			//System.out.println("ok");
			int id = Integer.parseInt(request.getParameter("guest"));
			try {
				dao.yakuman(id, request.getParameter("yaku"));
				//dao.accountControl(7, id, -1000);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "MainMenu.jsp";
		}
		else if(("アウト情報").equals(action)){
			try {
				ArrayList<GuestBean> member = dao.getMember();
				session.setAttribute("member"+session.getAttribute("tableNum"), member);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "OutInfo.jsp";
		}
		else if(("アウト情報表示").equals(action)){
			try {
				ArrayList<GuestBean> member = dao.getMember();
				session.setAttribute("member"+session.getAttribute("tableNum"), member);
				int id = Integer.parseInt(request.getParameter("guest"));
				String html = dao.outInfo(id);
				//System.out.println(html);
				session.setAttribute("html", html);
				session.setAttribute("id",id);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "OutInfoTable.jsp";
		}
		else if(("ゲーム表　＆　入出金表").equals(action)){
			try {
				String html = dao.AllInfo();
				//System.out.println(html);
				session.setAttribute("html_Info", html);

			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "AllInfo.jsp";
		}
		else if(("金庫内金額参照").equals(action)){
			try{
				String html = "";

				html += dao.getSafeInfo();
				session.setAttribute("html", html);

			}catch(Exception e){

			}
			url = "SafeInfo.jsp";
		}else if(("経費使用").equals(action)){

			int amount = 10000*Integer.parseInt(request.getParameter("amount_man"))+1000*Integer.parseInt(request.getParameter("amount_senn"))+100*Integer.parseInt(request.getParameter("amount_hyaku"));
			try {
				dao.insertKeihi(amount);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "MainMenu.jsp";
		}else if(("売上取得").equals(action)){
			int amount = 10000*Integer.parseInt(request.getParameter("amount_man"))+1000*Integer.parseInt(request.getParameter("amount_senn"))+100*Integer.parseInt(request.getParameter("amount_hyaku"));
			try {
				dao.insertEarnings(amount);
			} catch (Exception e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			url = "MainMenu.jsp";
		}else if("みんなの成績".equals(action)){
			try{
				int seiseki[];
				seiseki=dao.seiseki();
				String a=dao.getName(seiseki[0]);
				String b=dao.getName(seiseki[2]);
				String c=dao.getName(seiseki[4]);
				String rankname[] = {a,b,c};
				a=String.valueOf(seiseki[1]);
				b=String.valueOf(seiseki[3]);
				c=String.valueOf(seiseki[5]);
				String ranknum[]={a,b,c};

				session.setAttribute("rankname", rankname);
				session.setAttribute("seiseki",ranknum);
			}catch(Exception e){
				e.printStackTrace();
			}
			url="TopRanker.jsp";
		}






		if(dao.isNumber(action)){
			if(0<Integer.parseInt(action)&&6>Integer.parseInt(action)){
				session.setAttribute("tableNum", request.getParameter("ACTION"));
				try {
					ArrayList<GuestBean> member = dao.getMember();

					session.setAttribute("member"+session.getAttribute("tableNum"), member);

				} catch (Exception e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}

				if(session.getAttribute("Table"+request.getParameter("ACTION"))==null){
					url = "TableGame.jsp";
				}else{
					url = "TableGameNow.jsp";
				}
			}
		}

		//System.out.println(url);
		/* 指定した移譲先に移譲する */
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}
