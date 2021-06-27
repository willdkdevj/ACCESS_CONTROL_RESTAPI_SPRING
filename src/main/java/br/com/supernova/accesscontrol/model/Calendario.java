package br.com.supernova.accesscontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Calendario {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private TipoData data;

    private String descricao;

    private LocalDateTime dataEspecial;
}
