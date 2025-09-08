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
                .sql("SELECT * FROM alugueis WHERE id = :id")
                .param("id", id)
                .query(Pessoa.class)
                .optional();
    }

@Override
public List<Pessoa> findAll(int size, int offset) {
        return this.jdbcClient
                .sql("SELECT * FROM alugueis LIMIT :size OFFSET :offset")
                .param("size", size)
                .param("offset", offset)
                .query(Pessoa.class)
                .list();
    }

@Override
public Integer save(Pessoa pessoa) {
        return this.jdbcClient
                .sql("INSERT INTO alugueis (nome, cpf, telefone, email) VALUES (:nome, :cpf, :telefone, :email)")
                .param("nome", pessoa.getNome())
                .param("cpf", pessoa.getCpf())
                .param("telefone", pessoa.getTelefone())
                .param("email", pessoa.getEmail())
                .update();
    }

@Override
public Integer update(Pessoa pessoa, Long id) {
        return this.jdbcClient
                .sql("UPDATE alugueis SET nome = :nome, cpf = :cpf, telefone = :telefone, email = :email WHERE id = :id")
                .param("id", id)
                .param("nome", pessoa.getNome())
                .param("cpf", pessoa.getCpf())
                .param("telefone", pessoa.getTelefone())
                .param("email", pessoa.getEmail())
                .update();
    }
    @Override
    public Integer delete(Long id) {
        return this.jdbcClient
                .sql("DELETE FROM alugueis WHERE id = :id")
                .param("id", id)
                .update();
    }
}
