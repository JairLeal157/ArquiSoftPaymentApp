/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.udea.pagos.controller;

import com.udea.pagos.ejb.PaymentFacadeLocal;
import com.udea.pagos.modelo.Payment;
import jakarta.faces.component.UIComponent;
import java.util.Date;
import java.util.List;


/**
 *
 * @author jairl
 */
public class Controller {

    @javax.ejb.EJB
    private PaymentFacadeLocal paymentFacade;
    
    public UIComponent myButton;
    private int id;
    private double amount;
    private String name;
    private String email;
    private long card;
    private Date date = new Date();
    private int cvvNo;
    private String password; 
    private String txtPasswordRepeat;
    private boolean disable = true; 
    
    private String sSubcadena;
    private String mensajeCard;
    private String m; 
    
    private List<Payment> payments; 
    
    
    
    public List<Payment> getPayments(){
        if((this.payments == null) || payments.isEmpty()){
            refresh();
        }
        return this.payments; 
    }
    
    public void refresh(){
        this.payments = this.paymentFacade.findAll();
    }
    
    public UIComponent getMyButton() {
        return myButton;
    }

    public void setMyButton(UIComponent myButton) {
        this.myButton = myButton;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCard() {
        return card;
    }

    public void setCard(long card) {
        this.card = card;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getCvvNo() {
        return cvvNo;
    }

    public void setCvvNo(int cvvNo) {
        this.cvvNo = cvvNo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTxtPasswordRepeat() {
        return txtPasswordRepeat;
    }

    public void setTxtPasswordRepeat(String txtPasswordRepeat) {
        this.txtPasswordRepeat = txtPasswordRepeat;
    }

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }

    public String getsSubcadena() {
        return sSubcadena;
    }

    public void setsSubcadena(String sSubcadena) {
        this.sSubcadena = sSubcadena;
    }

    public String getMensajeCard() {
        return mensajeCard;
    }

    public void setMensajeCard(String mensajeCard) {
        this.mensajeCard = mensajeCard;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }
    
    /**
     * Creates a new instance of Controller
     */
    public Controller() {
        
    }
    
    public String guardar(){
        Payment p = new Payment();
        p.setId(id);
        p.setName(name);
        p.setEmail(email);
        p.setAmount(amount);
        p.setCard(card);
        p.setCvvno(cvvNo);
        p.setDate(date);
        this.paymentFacade.create(p);
        m = this.getMensajeCard();
        return "Payment creado";
    }
    
}
