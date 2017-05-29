package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.entity.GuestBean;
import model.entity.TableBean;

public class InfoDAO {

	public void insertGuest(String name, String kanaName, int mg) throws Exception{
		String sql = "insert into guest (name, kana_name, mg) values ('"+ name +"','"+ kanaName +"',"+mg+" )";


		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
	}

	public void accountControl(int code,int id, int amount)throws Exception {

		String sql = "insert into safe (code,amount,ymdhms) values ("+code+","+amount+",now())";
		if(id!=0){
			sql = "insert into safe (code,id,amount,ymdhms) values ("+code+","+id+","+amount+",now())";
		}

		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
	}

	public void insertKeihi(int x)throws Exception{
		String sql = "insert into keihi (keihi, ymdhms) values ("+x+",now())";

		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
	}

	public void insertEarnings(int x)throws Exception{
		String sql = "insert into earnings (earnings, ymdhms) values ("+x+",now())";

		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
	}

	public ArrayList<GuestBean> getMember() throws Exception{
		ArrayList<GuestBean> member = new ArrayList<GuestBean>();

		String sql = "select id, name, kana_name from guest order by kana_name asc";
		ConnectionManager cm = ConnectionManager.getInstance();

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();


			while(rs.next()){
				GuestBean gb = new GuestBean();
				gb.setId(rs.getInt(1));
				gb.setName(rs.getString(2));
				member.add(gb);
			}
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}

		for(int i = 0 ; i<member.size();i++){
			if(member.get(i).getId()==1){
				GuestBean gb=member.get(i);
				member.remove(i);
				member.add(0,gb);
				break;
			}
		}

