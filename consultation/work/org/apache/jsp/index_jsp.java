package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList(1);
    _jspx_dependants.add("/WEB-INF/castools.tld");
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fcas_005fauth_0026_005fscope_005fid_005fnobody;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _005fjspx_005ftagPool_005fcas_005fauth_0026_005fscope_005fid_005fnobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fcas_005fauth_0026_005fscope_005fid_005fnobody.release();
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\n');
      //  cas:auth
      edu.yale.its.tp.cas.taglib.CasTag _jspx_th_cas_005fauth_005f0 = (edu.yale.its.tp.cas.taglib.CasTag) _005fjspx_005ftagPool_005fcas_005fauth_0026_005fscope_005fid_005fnobody.get(edu.yale.its.tp.cas.taglib.CasTag.class);
      _jspx_th_cas_005fauth_005f0.setPageContext(_jspx_page_context);
      _jspx_th_cas_005fauth_005f0.setParent(null);
      // /index.jsp(2,0) name = id type = java.lang.String reqTime = false required = true fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_cas_005fauth_005f0.setId("user");
      // /index.jsp(2,0) name = scope type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_cas_005fauth_005f0.setScope("session");
      int _jspx_eval_cas_005fauth_005f0 = _jspx_th_cas_005fauth_005f0.doStartTag();
      if (_jspx_th_cas_005fauth_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        _005fjspx_005ftagPool_005fcas_005fauth_0026_005fscope_005fid_005fnobody.reuse(_jspx_th_cas_005fauth_005f0);
        return;
      }
      _005fjspx_005ftagPool_005fcas_005fauth_0026_005fscope_005fid_005fnobody.reuse(_jspx_th_cas_005fauth_005f0);
      java.lang.String user = null;
      user = (java.lang.String) _jspx_page_context.findAttribute("user");
      out.write("\n");
      out.write("<html>\n");
      out.write("<body onload=\"submitform()\">\n");
      out.write("redirection ");
      out.print(session.getAttribute("user"));
      out.write(" !!!<br>\n");
      out.write("<form id=\"myForm\" method=POST action=\"login\">\n");
      out.write("\t<input type=\"hidden\" name=\"nom\" value=\"");
      out.print(session.getAttribute("user"));
      out.write("\"/>\n");
      out.write("</form>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("<script type=\"text/javascript\" language=\"javascript\">\n");
      out.write("function submitform(){\n");
      out.write("\tdocument.getElementById('myForm').submit();\n");
      out.write("}\n");
      out.write("</script>\n");
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
