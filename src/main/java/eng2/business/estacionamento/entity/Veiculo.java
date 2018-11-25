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
 * @author vinicius.dufloth
 */
@XmlRootElement
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "veiculos", query = "SELECT v FROM Veiculo v")
public class Veiculo implements Serializable {

    @Id
    @GeneratedValue
    private long id;
    private String modelo;

    public Veiculo() {
    }

    public Veiculo(String modelo) {
        this.modelo = modelo;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }   
}
