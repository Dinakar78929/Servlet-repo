package film;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1, urlPatterns = ("/yamaha"))
public class YamahaServlet extends HondaServlet {
	public YamahaServlet() {
		System.out.println("no args YamahaServlet const");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Running YamahaServlet doGet method");
	}
}
