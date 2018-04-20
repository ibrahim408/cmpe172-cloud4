package twitterPackage;
/**
 * Author: Cameron
 * Get following
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FollowingAPIServelt extends HttpServlet {
	public FollowingAPIServelt(){
		super();
	}
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
    	String username = request.getParameter("username");
    	String[][] result = TwitterUtils.getFriends(username);
    	request.setAttribute("following", result);
		request.getServletContext().getRequestDispatcher("/WEB-INF/followingResult.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}