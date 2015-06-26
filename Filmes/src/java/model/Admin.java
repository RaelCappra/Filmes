/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author aluno
 */
public class Admin {
    private String login;
    private String md5senha;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMd5senha() {
        return md5senha;
    }

    public void setMd5senha(String md5senha) {
        this.md5senha = md5senha;
    }

    public Admin(String login, String md5senha) {
        this.login = login;
        this.md5senha = md5senha;
    }

    public Admin() {
    }
}
