package eng2.business.estacionamento.controll;

import eng2.business.estacionamento.entity.Estacionamento;
import eng2.business.estacionamento.entity.Vaga;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vinicius
 */
@Stateless
public class SaidaControll {

    @PersistenceContext
    EntityManager em;

    public String registrarSaida(int numeroVaga) {
        double valor;
        long tempo;
        try {
            Vaga vaga = (Vaga) em.createQuery("SELECT v FROM Vaga v WHERE v.numero=:numero")
                    .setParameter("numero", numeroVaga)
                    .getSingleResult();

            Estacionamento estacionamento = (Estacionamento) em.createQuery("SELECT e FROM Estacionamento e WHERE e.vaga=:vaga")
                    .setParameter("vaga", vaga)
                    .getSingleResult();

            tempo = ChronoUnit.MINUTES.between(
                    Instant.parse(estacionamento.getHoraentrada()),
                    Instant.now());

            valor = tempo * estacionamento.getTarifa().getValorminuto();

            em.remove(estacionamento);
        } catch (EntityNotFoundException e) {
            return "vaga não existe ou não está ocupada!";
        } catch (Exception e) {
            return e.getMessage();
        }

        return Json.createObjectBuilder().
                add("valor", valor).
                add("tempo", tempo).
                build().toString();
    }
}
