package dina;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = ("/pmName"))
public class PMServlet extends HttpServlet {
	public PMServlet() {
		System.out.println("no argument PMServlet const");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("Calling Service Method");
		super.service(arg0, arg1);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Calling doGet Method");

		req.getRequestURL();
		String pmName = req.getParameter("pm");
		System.out.println("PM Name:" + pmName);
		PrintWriter printWriter = resp.getWriter();
		
		
		printWriter.print("<html>");
		printWriter.print("<head>");
		
		printWriter.print("<title>");
		printWriter.print("PM Detail Page");
		printWriter.print("</title>");
		printWriter.print("</title>");
		
		printWriter.print("</head>");
		
		printWriter.print("<body>");
		
		printWriter.print("<h1>");
		printWriter.print("PM Info");
		printWriter.print("</h1>");
		
		printWriter.print("<h3>");
		printWriter.print("PM Name:" + pmName);
		printWriter.print("</h3>");
		
		printWriter.print("<ul>");
		printWriter.print("<li>");
		printWriter.print("<a href='Index.html'>Go to index");
		printWriter.print("</li>");
		printWriter.print("</ul>");
		
		printWriter.print("</body>");
		printWriter.print("</html>");

	}
}
