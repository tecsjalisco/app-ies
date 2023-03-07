package mx.core.sec.cgi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(filterName = "SesionFilter", urlPatterns = {"/*"})
public class SessionFilter implements Filter {
 
    private FilterConfig filterConfig = null;
    private List<String> ALLOWED_PATHS = new ArrayList();
    
    public SessionFilter() {}

    public void doFilter(ServletRequest request, ServletResponse response,FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setHeader("Cache-Control", "no-cache");
        res.setDateHeader("Expires",0);
        HttpSession websession = req.getSession(false);
        String url = req.getContextPath()+"/login.jsp";
        String path = req.getRequestURI().substring(req.getContextPath().length()).replaceAll("[/]+$", ""); 
        
        ALLOWED_PATHS.add("/lib/jquery/jquery-3.4.1.min.js");
        ALLOWED_PATHS.add("/lib/jquery/jquery.redirect.js");
        ALLOWED_PATHS.add("/lib/bootstrap/bootstrap.min.js");
        ALLOWED_PATHS.add("/lib/bootstrap/bootstrap.min.css");
        ALLOWED_PATHS.add("/lib/dhtmlx/codebase/dhtmlx.js");
        ALLOWED_PATHS.add("/lib/dhtmlx/skins/material/dhtmlx.css");
        ALLOWED_PATHS.add("/main.css");
        ALLOWED_PATHS.add("/spin.js");
        
        ALLOWED_PATHS.add("/img/login.jpg");
        ALLOWED_PATHS.add("/login.jsp");
        ALLOWED_PATHS.add("/login.js");
        ALLOWED_PATHS.add("/sec/login");
        ALLOWED_PATHS.add("/sec/login");

        boolean loggedIn = (websession != null && websession.getAttribute("user") != null);
        boolean allowedPath = ALLOWED_PATHS.contains(path);
        
        if (loggedIn || allowedPath) {
            if(loggedIn && (path.equals("/login.jsp"))){
                res.sendRedirect(req.getContextPath()+"/index.jsp");
            }
            //System.out.print("1 path: "+path+", loggIn: "+loggedIn+", allowedPath: "+allowedPath);
            chain.doFilter(request, response);
        } else {
            //System.out.print("2 path: "+path+", loggIn: "+loggedIn+", allowedPath: "+allowedPath);
            res.sendRedirect(url);
        }

    }

    @Override
    public void destroy() {}
    @Override
    public void init(FilterConfig filterConfig) {        
        this.filterConfig = filterConfig;
    }
}
