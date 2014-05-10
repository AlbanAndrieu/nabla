package com.nabla.project.visma;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class NavigationBean implements Serializable {

    private static final long serialVersionUID = -1074473345848765304L;

    /**
     * Redirect to payment page.
     * @return Payment page name.
     */
    public String redirectToPayment() {
        return "payment?faces-redirect=true";
    }

}
