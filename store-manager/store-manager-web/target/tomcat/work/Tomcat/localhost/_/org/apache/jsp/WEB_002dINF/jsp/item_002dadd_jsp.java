/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2018-04-29 01:02:16 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class item_002dadd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("<link href=\"/js/kindeditor-4.1.10/themes/default/default.css\" type=\"text/css\" rel=\"stylesheet\">\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/kindeditor-4.1.10/kindeditor-all-min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" charset=\"utf-8\" src=\"/js/kindeditor-4.1.10/lang/en.js\"></script>\r\n");
      out.write("<div style=\"padding:10px 10px 10px 10px\">\r\n");
      out.write("    <form id=\"itemAddForm\" class=\"itemForm\" method=\"post\">\r\n");
      out.write("        <table cellpadding=\"5\">\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品类目:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"easyui-linkbutton selectItemCat\">选择类目</a>\r\n");
      out.write("                    <input type=\"hidden\" name=\"cid\" style=\"width: 280px;\"></input>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品标题:</td>\r\n");
      out.write("                <td><input class=\"easyui-textbox\" type=\"text\" name=\"title\" data-options=\"required:true\"\r\n");
      out.write("                           style=\"width: 280px;\"></input></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品卖点:</td>\r\n");
      out.write("                <td><input class=\"easyui-textbox\" name=\"sellPoint\"\r\n");
      out.write("                           data-options=\"multiline:true,validType:'length[0,150]'\"\r\n");
      out.write("                           style=\"height:60px;width: 280px;\"></input></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品价格:</td>\r\n");
      out.write("                <td><input class=\"easyui-numberbox\" type=\"text\" name=\"priceView\"\r\n");
      out.write("                           data-options=\"min:1,max:99999999,precision:2,required:true\"/>\r\n");
      out.write("                    <input type=\"hidden\" name=\"price\"/>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>库存数量:</td>\r\n");
      out.write("                <td><input class=\"easyui-numberbox\" type=\"text\" name=\"num\"\r\n");
      out.write("                           data-options=\"min:1,max:99999999,precision:0,required:true\"/></td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>条形码:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <input class=\"easyui-textbox\" type=\"text\" name=\"barcode\" data-options=\"validType:'length[1,30]'\"/>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品图片:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <a href=\"javascript:void(0)\" class=\"easyui-linkbutton imageUpload\">上传图片</a>\r\n");
      out.write("                    <input type=\"hidden\" name=\"image\"/>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td>商品描述:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("                    <textarea style=\"width:800px;height:300px;visibility:hidden;\" name=\"desc\"></textarea>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr class=\"params hide\">\r\n");
      out.write("                <td>商品规格:</td>\r\n");
      out.write("                <td>\r\n");
      out.write("\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </table>\r\n");
      out.write("        <input type=\"hidden\" name=\"itemParams\"/>\r\n");
      out.write("    </form>\r\n");
      out.write("    <div style=\"padding:5px\">\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"submitForm()\">提交</a>\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"clearForm()\">重置</a>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("    var itemAddEditor;\r\n");
      out.write("    //页面初始化完毕后执行此方法\r\n");
      out.write("    $(function () {\r\n");
      out.write("        //创建富文本编辑器\r\n");
      out.write("        itemAddEditor = HuaStore.createEditor(\"#itemAddForm [name=desc]\");\r\n");
      out.write("        //初始化类目选择和图片上传器\r\n");
      out.write("        HuaStore.init({\r\n");
      out.write("            fun: function (node) {\r\n");
      out.write("                //根据商品的分类id取商品 的规格模板，生成规格信息。第四天内容。\r\n");
      out.write("                //HuaStore.changeItemParam(node, \"itemAddForm\");\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    });\r\n");
      out.write("\r\n");
      out.write("    //提交表单\r\n");
      out.write("    function submitForm() {\r\n");
      out.write("        //有效性验证\r\n");
      out.write("        if (!$('#itemAddForm').form('validate')) {\r\n");
      out.write("            $.messager.alert('提示', '表单还未填写完成!');\r\n");
      out.write("            return;\r\n");
      out.write("        }\r\n");
      out.write("        //取商品价格，单位为“分”\r\n");
      out.write("        $(\"#itemAddForm [name=price]\").val(eval($(\"#itemAddForm [name=priceView]\").val()) * 100);\r\n");
      out.write("        //同步文本框中的商品描述\r\n");
      out.write("        itemAddEditor.sync();\r\n");
      out.write("        //取商品的规格\r\n");
      out.write("        /*\r\n");
      out.write("        var paramJson = [];\r\n");
      out.write("        $(\"#itemAddForm .params li\").each(function(i,e){\r\n");
      out.write("            var trs = $(e).find(\"tr\");\r\n");
      out.write("            var group = trs.eq(0).text();\r\n");
      out.write("            var ps = [];\r\n");
      out.write("            for(var i = 1;i<trs.length;i++){\r\n");
      out.write("                var tr = trs.eq(i);\r\n");
      out.write("                ps.push({\r\n");
      out.write("                    \"k\" : $.trim(tr.find(\"td\").eq(0).find(\"span\").text()),\r\n");
      out.write("                    \"v\" : $.trim(tr.find(\"input\").val())\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("            paramJson.push({\r\n");
      out.write("                \"group\" : group,\r\n");
      out.write("                \"params\": ps\r\n");
      out.write("            });\r\n");
      out.write("        });\r\n");
      out.write("        //把json对象转换成字符串\r\n");
      out.write("        paramJson = JSON.stringify(paramJson);\r\n");
      out.write("        $(\"#itemAddForm [name=itemParams]\").val(paramJson);\r\n");
      out.write("        */\r\n");
      out.write("        //ajax的post方式提交表单\r\n");
      out.write("        //$(\"#itemAddForm\").serialize()将表单序列号为key-value形式的字符串\r\n");
      out.write("        $.post(\"/item/add\", $(\"#itemAddForm\").serialize(), function (data) {\r\n");
      out.write("            if (data.status == 200) {\r\n");
      out.write("                $.messager.alert('提示', '新增商品成功!');\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    function clearForm() {\r\n");
      out.write("        $('#itemAddForm').form('reset');\r\n");
      out.write("        itemAddEditor.html('');\r\n");
      out.write("    }\r\n");
      out.write("</script>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
