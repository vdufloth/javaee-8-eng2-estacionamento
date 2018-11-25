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
 * @author vinicius.dufloth
 */
@XmlRootElement
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name="vagas", query="SELECT v FROM Vaga v")
@NamedQuery(name="vagasLivres", query="SELECT v FROM Vaga v, Estacionamento e "
                                             + "WHERE v NOT IN e")
public class Vaga implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    private int numero;
    private String descricao;   
    
    public Vaga (){
    }
    
    public Vaga (int numero, String desc){
        this.numero = numero;
        this.descricao = desc;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }    
}
