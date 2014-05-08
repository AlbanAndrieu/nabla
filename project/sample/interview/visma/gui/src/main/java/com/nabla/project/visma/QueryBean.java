package com.nabla.project.visma;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "input", eager = true)
@SessionScoped
public class QueryBean implements Serializable {

    private static final long serialVersionUID = 1L;

    public QueryBean() {
        System.out.println("QueryBean started!");
    }

    private String            name;

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @ManagedProperty(value = "#{message}")
    private Message messageBean;

    private String  message;

    public String getMessage() {
        if (this.messageBean != null) {
            this.message = this.messageBean.getMessage();
        }
        return this.message;
    }

    public void setMessageBean(final Message message) {
        this.messageBean = message;
    }

}
