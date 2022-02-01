package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Message;
@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<Message> msgs = new ArrayList<Message>();
	String msg;
	String author;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getParameter("messages") == "delete") {
			msgs = new ArrayList<Message>();
			System.out.println("ALL MESSAGES DELETED");
		}
		req.getRequestDispatcher("chat.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("utf-8");
		//Supprimer tout les msgs 
		
		// si la requete contient l'attribut "refresh"
		if(req.getParameter("refresh")!=null){
			int num = Integer.parseInt(req.getParameter("refresh"));
			//on parcours le array
			if(num < msgs.size() ){
				String author,content;
				int id;
				for (int i = num; i < msgs.size(); i++) {
					 author = ((Message) msgs.get(i)).getAuthor();
					 content = ((Message) msgs.get(i)).getContent();
					 content = content.replace("\n", "");
					 System.out.println("messageContent : "+content);
					 // envoie de message de retour qui est sous forme d'un objet JSON
					 resp.getWriter().write("{\"author\":\""+author+"\",\"content\":\""+content+"\"}+");
				}
			}
		}else{
			msg = req.getParameter("msg");
			author = req.getParameter("author");
			// création de l'objet message
			msgs.add(new Message(msgs.size(),msg,author));
			resp.getWriter().write(author+"+"+msg+"+"+ msgs.size());	
		}
	}
}
