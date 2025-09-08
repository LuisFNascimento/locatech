package br.com.fiap.locatech.locatech.dtos;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record AluguelRequestDTO(
        Long pessoaId,
        Long veiculoId,
        LocalDate dataInicio,
        LocalDate dataFim
) {
}
