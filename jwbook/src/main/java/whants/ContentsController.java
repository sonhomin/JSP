package whants;

import java.io.IOException;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@WebServlet(urlPatterns = "/whants.nhn")
@MultipartConfig(maxFileSize = 1024 * 1024 * 2, location = "c:/Temp/img")
public class ContentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ContentsDAO dao;
	private ServletContext ctx;

	private final String START_PAGE = "whants/login.jsp";

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		dao = new ContentsDAO();
		ctx = getServletContext();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		dao = new ContentsDAO();

		Method m;
		String view = null;

		if (action == null) {
			action = "login";
		}

		try {
			m = this.getClass().getMethod(action, HttpServletRequest.class);
			view = (String) m.invoke(this, request);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			ctx.log("요청 action 없음");
			request.setAttribute("error", "action 파라미터가 잘못되었습니다");
			view = START_PAGE;
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (view.startsWith("redirect:/")) {
			String rview = view.substring("redirect:/".length());
			response.sendRedirect(rview);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher(view);
			dispatcher.forward(request, response);
		}

	}

	public String addContents(HttpServletRequest request) {
		Contents c = new Contents();
		try {
			Part part = request.getPart("file");
			String fileName = getFilename(part);
			if (fileName != null && !fileName.isEmpty()) {
				part.write(fileName);
			}
			BeanUtils.populate(c, request.getParameterMap());
			c.setImg("/img/" + fileName);
			dao.addContents(c);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.log("추가 과정에서 문제 발생");
			request.setAttribute("error", "정상적으로 등록되지 않았습니다");
			return "whants/login.jsp";
		}
		return "redirect:/whants/index.jsp";
	}
	
	public String login(HttpServletRequest request) {
		
		return "redirect:/whants/index.jsp";
	}
	
//	public String deleteNews(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			dao.delContents(aid);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("뉴스 삭제 과정에서 문제 발생");
//			request.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다");
//			return listNews(request);
//		}
//		return "redirect:/news.nhn?action=listNews";
//	}
//
//	public String listNews(HttpServletRequest request) {
//		List<News> list;
//		try {
//			list = dao.getAll();
//			request.setAttribute("newslist", list);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("뉴스 생성 과정에서 문제 발생");
//			request.setAttribute("error", "뉴스 목록이 정상적으로 처리되지 않았습니다");
//		}
//		return "ch10/newsList.jsp";
//	}
//
//	public String getNews(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			News n = dao.getNews(aid);
//			request.setAttribute("news", n);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("뉴스를 가져오는 과정에서 문제 발생");
//			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다");
//		}
//		return "ch10/newsView.jsp";
//	}
//
	private String getFilename(Part part) {
		String fileName = null;
		String header = part.getHeader("content-disposition");
		System.out.println("Header => " + header);
		int start = header.indexOf("filename=");
		fileName = header.substring(start + 10, header.length() - 1);
		ctx.log("파일명:" + fileName);
		return fileName;
	}
}
