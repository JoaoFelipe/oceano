package br.uff.ic.oceano.controller;

import br.uff.ic.oceano.contexto.ConstantesAplicacao;
import br.uff.ic.oceano.core.model.OceanoUser;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Kann
 */
public final class SessaoDoUsuario {

    private String identificador;
    private OceanoUser usuarioCorrente;
    private List<SelectItem> idiomsList;
    private String idiom;

    public SessaoDoUsuario() {        
        idiom = "en_US";
        changeIdiom();
    }

    public void changeIdiom() {
        String[] split = this.idiom.split("_");
        Locale locale = new Locale(split[0], split[1]);
        
        FacesContext instance = FacesContext.getCurrentInstance();
        if(instance != null && instance.getViewRoot() != null){
             instance.getViewRoot().setLocale(locale);
        }
    }

    public void invalidar() {
        HttpSession s = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
        s.invalidate();
    }

    public OceanoUser getUsuarioCorrente() {
        return usuarioCorrente;
    }

    public String getIdentificador() {
        if (identificador == null) {
            identificador = " " + usuarioCorrente.getName();
        }
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public void setUsuarioCorrente(OceanoUser usuarioCorrente) {
        this.usuarioCorrente = usuarioCorrente;
    }

    public String getImgInterna() {
        return ConstantesAplicacao.IMAGEM_INTERNO;
    }

    public void setPerfilPeixeEspada() {
        ConstantesAplicacao.IMAGEM_INTERNO = ConstantesAplicacao.IMAGEM_PEIXE_ESPADA;
    }

    public void setPerfilOceano() {
        ConstantesAplicacao.IMAGEM_INTERNO = ConstantesAplicacao.IMAGEM_OCEANO;
    }

    public void setPerfilOstra() {
        ConstantesAplicacao.IMAGEM_INTERNO = ConstantesAplicacao.IMAGEM_OSTRA;
    }

    public void setPerfilPolvo() {
        ConstantesAplicacao.IMAGEM_INTERNO = ConstantesAplicacao.IMAGEM_POLVO;
    }

    /**
     * @return the idionsList
     */
    public List<SelectItem> getIdiomsList() {
        if (idiomsList == null) {
            idiomsList = new ArrayList<SelectItem>();
            idiomsList.add(new SelectItem("pt_BR", "Português - Brasil"));
            idiomsList.add(new SelectItem("en_US", "English - US"));            
        }
        return idiomsList;
    }

    /**
     * @param idionsList the idionsList to set
     */
    public void setIdiomsList(List<SelectItem> idionsList) {
        this.idiomsList = idionsList;
    }

    /**
     * @return the idiom
     */
    public String getIdiom() {
        return idiom;
    }

    /**
     * @param idiom the idiom to set
     */
    public void setIdiom(String idiom) {
        this.idiom = idiom;
    }
}
