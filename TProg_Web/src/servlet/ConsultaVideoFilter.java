package servlet;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet Filter implementation class ConsultaVideoFilter
 */

public class ConsultaVideoFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ConsultaVideoFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
	  String url = ((HttpServletRequest)request).getRequestURL().toString();
	  //String queryString = ((HttpServletRequest)request).getQueryString();
	  String uri = ((HttpServletRequest)request).getServletPath();
	  if(uri.contains("v=")) {
	    String idVideo = uri.substring(3);
	    HttpServletRequest httpRequest = (HttpServletRequest) request;
	    httpRequest.setAttribute("VIDEO_ID", idVideo);
	    HttpServletResponse httpResponse = (HttpServletResponse) response; 
	    httpResponse.sendRedirect("ConsultaVideo?VIDEO_ID="+idVideo);
	    //request.getRequestDispatcher("ConsultaVideo").forward(httpRequest, httpResponse);
	    //httpResponse.sendRedirect("ConsultaVideo");
	    }
	  else {	    
	    chain.doFilter(request, response);
	  }
	  //chain.
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