		return member;
	}

	public void deleteGame(TableBean tb) throws Exception{
		ConnectionManager cm = ConnectionManager.getInstance();
		String sql1 = "select max(start_time) from gameset where table_num = "+tb.getTableNum()+" order by table_num";
		String sql2 = "delete from gameset where start_time = '?' and table_num = "+tb.getTableNum();

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt1 =  con.prepareStatement(sql1);

			ResultSet rs = pstmt1.executeQuery();

			while(rs.next()){
				//System.out.println(rs.getString(1));
				sql2 = "delete from gameset where start_time = '"+rs.getString(1)+"' and table_num = "+tb.getTableNum();
			}
			PreparedStatement pstmt2 =  con.prepareStatement(sql2);
			pstmt2.executeUpdate();

		}
		catch(SQLException e){

		}
	}

	public String getName(int id) throws Exception{
		String sql = "select name from guest where id ="+id;
		ConnectionManager cm = ConnectionManager.getInstance();
		String name = new String();
		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();


			while(rs.next()){

				name = rs.getString(1);

			}
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}

		return name;
	}

	public TableBean startTable(String tableNum, String guesteast, String guestsouth, String guestwest, String guestnorth ) throws Exception{
		String sql = "insert into gameset (table_num, east, south, west, north, start_time) values ("+tableNum+ ","+guesteast+","+guestsouth+","+guestwest+","+guestnorth+",NOW() )";
		TableBean tb = new TableBean();

		tb.setTableNum(Integer.parseInt(tableNum));
		tb.setEast(Integer.parseInt(guesteast));
		tb.setSouth(Integer.parseInt(guestsouth));
		tb.setWest(Integer.parseInt(guestwest));
		tb.setNorth(Integer.parseInt(guestnorth));


		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		return tb;
	}

	public void Last(TableBean tb) throws Exception{
		ConnectionManager cm = ConnectionManager.getInstance();
		String sql2 = "select table_num, max(start_time) as time "
				+"from gameset where table_num = "+tb.getTableNum()+" group by table_num";
		String s="";
		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql2);
			//System.out.println(sql);
			ResultSet rs=pstmt.executeQuery();

			while(rs.next()){
				s=rs.getString(2);
			}
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		String sql = "update gameset gs set gs.end_time = now(),gs.start_time = '"+s+"' where gs.table_num = "+tb.getTableNum()+" and gs.start_time = '"+s+"'";

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			//System.out.println(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
	}

	public int LastSet(TableBean tb) throws Exception{
		Last(tb);
		int x = 0;
		String sql = "select time(max(start_time)), time(max(end_time)) from gameset where table_num = "+tb.getTableNum();
		ConnectionManager cm = ConnectionManager.getInstance();
		String[] start={};
		String[] end={};

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			//System.out.println(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()){
				//System.out.println(rs.getString(1)+"  "+rs.getString(2));
				start = rs.getString(1).split(":");

				end = rs.getString(2).split(":");
			}
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}

		for(int i=0;i<2;i++){
			if(start[i].equals("00")){
				start[i]="0";
			}else if(start[i].equals("01")){
				start[i]="1";
			}else if(start[i].equals("02")){
				start[i]="2";
			}else if(start[i].equals("03")){
				start[i]="3";
			}else if(start[i].equals("04")){
				start[i]="4";
			}else if(start[i].equals("05")){
				start[i]="5";
			}else if(start[i].equals("06")){
				start[i]="6";
			}else if(start[i].equals("07")){
				start[i]="7";
			}else if(start[i].equals("08")){
				start[i]="8";
			}else if(start[i].equals("09")){
				start[i]="9";
			}
			if(end[i].equals("00")){
				end[i]="0";
			}else if(end[i].equals("01")){
				end[i]="1";
			}else if(end[i].equals("02")){
				end[i]="2";
			}else if(end[i].equals("03")){
				end[i]="3";
			}else if(end[i].equals("04")){
				end[i]="4";
			}else if(end[i].equals("05")){
				end[i]="5";
			}else if(end[i].equals("06")){
				end[i]="6";
			}else if(end[i].equals("07")){
				end[i]="7";
			}else if(end[i].equals("08")){
				end[i]="8";
			}else if(end[i].equals("09")){
				end[i]="9";
			}
		}

		int s[] = {0,0};
		int e[] ={0,0};

		for(int i=0;i<2;i++){
			s[i]=Integer.parseInt(start[i]);
			//System.out.println(s[i]);
			e[i]=Integer.parseInt(end[i]);
			//System.out.println(end[i]);
		}

		double total = 0;

		if(e[0]-s[0]>=0){
			total+= e[0]-s[0];
		}else{
			total = 24-s[0]+e[0];
		}
		if(e[1]-s[1]>=0){
			total+=(double)((double)(e[1]-s[1])/60.0);
		}else{
			total+=(double)((double)(60-s[1]+e[1])/60.0);
		}
		//System.out.println((double)((e[1]-s[1])/60.0));
		//System.out.println((double)(total*1400.0));

		x = (int)(total * 1400.0);
		//System.out.println(x);
		return x;
	}

	public void setRank(int topid, int rasid, String time) throws Exception{
		String sql = "insert into rank (top,ras, ymdhms) values ("+topid+","+rasid+",'"+time+"')";
		//sql = "insert into gameset (top,ras) values ("+topid+","+rasid+") where ymdhms = "+time;
		ConnectionManager cm = ConnectionManager.getInstance();
		//System.out.println(time);
		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			//System.out.println(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}

	}

	public String getGameTime(TableBean tb) throws Exception{
		String sql = "select table_num,max(end_time) from gameset where table_num = "+tb.getTableNum()+" order by table_num";
		ConnectionManager cm = ConnectionManager.getInstance();
		String time = new String();
		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();


			while(rs.next()){
				time = rs.getString(2);
			}
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}

		return time;

	}

	public void debt(int amount, int id) throws Exception{
		String sql = "insert into debt (id, debt,pay_off,ymdhms) values ("+ id +","+ amount +",0,now() )";


		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
	}

	public void buyTheCard(int amount, int id) throws Exception{
		String sql = "insert into buy_the_card (id, amount,ymdhms) values ("+ id +","+ amount +",now() )";


		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
	}

	public void payOff(int amount_n,int amount_s, int id) throws Exception{
		String sql = "insert into debt (id,debt,pay_off,ymdhms) values ("+ id +","+ amount_n +","+amount_s+",now())";
		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();
		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
	}

	public void yakuman(int id , String yaku) throws Exception{
		String sql = "insert into yakuman (id,yakuman,ymdhms) values ("+ id +",'"+yaku+"',now())";
		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();
		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.executeUpdate();
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
	}

	public String outInfo(int id)throws Exception{
		String sql1 = "select debt, ymdhms from debt where id="+id+" and month(ymdhms) != month(now())";
		String sql2 = "select debt, ymdhms from debt where id="+id+" and month(ymdhms) = month(now())";
		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();

		StringBuilder html = new StringBuilder();
		html.append("<table class=\"table\" align=\"center\" border=\"3\">");
		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt1 = con.prepareStatement(sql1);
			ResultSet rs1 = pstmt1.executeQuery();
			PreparedStatement pstmt2 = con.prepareStatement(sql2);
			ResultSet rs2 = pstmt2.executeQuery();
			int sum = 0;
			//System.out.println(pstmt1);
			while(rs1.next()){
				//System.out.println(rs1.getInt(1));
				sum += rs1.getInt(1);
			}
			if(sum>0)
				html.append("<tr><td><font color=\"white\"> 今月以前 </font></td><td align=\"right\"><font color=\"white\"> ▲"+sum+" </font></td><td align=\"right\"><font color=\"white\">▲"+sum+"</font></td></tr>");
			else {
				html.append("<tr><td><font color=\"white\"> 今月以前 </font></td><td align=\"right\"><font color=\"white\">0</font></td><td align=\"right\"><font color=\"white\">0</font</td></tr>");
			}
			while(rs2.next()){
				sum+=rs2.getInt(1);
				if(rs2.getInt(1)<=0)
					html.append("<tr><td><font color=\"white\">"+rs2.getString(2)+"</font></td><td align=\"right\"><font color=\"white\">"+(-rs2.getInt(1))+"</font></td>");
				else
					html.append("<tr><td><font color=\"white\">"+rs2.getString(2)+"</font></td><td align=\"right\"><font color=\"white\">▲"+rs2.getInt(1)+"</font></td>");
				if(sum<=0)
					html.append("<td align=\"right\"><font color=\"white\">"+(-sum)+"</font></td></tr>");
				else {
					html.append("<td align=\"right\"><font color=\"white\">▲"+sum+"</font></td></tr>");
				}
			}
			html.append("<tr><td> </td><td> </td><td align=\"right\"><font color=\"white\">合計▲"+sum+"</font></td></tr>");
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		html.append("</table>");
		String html_s = html.toString();
		return html_s;
	}

	public String AllInfo() throws Exception{
		StringBuilder sb = new StringBuilder();

		/* ConnectionManager はシングルトンなので getInstance() を使ってインスタンス化する */
		ConnectionManager cm = ConnectionManager.getInstance();

		for(int i=1;i<6;i++){
			String sql = "select * from gameset join rank on gameset.end_time = rank.ymdhms where date(end_time) = date(now()) and table_num = "+i;
			sb.append("<table class=\"table\"  border=\"3\"><caption>ゲーム表"+i+"</caption><tr><th>卓番号</th><th>回数</th><th>開始時間</th><th>終了時間</th><th>東</th><th>南</th><th>西</th><th>北</th></tr>");
			try{
				Connection con = cm.getConnection();

				PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery();
				int sum = 0;
				//System.out.println(pstmt1);
				String e = new String();
				String s = new String();
				String w = new String();
				String n = new String();


				while(rs.next()){
					sum+=1;
					e = getName(rs.getInt(3));
					s = getName(rs.getInt(4));
					w = getName(rs.getInt(5));
					n = getName(rs.getInt(6));

					sb.append("<tr><td>"+i+"</td><td>"+sum+"</td><td>"+rs.getString(7)+"</td><td>"+rs.getString(8)+"</td>");
					if(rs.getInt(9)==rs.getInt(3)){
						sb.append("<td>"+e+"◎</td>");
					}else if(rs.getInt(12)==rs.getInt(3)){
						sb.append("<td>"+e+"×</td>");
					}else {
						sb.append("<td>"+e+"</td>");
					}
					if(rs.getInt(9)==rs.getInt(4)){
						sb.append("<td>"+s+"◎</td>");
					}else if(rs.getInt(12)==rs.getInt(4)){
						sb.append("<td>"+s+"×</td>");
					}else {
						sb.append("<td>"+s+"</td>");
					}
					if(rs.getInt(9)==rs.getInt(5)){
						sb.append("<td>"+w+"◎</td>");
					}else if(rs.getInt(12)==rs.getInt(5)){
						sb.append("<td>"+w+"×</td>");
					}else {
						sb.append("<td>"+w+"</td>");
					}
					if(rs.getInt(9)==rs.getInt(6)){
						sb.append("<td>"+n+"◎</td>");
					}else if(rs.getInt(12)==rs.getInt(6)){
						sb.append("<td>"+n+"×</td>");
					}else {
						sb.append("<td>"+n+"</td>");
					}
					sb.append("</tr>");
				}

			}catch(SQLException e){
				System.out.println("処理結果：異常が発生しました。");
				e.printStackTrace();
			}
			sb.append("</table><br>");
		}


		sb.append("<table class=\"table\" border=\"3\"><caption>メンバー入出金表</caption><tr><th>氏名</th><th>時間</th><th>入出金</th><th>TOTAL</th></tr>");
		try{
			String sql = "select t1.id ,t1.name,t1.mg, t2.debt,t2.ymdhms from debt t2 join guest t1 on mg=0 and date(ymdhms) = date(now()) and t1.id=t2.id";
			Connection con = cm.getConnection();

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//t count =0;
			int sum = 0;
			int id = -1;

			while(rs.next()){

				if(id!=rs.getInt(1)){
					id=rs.getInt(1);
					sum=rs.getInt(4);
				}
				else{
					sum+=rs.getInt(4);
				}
				sb.append("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(5)+"</td><td>");
				if(rs.getInt(4)>0){
					sb.append("▲"+rs.getInt(4)+"</td><td>");
				}else{
					sb.append(-rs.getInt(4)+"</td><td>");
				}
				if(sum>0){
					sb.append("▲"+sum+"</td></tr>");
				}else{
					sb.append(-rs.getInt(4)+"</td></tr>");
				}

			}

		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		sb.append("</table><br>");


		sb.append("<table class=\"table\" border=\"3\"><caption>顧客入出金表</caption><tr><th>氏名</th><th>時間</th><th>入出金</th><th>TOTAL</th></tr>");
		try{
			String sql = "select t1.id ,t1.name,t1.mg, t2.debt,t2.ymdhms from debt t2 join guest t1 on mg=1 and date(ymdhms) = date(now()) and t1.id=t2.id";
			Connection con = cm.getConnection();

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			//t count =0;
			int sum = 0;
			int total=0;
			int id = -1;

			while(rs.next()){

				if(id!=rs.getInt(1)){
					id=rs.getInt(1);
					sum=rs.getInt(4);
					//System.out.println("id not same !:"+rs.getInt(4));
				}
				else{
					sum+=rs.getInt(4);
					//System.out.println("id same !:"+rs.getInt(4));
				}
				sb.append("<tr><td>"+rs.getString(2)+"</td><td>"+rs.getString(5)+"</td><td>");
				if(rs.getInt(4)>0){
					sb.append("▲"+rs.getInt(4)+"</td><td>");
					total -= rs.getInt(4);

					if(sum>0){
						sb.append("▲"+sum+"</td></tr>");

					}else{
						sb.append(-sum+"</td></tr>");

					}
					//System.out.println("sem>0:"+total);
				}
				else{
					sb.append(-rs.getInt(4)+"</td><td>");
					total-=rs.getInt(4);
					if(sum>0){
						sb.append("▲"+sum+"</td></tr>");

					}else{
						sb.append(-sum+"</td></tr>");

					}
					//System.out.println("sem<=0:"+total);
				}


			}
			if(total>0)
				sb.append("<tr><td colspan=\"3\">TOTAL</td><td>"+total+"</td></tr>");
			else
				sb.append("<tr><td colspan=\"3\">TOTAL</td><td>▲"+(-total)+"</td></tr>");

		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		sb.append("</table><br>");

		sb.append("<table class=\"table\" border=\"3\"><caption>顧客買入れ</caption><tr><th>氏名</th><th>買入れ</th></tr>");
		try{
			String sql = "select * from buy_the_card where date(ymdhms)=date(now()) order by id asc";
			Connection con = cm.getConnection();

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int count =0;
			int sum = 0;

			int id = -1;

			while(rs.next()){
				if(count!=0&&id!=rs.getInt(1))
					sb.append(sum+"</td></tr>");
				count++;
				if(id!=rs.getInt(1)){
					id=rs.getInt(1);
					sum=rs.getInt(2);
					sb.append("<tr><td>"+getName(rs.getInt(1))+"</td><td>");
				}
				else{
					sum+=rs.getInt(2);
				}

			}
			if(count!=0)
				sb.append(sum+"</td></tr>");
			else
				sb.append("</td></tr>");


		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		sb.append("</table><br>\n");

		sb.append("<table class=\"table\" border=\"3\"><caption>顧客持帰</caption><tr><th>氏名</th><th>精算</th><th>お持帰</th></tr>");
		try{
			String sql = "select * from debt where date(ymdhms) = date(now()) and debt<=0 and pay_off>0";
			Connection con = cm.getConnection();

			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			int count =0;
			int sum_d = 0;
			int sum_p =0;
			int id = -1;

			while(rs.next()){
				if(count!=0)
					sb.append(sum_p+"</td><td>"+(sum_p+sum_d)+"</td></tr>");
				count++;
				if(id!=rs.getInt(1)){
					id=rs.getInt(1);
					sum_d=rs.getInt(2);
					sum_p=rs.getInt(3);
					sb.append("<tr><td>"+getName(rs.getInt(1))+"</td><td>");
				}
				else{
					sum_d+=rs.getInt(2);
					sum_p+=rs.getInt(3);
				}

			}
			if(count!=0)
				sb.append(sum_p+"</td><td>"+(sum_p+sum_d)+"</td></tr>");


		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		sb.append("</table><br>");

		String html = sb.toString();
		return html;
	}

	public int getPreSafeInfo() throws Exception{
		ConnectionManager cm = ConnectionManager.getInstance();
		int safeinfo = 0;
		String sql = "select * from safe where date(ymdhms) = date(now() - interval 1 day)";
		boolean flag = true;

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while(rs.next()){
				flag = false;
				safeinfo = rs.getInt(1);
			}

			if(flag){
				int presafe=0;
				String ymdhms = "";

				String presafesql = "select * from safe where date(ymdhms) < date(now()) order by ymdhms asc limit 1";
				pstmt = con.prepareStatement(presafesql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					presafe+=rs.getInt(1);
					ymdhms = rs.getString(2);
				}

				int free = 0;
				for(int i=1;i<6;i++){
					String tablesql = "select * from gameset where (date(start_time) < date(now()) and date(end_time) <= date(now()) and date('"+ymdhms+"') < date(start_time) and table_num = "+i+")";
					pstmt = con.prepareStatement(tablesql);
					rs = pstmt.executeQuery();

					while(rs.next()){
						if(rs.getInt(3)!=1){
							free+=2200;
						}
					}
				}

				int debt = 0;
				String outsql = "select debt from debt where date(ymdhms) < date(now()) and date(ymdhms) > date ('"+ymdhms+"')";
				pstmt = con.prepareStatement(outsql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					debt -= rs.getInt(1);
				}

				int keihi = 0;
				String keihisql = "select keihi from keihi where date(ymdhms) < date(now()) and date(ymdhms) > date ('"+ymdhms+"')";
				pstmt = con.prepareStatement(keihisql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					keihi -= rs.getInt(1);
				}

				int yakuman = 0;
				String yakumansql = "select * from yakuman where date(ymdhms) < date(now()) and date(ymdhms) > date ('"+ymdhms+"')";
				pstmt = con.prepareStatement(yakumansql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					yakuman -= 1000;
				}

				int earnings =0;
				String earningssql = "select * from earnings where date(ymdhms) < date(now()) and date(ymdhms) > date ('"+ymdhms+"')";
				pstmt = con.prepareStatement(earningssql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					earnings -= rs.getInt(1);
				}

				presafe += free + debt + keihi + yakuman + earnings;

				String insert = "insert into safe (amount, ymdhms) values ("+presafe+", date(now() - interval 1 day))";
				pstmt = con.prepareStatement(insert);
				//System.out.println(pstmt);
				pstmt.executeUpdate();

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				while(rs.next()){
					safeinfo = rs.getInt(1);
				}
			}


		}
		catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}

		return safeinfo;
	}

	public int[] money() throws Exception{
		int[] m={0,0,0,0};
		ConnectionManager cm = ConnectionManager.getInstance();
		String sql = "";

		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement(sql);


			int debt = 0;
			String outsql = "select debt,pay_off from debt where date(ymdhms) = date(now()) and pay_off > 0 or date(ymdhms) = date(now()) and pay_off = 0 and debt < 0";
			/* アウトで始めた人が途中で４０枚くらいなったからとりあえず入れといてのばあい、一万清算からの一万入金 */
			pstmt = con.prepareStatement(outsql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				debt = debt- rs.getInt(1) - rs.getInt(2);
			}

			int keihi = 0;
			String keihisql = "select keihi from keihi where date(ymdhms) = date(now())" ;
			pstmt = con.prepareStatement(keihisql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				keihi -= rs.getInt(1);
			}

			int buy = 0;
			String buysql="select amount from buy_the_card where date(ymdhms) = date(now())";
			pstmt = con.prepareStatement(buysql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				buy += rs.getInt(1);
			}

			int earnings =0;
			String earningssql = "select * from earnings where date(ymdhms) = date(now())";
			pstmt = con.prepareStatement(earningssql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				earnings -= rs.getInt(1);
				//System.out.println("m:"+rs.getInt(1));
			}

			m[0] = buy;
			m[1] = debt;
			m[2] = keihi;
			m[3] = earnings;

		}
		catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}

		return m;
	}

	public int[] uriage()throws Exception{
		int[] u={0,0,0,0,0};
		ConnectionManager cm = ConnectionManager.getInstance();
		try{
			Connection con = cm.getConnection();
			PreparedStatement pstmt = con.prepareStatement("");

			int free = 0;
			for(int i=1;i<6;i++){
				String tablesql = "select * from gameset where (date(start_time) = date(now()) and date(end_time) = date(now()) and table_num = "+i+")";
				pstmt = con.prepareStatement(tablesql);
				ResultSet rs = pstmt.executeQuery();

				while(rs.next()){
					if(rs.getInt(3)!=1){
						free+=2200;
					}
				}
			}

			int debt = 0;
			String outsql = "select debt from debt where date(ymdhms) = date(now()) ";
			pstmt = con.prepareStatement(outsql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				debt -= rs.getInt(1);
			}

			int keihi = 0;
			String keihisql = "select keihi from keihi where date(ymdhms) = date(now()) ";
			pstmt = con.prepareStatement(keihisql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				keihi -= rs.getInt(1);
			}

			int yakuman = 0;
			String yakumansql = "select * from yakuman where date(ymdhms) = date(now()) ";
			pstmt = con.prepareStatement(yakumansql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				yakuman -= 1000;
			}

			int earnings =0;
			String earningssql = "select * from earnings where date(ymdhms) = date(now())";
			pstmt = con.prepareStatement(earningssql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				earnings -= rs.getInt(1);
				//System.out.println("u:"+rs.getInt(1));
			}

			u[0]+= free ;
			u[1]+= debt;
			u[2]+= keihi;
			u[3]+= yakuman;
			u[4]+= earnings;

		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}

		return u;
	}

	public String getSafeInfo() throws Exception{
		StringBuilder html = new StringBuilder();
		int pre=getPreSafeInfo();
		int m[] = money();
		int u[] = uriage();
		int total_m=0;
		int total_u=0;

		for(int x:m){
			total_m += x;
		}
		for(int x:u){
			total_u += x;
			//System.out.println(total_u);
		}
		html.append("<table class=\"table\" border=\"3\"><tr><td>昨日までの金庫内金額</td><td>"+pre+"</td></tr>");
		if(total_m>=0){
			html.append("<tr><td>今日の入出金合計</td><td>"+total_m+"</td></tr>");
		}else{
			html.append("<tr><td>今日の入出金合計</td><td>▲"+(-total_m)+"</td></tr>");
		}
		html.append("<tr><td>現在の金庫内金額</td><td>"+(pre+total_m)+"</td></tr></table>");

		if(total_u>=0){
			html.append("<table class=\"table\" border=\"3\"><tr><td>今日の売上金合計</td><td>"+total_u+"</td></tr>");
		}else{
			html.append("<table class=\"table\" border=\"3\"><tr><td>今日の売上金合計</td><td>▲"+(-total_u)+"</td></tr>");
		}

		html.append("<tr><td>今日の売上金+金庫内金額</td><td>"+(pre+total_u)+"</td></tr></table>");

		return html.toString();
	}

	public int[] seiseki() throws Exception{


		int x1[] = {0,0};
		int x2[] = {0,0};
		int x3[] = {0,0};

		for(int i=1;i<50;i++){
			int x=rank(i);
			if(x>x1[1]){
				x1[0]=i;
				x1[1]=x;
			}else if(x>x2[1]){
				x2[0]=i;
				x2[1]=x;
			}else if(x>x3[1]){
				x3[0]=i;
				x3[1]=x;
			}
		}

		int seiseki[]={x1[0],x1[1],x2[0],x2[1],x3[0],x3[1]};

		return seiseki;
	}

	public int rank(int id) throws Exception{
		ConnectionManager cm = ConnectionManager.getInstance();
		int num=0;
		try{
			Connection con = cm.getConnection();
			String sql="select top,ras,ymdhms from rank where year(ymdhms) = year(now()) and month(ymdhms) = month(now()) and top = "+id;
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				 num++;
				//System.out.println("u:"+rs.getInt(1));
			}
		}catch(SQLException e){
			System.out.println("処理結果：異常が発生しました。");
			e.printStackTrace();
		}
		return num;
	}

	public boolean isNumber(String val) {
		String regex = "\\A[-]?[0-9]+\\z";
		Pattern p = Pattern.compile(regex);
		Matcher m1 = p.matcher(val);
		return m1.find();
	}

}
