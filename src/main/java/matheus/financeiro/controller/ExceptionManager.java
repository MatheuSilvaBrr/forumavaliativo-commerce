package matheus.financeiro.controller;

import java.util.NoSuchElementException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import matheus.financeiro.exception.CpfCnpjInvalidoException;
import matheus.financeiro.exception.IdParametroDiferenteIdEntidadeException;
import matheus.financeiro.exception.ProdutoNaoExisteNoEstoqueException;
import matheus.financeiro.exception.RegistroDuplicadoException;
import matheus.financeiro.exception.TipoPessoaInvalidoException;


@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler({NoSuchElementException.class, EmptyResultDataAccessException.class})
    public ResponseEntity<Void> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(RegistroDuplicadoException.class)
    public ResponseEntity<Void> handleConflict() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler({IdParametroDiferenteIdEntidadeException.class, TipoPessoaInvalidoException.class, CpfCnpjInvalidoException.class, ProdutoNaoExisteNoEstoqueException.class})
    public ResponseEntity<Void> handleBadRequest() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

    
}
