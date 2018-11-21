/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eng2.business.estacionamento.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vld
 */
@XmlRootElement
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "tarifas", query = "SELECT t FROM Tarifa t")
public class Tarifa implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String descricao;
    private Double valorminuto;
    
    public Tarifa() {
    }

    public Tarifa(String descricao, Double valorminuto) {
        this.descricao = descricao;
        this.valorminuto = valorminuto;
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorminuto() {
        return valorminuto;
    }

    public void setValorminuto(Double valorminuto) {
        this.valorminuto = valorminuto;
    }


}
