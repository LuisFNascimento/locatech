package br.com.fiap.locatech.locatech.repositories;

import br.com.fiap.locatech.locatech.entities.Pessoa;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PessoaRepositoryImp implements PessoaRepository{

    private final JdbcClient jdbcClient;

    public PessoaRepositoryImp(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

@Override
public Optional<Pessoa> findById(Long id) {
        return this.jdbcClient
                .sql("SELECT * FROM pessoas WHERE id = :id")
                .param("id", id)
                .query(Pessoa.class)
                .optional();
    }

@Override
public List<Pessoa> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM pessoa LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Pessoa.class)
                .list();
    }

@Override
public Integer save(Pessoa pessoa) {
        return this.jdbcClient
                .sql("INSERT INTO pessoa (marca, modelo, placa, ano, cor, valor_diaria) VALUES (:marca, :modelo, :placa, :ano, :cor, :valor_diaria)")
                .param("marca", pessoa.getMarca())
                .param("modelo", pessoa.getModelo())
                .param("placa", pessoa.getPlaca())
                .param("ano", pessoa.getAno())
                .param("cor", pessoa.getCor())
                .param("valor_diaria", pessoa.getValorDiaria())
                .update();
    }

@Override
public Integer update(Pessoa pessoa, Long id) {
        return this.jdbcClient
                .sql("UPDATE pessoa SET marca = :marca, modelo = :modelo, ano = :ano, cor = :cor, valor_diaria = :valor_diaria WHERE id = :id")
                .param("id", id)
                .param("marca", pessoa.getMarca())
                .param("modelo", pessoa.getModelo())
                .param("placa", pessoa.getPlaca())
                .param("ano", pessoa.getAno())
                .param("cor", pessoa.getCor())
                .param("valor_diaria", pessoa.getValorDiaria())
                .update();
    }
    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM pessoa WHERE id = :id")
                .param("id", id)
                .update();
    }
}
