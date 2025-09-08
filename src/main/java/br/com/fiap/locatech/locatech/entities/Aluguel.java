package br.com.fiap.locatech.locatech.entities;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Aluguel {
    private Long id;
    private Long pessoaId; //pessoa_id
    private Long veiculoId;//veiculo_id
    private String veiculoModelo;
    private String pessoaCfp;
    private String pessoaNome;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private BigDecimal valorTotal;
}
