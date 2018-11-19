/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.4
 * Generated at: 2018-10-15 14:12:08 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import clases.*;
import interfaces.*;
import utils.*;
import datatypes.*;
import java.util.List;

public final class detalles_005flista_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("interfaces");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("clases");
    _jspx_imports_packages.add("utils");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_packages.add("datatypes");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("<!doctype html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("<head>\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/extras/head.jsp", out, false);
      out.write("\n");
      out.write("\t<title>Videos de la lista de reproducción</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<div class=\"page\">\n");
      out.write("\t\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/extras/header.jsp", out, false);
      out.write('\n');
      out.write('	');
      out.write('	');
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/extras/sidebar.jsp", out, false);
      out.write("\n");
      out.write("\t\t<div class=\"contenido\">\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\tDetalles de la lista \n");
      out.write("\t\t\t");
 DtLista lista = ((DtLista) request.getAttribute("DTLISTA")); 
      out.write("\n");
      out.write("\t\t\t");
      out.print( lista.getNombre() );
      out.write("\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\tVideos de la lista:\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t\t<div class=\"highlights\">\n");
      out.write("\t\t\t\t\t");
 List<DtVideo> listaVideos = (List<DtVideo>) lista.getDtVideos();
					for (DtVideo video : listaVideos) { 
      out.write("\t\t\t\n");
      out.write("\t\t\t\t\t<div class=\"detalleClickeableVideo\"onclick=\"document.getElementById('Form");
      out.print(video.idVideo);
      out.write("').submit();\">\t\n");
      out.write("\t\t\t\t\t<form id=\"Form");
      out.print(video.idVideo);
      out.write("\" class=\"detClickeableVideo\" action=\"ConsultaVideo\" method=\"GET\">\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"VIDEO_ID\" value=\"");
      out.print(video.idVideo);
      out.write("\">\n");
      out.write("\t\t\t\t\t\t<img class=\"icon\" width=\"30%\" alt=\"DetalleVideo\" src=\"");
      out.print(video.urlThumbnail);
      out.write("\">\n");
      out.write("\t\t\t\t\t\t<header>\n");
      out.write("\t\t\t\t\t\t");
      out.print( video.nombre );
      out.write("\n");
      out.write("\t\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t\tUser: ");
      out.print( video.usuario );
      out.write("\n");
      out.write("\t\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t</form>\t\n");
      out.write("\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t<br>\n");
      out.write("\t\t\t\t\t");
 } 
      out.write("\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t");
 if(lista.getTipo() == "Particular") { 
      out.write("\n");
      out.write("\t\t\tCategorias de la lista:\n");
      out.write("\t\t\t<br>\n");
      out.write("\t\t\t<div class=\"highlights\">\n");
      out.write("\t\t\t\t");
 List<String> listaCategorias = (List<String>) lista.getCategorias();
				for (String cat : listaCategorias) { 
      out.write("\t\t\t\n");
      out.write("\t\t\t\t<div class=\"detalleClickeableCategoria\"onclick=\"document.getElementById('Form");
      out.print(cat);
      out.write("').submit();\">\t\n");
      out.write("\t\t\t\t\t<form id=\"Form");
      out.print(cat);
      out.write("\" class=\"detClickeableCategoria\" action=\"ConsultaDeCategoria\" method=\"GET\">\n");
      out.write("\t\t\t\t\t\t<input type=\"hidden\" name=\"CATEGORIA\" value=\"");
      out.print(cat);
      out.write("\">\n");
      out.write("\t\t\t\t\t\t<img class=\"icon\" width=\"30%\" alt=\"DetalleVideo\" src=\"img/categoria.png\">\n");
      out.write("\t\t\t\t\t\t<header>\n");
      out.write("\t\t\t\t\t\t");
      out.print( cat );
      out.write("\n");
      out.write("\t\t\t\t\t\t</header>\n");
      out.write("\t\t\t\t\t</form>\t\n");
      out.write("\t\t\t\t</div>\n");
      out.write("\t\t\t\t<br>\n");
      out.write("\t\t\t\t");
 } } 
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t</div>\n");
      out.write("\t");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "/WEB-INF/extras/script.jsp", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
