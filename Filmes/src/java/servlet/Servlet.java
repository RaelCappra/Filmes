package servlet;

import controller.Controller;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.NoSuchMethodException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException {

        if ((null == request.getParameter("method") || request.getParameter("controller") == null)) {
            throw new ServletException("A variável controller e/ou method não foi/foram setadas....");
        } else {
            String name = "controller." + request.getParameter("controller").substring(0, 1).toUpperCase() + request.getParameter("controller").substring(1) + "Controller";
            Class classController;
            try {
                classController = Class.forName(name);
            } catch (ClassNotFoundException e) {
                throw new ServletException("Não xxx encontrou a classe " + name + ".....");
            }
            // verificando se a classe implementa a interface IController
            if (!Controller.class.isAssignableFrom(classController)) {
                throw new ServletException("A classe " + name + " não implementa a interface Controller...");
            }
            // objeto da classe
            Controller objectController;
            try {
                // instanciando o objeto
                objectController = (Controller) classController.newInstance();
                // setando os atributos (request e response)
                objectController.setRequest(request);
                objectController.setResponse(response);

                try {
                    // recuperando o metodo que esta vindo pela URL
                    Method method = classController.getMethod(request.getParameter("method"));
                    // invocando o metodo before
                    objectController.before();
                    // invocando o metodo
                    method.invoke(objectController);
                    // invocando o metodo before
                    objectController.after();
                    // redirecionando para a pagina com o mesmo nome do método do controller
                    try {
                        if (objectController.hasPageJsp() && !response.isCommitted()) {
                            String url = Controller.URL_VIEW + request.getParameter("controller") + "/" + request.getParameter("method") + ".jsp";
                            RequestDispatcher rd = request.getRequestDispatcher(url);
                            rd.forward(request, response);
                        } else{
                            
                        }
                    } catch (ServletException | IOException e) {
                        System.out.println(e.getMessage());
                        throw new ServletException("Não há a página " + request.getParameter("method") + " dentro do diretório  " + request.getParameter("controller"));
                    }
                } catch (NoSuchMethodException e) {
                    throw new ServletException("Não há o método " + request.getParameter("method") + " solicitado no controller " + request.getParameter("controller"));
                }
            } catch (InstantiationException | IllegalAccessException e) {
                throw new ServletException("Na classe " + classController.getName() + " nao existe o metodo...." + request.getParameter("method"));
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (IllegalArgumentException | InvocationTargetException | NoSuchMethodException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
