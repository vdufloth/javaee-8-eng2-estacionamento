package eng2.business.estacionamento.entity;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author vld
 */
@XmlRootElement
@Entity
@XmlAccessorType(XmlAccessType.FIELD)
@NamedQuery(name = "estacionamentos", query = "SELECT e FROM Estacionamento e")
public class Estacionamento implements Serializable {
    
    @Id
    @GeneratedValue
    private long id;
    private String cnh;
    private String nomecliente;
    private String horaentrada;
    @OneToOne(cascade=CascadeType.ALL)
    private Tarifa tarifa;
    @OneToOne(fetch = FetchType.LAZY)
    private Veiculo veiculo;
    @OneToOne(fetch = FetchType.LAZY)
    private Vaga vaga;

    public Estacionamento() {
    }

    public Estacionamento(String cnh, String nomecliente, String horaentrada) {
        this.cnh = cnh;
        this.nomecliente = nomecliente;
        this.horaentrada = horaentrada;
    }

    public long getId() {
        return id;
    }

    public Tarifa getTarifa() {
        return tarifa;
    }

    public void setTarifa(Tarifa tarifa) {
        this.tarifa = tarifa;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getNomecliente() {
        return nomecliente;
    }

    public void setNomecliente(String nomecliente) {
        this.nomecliente = nomecliente;
    }

    public String getHoraentrada() {
        return horaentrada;
    }

    public void setHoraentrada(String horaentrada) {
        this.horaentrada = horaentrada;
    }

    public Vaga getVaga() {
        return this.vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

}
