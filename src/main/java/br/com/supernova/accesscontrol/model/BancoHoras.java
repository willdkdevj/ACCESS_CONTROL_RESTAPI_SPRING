package br.com.supernova.accesscontrol.model;

import lombok.*;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class BancoHoras {

    @Embeddable
    @Getter
    @Setter
    @EqualsAndHashCode
    private class BancoHorasID implements Serializable {
        private Long bancoHorasID;
        private Long movimentacaoID;
        private Long usuarioID;
    }

    @EmbeddedId
    private BancoHorasID bancoHorasID;
    private LocalDateTime dataTabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;
}
