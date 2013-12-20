package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.io.*;
import java.net.*;
import org.apache.commons.fileupload.*;
import java.util.List;
import java.util.Iterator;
import javax.activation.MimetypesFileTypeMap;
import java.util.ArrayList;
import java.util.Properties;
import java.io.File;

public final class depot_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write('\n');
      out.write('\n');


String numDossier = session.getAttribute("numDossier").toString();
String codeEtape = session.getAttribute("codeEtape").toString();
String codeVet = session.getAttribute("codeVet").toString();
String libCmi = request.getAttribute("libCmi").toString();
String dateFin = request.getAttribute("dateFin").toString();
ArrayList<String> listEmplacements = (ArrayList<String>) request.getAttribute("listEmplacements");
ArrayList<String> listPJ = (ArrayList<String>) request.getAttribute("pieces");
ArrayList<String> listCodePJ = (ArrayList<String>) request.getAttribute("codes");
String lienDossier = getServletContext().getInitParameter("lienDossier");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<div id=\"maPage\" class=\"div_body\">\n");
out.println("<h1>"+new String(request.getSession(false).getAttribute("nomUsr").toString().getBytes("utf-8"), "iso-8859-1")+"</h1>");
      out.write("\n");
      out.write("<h2>");
      out.print( libCmi );
      out.write("</h2>\n");
      out.write("<h3>");
      out.print(prop.getProperty("dateFermeture")  );
      out.print( dateFin );
      out.write("</h3>\n");
      out.write("\n");
      out.write("<center><p><span class=\"section-header-blue\">");
      out.print( prop.getProperty("piecesJointes")  );
      out.write("</span></p></center>\n");
      out.write("<center><p><span class=\"section-header-blue\"><a href=\"modification\">");
      out.print(prop.getProperty("modifFiles")  );
      out.write("</a><br></span></p></center>\n");
      out.write("<center><p><span class=\"section-header-blue\"><a href=\"backToEtape\">");
      out.print( prop.getProperty("retour")  );
      out.write("</a><br></span></p></center>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
 
int i = 0;
for(String pj : listPJ){
	out.print("<div style=\"float: left; width: 50%;\" >");
	out.println("<div class=\"salahddine_welcomeInfoFirstConnexion3\">");
	out.println("<table class=\"welcomeConnexion\">");
	out.println("<tr><td><center>");
	out.println("<h2><span style=\"text-align: center;\" class=\"section-subheader2\">"+pj+"</span></h2></center>");
	boolean exist = false;
	
	for(String emplacement : listEmplacements){
		if(emplacement.contains("/" +listCodePJ.get(listPJ.indexOf(pj))+".")) {
			File file = new File(emplacement);
			if(file.exists()){
				String codePj = listCodePJ.get(i);
				
				out.println("<form action='visualiser' method='post' name='myform" + i + "'>");
				out.print("<center><p><span class=\"portlet-section-text\">"+prop.getProperty("existFile")+"&nbsp;&nbsp;<img src=\"./image/button_ok.png\"></img></span></p></center>");
				out.print("<input type='hidden' name='numDossier' value='" + numDossier + "' />");
				out.print("<input type='hidden' name='codeEtape' value='" + codeEtape + "' />");
				out.print("<input type='hidden' name='codeVet' value='" + codeVet + "' />");
				out.print("<input type='hidden' name='codePj' value='" + codePj + "' />");
				out.print("<center><input type='submit' name='Submit' value='" + prop.getProperty("visualiser")  + "' maxlength='10' size='15' class='form-button'/></center>");
				exist = true;
			}
		}
	}
	if(!exist){
		out.println("<form action='uploading.do' method='post' name='myform" + i + "' enctype='multipart/form-data'>");
		out.print("<center><input type=\"file\" name="+new String(pj.replaceAll(" ", "-").toString().getBytes("utf-8"), "iso-8859-1")+"="+listCodePJ.get(i)+" /><img src=\"./image/button_cancel.png\"></center>");
		out.print("<center><input type='submit' name='Submit' value='" + prop.getProperty("buttonValider")  + "' maxlength='10' size='15' class='form-button'/></center>");
	}
	out.print("</form>");
	out.println("</tr>");
	out.println("</table>");
	out.println("</div><br>");
	
	out.print("</div><br>");
	
	i++;
}

      out.write("\n");
      out.write("\t\n");
      out.write("\t\n");
      out.write("<center><p><span class=\"section-header-blue\"><a href=\"modification\">");
      out.print( prop.getProperty("modifFiles")  );
      out.write("</a><br></span></p></center>\n");
      out.write("<center><p><span class=\"section-header-blue\"><a href=\"backToEtape\">");
      out.print( prop.getProperty("retour")  );
      out.write("</a><br></span></p></center>\n");
      out.write("\n");
      out.write("\n");
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
