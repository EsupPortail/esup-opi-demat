package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Properties;
import java.io.File;

public final class depotModification_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(2);
    _jspx_dependants.add("/header.jsp");
    _jspx_dependants.add("/menu.jsp");
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      out.write('\n');

Properties prop = com.de_mvc.tools.LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=iso-8859-1\">\n");
      out.write("<title>");
      out.print( application.getInitParameter("titre") );
      out.write("</title>\n");
      out.write("<link rel=\"stylesheet\" type=\"text/css\"\n");
      out.write("\thref=\"./media/style/SABERKAN.css\" />\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("\n");
      out.write("<body class=\"portlet-section-body esup-opiR1\">\n");
      out.write("<div id=\"header\" class=\"header\">\n");
      out.write("<div class=\"logo\"></div>\n");
      out.write("<div class=\"header_suite\">\n");
      out.write("<div id=\"titreAppli\" class=\"titreAppli\"><span\n");
      out.write("\tclass=\"span_bigTitre\">");
      out.print( prop.getProperty("candidatures")  );
      out.write("</span> <br/>\n");
      out.write("<span class=\"span_titre\">");
      out.print( prop.getProperty("operation")  );
      out.write("</span></div>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"user_displayName\"><span class=\"span_currentUser\"></span>\n");
      out.write("</div>\n");
      out.write("<div class=\"version\"><span class=\"span_version\"></span></div>\n");
      out.write("</div>\n");
      out.write("</div>");
      out.write('\n');
      out.write("<ul id=\"navigationHeader:navigation\" class=\"menu\">\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienCandidature") );
      out.write("\" target=_blank>Accueil</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienFAQ") );
      out.write("\" target=_blank>F.A.Q</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienAide") );
      out.write("\" target=_blank>Aide</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"deconnection.do\">D&#233;connexion</a></li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"maPage\" class=\"div_body\">\n");
      out.write("\n");
out.println("<h1>"+new String(request.getSession(false).getAttribute("nomUsr").toString().getBytes("utf-8"), "iso-8859-1")+"</h1>");
      out.write("\n");
      out.write("<center><p><span class=\"section-header-blue\">");
      out.print( prop.getProperty("AlertDocumentEcrase")  );
      out.write("</span></p></center>\n");
      out.write("<div class=\"salahddine_welcomeInfoFirstConnexion\">\n");
      out.write("\n");
      out.write("<form action=\"uploading.do\" method=\"post\" name=\"myform2\" enctype=\"multipart/form-data\">\n");

	String piece = request.getAttribute("piece").toString();
	String code = request.getAttribute("code").toString();
	out.println("<table class=\"welcomeConnexion\"><tr><td><center>");
	out.println("<h2><span style=\"text-align: center;\" class=\"section-subheader2\"> "+piece+"</span></h2>");
	out.println("<center><input type=\"file\" name="+new String(piece.replaceAll(" ", "-").getBytes("utf-8"), "iso-8859-1")+"="+code+"><center>");
	out.println("</td></tr></table></center>");

      out.write("\n");
      out.write("\n");
      out.write("<center><input type=\"submit\" name=\"Submit\" value=\"");
      out.print( prop.getProperty("buttonValider") );
      out.write("\"/ maxlength=\"10\" size=\"15\" class=\"form-button\"></center><br></br><br></br>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("<center><p><span class=\"section-header-blue\"><a href=\"modification\">");
      out.print( prop.getProperty("retour")  );
      out.write("</a><br></span></p></center>\n");
      out.write("<center><p><span class=\"section-header-blue\"><a href=\"depot.do\">");
      out.print( prop.getProperty("retourAccueilDepot")  );
      out.write("</a><br></span></p></center>\n");
      out.write("<center><p><span class=\"section-header-blue\"><a href=\"backToEtape\">");
      out.print( prop.getProperty("retourAccueil")  );
      out.write("</a><br></span></p></center>\n");
      out.write("<!--  <center><p><span class=\"section-header-blue\"><a href=\"deconnection.do\">");
      out.print( prop.getProperty("deconnexion")  );
      out.write("</a></span></p></center> -->\n");
      out.write("</div>\n");
      out.write("<ul id=\"navigationHeader:navigation\" class=\"menu\">\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienCandidature") );
      out.write("\" target=_blank>Accueil</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienFAQ") );
      out.write("\" target=_blank>F.A.Q</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"");
      out.print( prop.getProperty("lienAide") );
      out.write("\" target=_blank>Aide</a></li>\n");
      out.write("\t\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\n");
      out.write("\t\n");
      out.write("\t<li class=\"item\"><a class=\"rubrique\" href=\"deconnection.do\">D&#233;connexion</a></li>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
