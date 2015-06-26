package controller;

import java.io.IOException;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.http.*;

public abstract class Controller {
    public static final String URL_VIEW = "/WEB-INF/jsp/";    
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected boolean hasPageJsp;

    public Controller() {
        this.hasPageJsp = true;
    }

    public boolean hasPageJsp() {
        return hasPageJsp;
    }

    public void setHasPageJsp(boolean hasPageJsp) {
        this.hasPageJsp = hasPageJsp;
    } 

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public HttpServletResponse getResponse() {
        return response;
    }

    public void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    public void redirect(Class controller, String methodName) {
        try {
            RequestDispatcher rd = request.getRequestDispatcher("/Servlet?controller=" + controller.getSimpleName().replace("Controller", "").toLowerCase() + "&method=" + methodName);
            rd.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("URL incorreta");
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void redirect(String methodName) {
        this.redirect(this.getClass(), methodName);
    }

    // interceptadores
    
    // função que é executada antes de todo metodo de controle
    public void before() {
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("Antes......" + request.getQueryString());
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("==================================");

    }
    // função que é executada depois de todo metodo de controle
    public void after() {
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("Depois......" + request.getQueryString());
        System.out.println("==================================");
        System.out.println("==================================");
        System.out.println("==================================");
    }
}
