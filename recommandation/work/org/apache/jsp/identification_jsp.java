package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Properties;
import java.io.File;

public final class identification_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/header.jsp");
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

Properties prop = com.lr_mvc.LoadProperties.load(getServletContext().getRealPath("/")+"/WEB-INF/classes/Message_fr.properties");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
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
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"maPage\" class=\"div_body\">\n");
      out.write("<div style=\"width:100%;text-align:center;\">\n");
      out.write("\t\t\t<p><span class=\"section-header-blue\">");
      out.print( prop.getProperty("bienvenueRecommandation") );
      out.write("</span></p>\n");
      out.write("\t\t\t<h2><span class=\"section-header-two-black\"></span></h2>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("<ul>\n");
      out.write("<div id =\"validation\" style=\"display: none; \"><li/>le mail est obligatoire</div>\n");
      out.write("</ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("<div class=\"salahddine_welcomeInfoFirstConnexion\">\n");
      out.write("<form action=\"choixMDP\" method=\"post\" name=\"myform\" onsubmit='return Verif();'>\n");
      out.write("<table class=\"welcomeConnexion\">\n");
      out.write("\t<tr>\n");
      out.write("\t\t<td>\n");
      out.write("\t\t<center>\n");
      out.write("\t\t<h2><span style=\"text-align: center;\" class=\"section-subheader\">");
      out.print( prop.getProperty("demandeSaisiMail") );
      out.write("</span></h2>\n");
      out.write("\t\t</center>\n");
      out.write("\t\t\n");
      out.write("\t\t<center>\n");
      out.write("\t\t<p><span class=\"portlet-section-text\">");
      out.print( prop.getProperty("adresseMail")  );
      out.write("<input type=\"text\" id=\"adresseMail\" name=\"adresseMail\" onblur='verifPseudo(this)'/></span></p>\n");
      out.write("\t\t</center>\n");
      out.write("\t\t\n");
      out.write("\t\t<br>\n");
      out.write("\t\t<center><input type=\"submit\" name=\"Submit\" value=\"");
      out.print( prop.getProperty("buttonConnexion")  );
      out.write("\" maxlength=\"8\" size=\"10\" class=\"form-button\"/>\n");
      out.write("\t\t</center>\n");
      out.write("\t\t</td>\n");
      out.write("\t</tr>\n");
      out.write("</table>\n");
      out.write("</form>\n");
      out.write("</div>\n");
      out.write("</div>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("<script language=\"javascript\" type=\"text/javascript\">\n");
      out.write("function surligne(champ, erreur)\n");
      out.write("{\n");
      out.write("   if(erreur) {\n");
      out.write("      champ.style.backgroundColor = \"#fba\";\n");
      out.write("   } else {\n");
      out.write("      champ.style.backgroundColor = \"\";\n");
      out.write("   }\n");
      out.write("}\n");
      out.write("function verifPseudo(champ)\n");
      out.write("{\n");
      out.write("   if(champ.value.length == 0)\n");
      out.write("   {\n");
      out.write("      surligne(champ, true);\n");
      out.write("      return false;\n");
      out.write("   }\n");
      out.write("   else\n");
      out.write("   {\n");
      out.write("      surligne(champ, false);\n");
      out.write("      return true;\n");
      out.write("   }\n");
      out.write("}\n");
      out.write("function Verif() {\n");
      out.write("\tif (document.getElementById(\"adresseMail\").value.length != 0){\n");
      out.write("\t\tdocument.form1.submit();\n");
      out.write("\t\treturn true;\n");
      out.write("\t} else {\n");
      out.write("\t\tdiv = document.getElementById(\"validation\");\n");
      out.write("\t    div.style.display = \"block\";\n");
      out.write("\t\treturn false;\n");
      out.write("\t} \n");
      out.write("}\n");
      out.write("</script>");
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
