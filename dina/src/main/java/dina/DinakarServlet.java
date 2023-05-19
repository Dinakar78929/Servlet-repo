package dina;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument.BranchElement;

@WebServlet(loadOnStartup = 1, urlPatterns = ("/send"))
public class DinakarServlet extends HttpServlet {
	public DinakarServlet() {
		System.out.println("no args DinakarServlet consts");
	}

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("Calling service method");
		super.service(arg0, arg1);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Calling DinakarServlet doGet method");

		req.getRequestURL();
		System.out.println("IP address" + req.getRemoteAddr());

		Enumeration<String> enumeration = req.getHeaderNames();

		while (enumeration.hasMoreElements()) {
			String headerName = enumeration.nextElement();

			System.out.println(headerName + ":" + req.getHeader(headerName));
		}
		String name = req.getParameter("countryName");
		String code = req.getParameter("code");
		String capital = req.getParameter("capitalCity");
		String population = req.getParameter("population");

		// String pmName=req.getParameter("pm");

		resp.setContentType("text/html");
		PrintWriter printWriter = resp.getWriter();
		printWriter.print("<html>");
		printWriter.print("<head>");
		printWriter.print("<title>");
		printWriter.print("Country Detail Page");
		printWriter.print("</title>");
		printWriter.print("</head>");
		printWriter.print("<body>");
		printWriter.print("<h1>");
		printWriter.println("Country info");
		printWriter.print("</h1>");
		printWriter.print("<h3>");
		printWriter.print("<ol>");
		printWriter.print("<li>");
		printWriter.println("CountryName =" + " " + name);
		printWriter.print("</li>");
		printWriter.print("</br>");
		printWriter.print("<li>");
		printWriter.println("CountryCode =" + " " + code);
		printWriter.print("</li>");
		printWriter.print("</br>");
		printWriter.print("<li>");
		printWriter.println("CapitalCity =" + " " + capital);
		printWriter.print("</li>");
		printWriter.print("</br>");
		printWriter.print("<li>");
		printWriter.println("Total Population =" + " " + population);
		printWriter.print("</li>");
		printWriter.print("</br>");
		printWriter.print("</ol>");
		printWriter.print("</h3>");
		System.out.println("CountryName:" + name + " " + "CountryCode:" + code + "CapitalCity:" + capital
				+ "Total Population:" + population);
		printWriter.print("<form method='get' action='pmName'>");
		printWriter.print("<h4>Enter PM Name:<input type='type' name='pm' required></h4>");
		// printWriter.print("");

//		printWriter.print("</br>");
		printWriter.print("<input type='submit' value='Next'>");
		printWriter.print("</form>");
		printWriter.print("</body>");
		printWriter.print("</html>");

		printWriter.print("");

	}
}
