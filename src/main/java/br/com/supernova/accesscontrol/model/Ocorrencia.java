package br.com.supernova.accesscontrol.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
public class Ocorrencia {

    @Id
    @GeneratedValue
    private Long id;

    private String nomeOcorrencia;

    private String descricao;
}
