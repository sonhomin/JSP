package ch05;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

    public CalcServlet() {
       super();
    }

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int n1 = Integer.parseInt(request.getParameter("n1"));      
      String op = request.getParameter("op");
      
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      
      out.append("<html><body><h2>계산기 서블릿</h2><hr> 계산결과: <br>");
      switch(op){      	
         case "+": for(int i=1;i<=9;i++) {
        	 			out.append(n1+"+"+i+"="+(n1+i)+"<br>");
         			}break;
        	 
         case "*": for(int i=1;i<=9;i++) {
        	 			out.append(n1+"*"+i+"="+(n1*i)+"<br>");
         			}break;
      }
      out.append("</body></html>");      
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }
}