package com.plan1.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.plan1.dao.HibernateUserProcess;
import com.plan1.model.User;
import com.plan1.utils.JsonConverter;



@WebServlet("/acctivate")
public class AcctivateCode extends HttpServlet {
//	private static final long limitTime = 1000 *60*60 *3600 *7; //
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcctivateCode() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String code = request.getParameter("code");
		String email = request.getParameter("email");
		List<User> users = HibernateUserProcess.isOk("toActivated",code ,email);
		PrintWriter out = response.getWriter();
		Map<String, String> res = new HashMap<String, String>();
		if(users.size() ==1) {
			User user = users.get(0);
			
				
			user.setActivated(true);
			res.put("status", "1");
		}
		
		if(res.isEmpty()) {
			res.put("status", "0");
		}
		out.print(JsonConverter.map2json(res));
		
	}




}
