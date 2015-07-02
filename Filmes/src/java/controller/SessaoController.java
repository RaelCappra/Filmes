//TODO: buscar sessoes que ainda nao passaram
package controller;

import database.SessaoDao;
import java.util.List;
import model.Sessao;

/**
 *
 * @author Rael
 */
public class SessaoController extends Controller{
    private final SessaoDao sessaoDao = new SessaoDao();
    public void index(){
        List<Sessao> sessoes = sessaoDao.listAll();
        this.request.setAttribute("sessoes", sessoes);
        this.request.setAttribute("sessoesSize", sessoes.size());
        String parameterInicio = request.getParameter("inicio");
        String parameterFim = request.getParameter("fim");
        if(parameterInicio == null || parameterFim == null){
            request.setAttribute("inicio", 0);
            request.setAttribute("fim", 6);
        } else{
            request.setAttribute("inicio", parameterInicio);
            request.setAttribute("fim", parameterFim);
        }
    }
}
