package itmo;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Math;
import java.util.ArrayList;


public class AreaCheckServlet extends HttpServlet {
    private double arrR[] = new double[]{1,2,3,4,5};

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String valueX = request.getParameter("valueX");
        String valueY = request.getParameter("valueY");
        String valueR = request.getParameter("valueR");
        double x,y,r;
        try {
            x = Double.parseDouble(valueX);
            y = Double.parseDouble(valueY);
            r = Double.parseDouble(valueR);

            String res ;
            boolean ok1 = false;

            for(int i=0;i<arrR.length;i++) if (arrR[i]==r) ok1 = true;

            if ((y>3) || (y<-5)  || (!ok1) ) res = "ERROR";
            else{
                if (x<=0 && y<=0){
                    if (x<-r || (y<-r/2)) res = "FALSE";
                    else res = "TRUE";
                }else if (x>0 && y<0){
                    if (Math.sqrt(Math.pow(x,2) + Math.pow(y,2))<=r) res = "TRUE";
                    else res = "FALSE";
                }else if (x>0 && y>0){
                    if (x+y <= r/2) res = "TRUE";
                    else res = "FALSE";
                }else res = "FALSE";
            }

            PointBean bean = new PointBean();
            PointList pointList = (PointList) session.getAttribute("BeanPoints");

            if(pointList==null)
            {
                pointList = new PointList();
                pointList.setList(new ArrayList<>());
            }

            bean.setX(x);
            bean.setY(y);
            bean.setR(r);
            bean.setRes(res);
            pointList.getList().add(bean);
            session.setAttribute("BeanPoints", pointList);

            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.println("<p class = \"center\">Result</p>");
            out.println("<div style =\"margin-top: 2%\">");
            out.println("<table id = \"tableresult\" class = \"center\" border=\"5\" width=\"50%\">");
            out.println("<tr style=\"width: 300px\">");
            out.println("<th> No </th>");
            out.println("<th>Value X</th>");
            out.println("<th>Value Y</th>");
            out.println("<th>Value R</th>");
            out.println("<th>Result</th>");
            out.println("</tr>");
            for(int i =0;i<pointList.getList().size();i++){
                out.println("<tr style=\"width: 300px\">");
                out.println("<th>"+ i + "</th>");

                out.printf("<th>%.3f</th>\n", pointList.getList().get(i).getX());
                out.printf("<th>%.3f</th>\n", pointList.getList().get(i).getY());
                out.printf("<th>%.3f</th>\n", pointList.getList().get(i).getR());
                out.println("<th>"+ pointList.getList().get(i).getRes() + "</th>");
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</div>");
            out.println("<a href=\"index.jsp\" id=\"back-link\">another input</a>");

        }catch (NumberFormatException e){
            request.getServletContext().getRequestDispatcher("/index.jsp").forward(request,response);
        }
    }
}

