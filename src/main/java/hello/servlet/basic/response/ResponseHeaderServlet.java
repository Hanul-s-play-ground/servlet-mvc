package hello.servlet.basic.response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		response.setContentType("text/plain");
		response.setCharacterEncoding("utf-8");

		redirect(response);

		PrintWriter writer = response.getWriter();
		writer.println("안녕하세요");
	}

	private void redirect(HttpServletResponse response) throws IOException {
		// response.setStatus(HttpServletResponse.SC_FOUND);
		// response.setHeader("Location", "/basic/hello-form.html");
		response.sendRedirect("/basic/hello-form.html");
	}
}
