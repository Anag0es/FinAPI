package com.finapi.infra.in.web;

import com.finapi.application.dto.request.CreateTransactionDTO;
import com.finapi.application.dto.response.ResponseTransactionDTO;
import com.finapi.application.service.TransactionService;
import com.finapi.config.RequiresAuthentication;
import com.finapi.domain.model.BankAccount;
import com.finapi.domain.model.Transaction;
import com.finapi.infra.out.mapper.TransactionMapper;
import com.finapi.infra.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final JwtUtil jwtUtil;

    public TransactionController(TransactionService transactionService, JwtUtil jwtUtil) {
        this.transactionService = transactionService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    @RequiresAuthentication
    public ResponseTransactionDTO createTransaction(@RequestBody CreateTransactionDTO createTransactionDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        createTransactionDTO.setUserId(userId);

        Transaction transaction = transactionService.createTransaction(createTransactionDTO);
        return TransactionMapper.toDTO(transaction);
    }

    @GetMapping
    @RequiresAuthentication
    public List<ResponseTransactionDTO> getTransactions() {
        return TransactionMapper.toDTOList(transactionService.getTransactions());
    }

    @GetMapping("/{transactionId}")
    @RequiresAuthentication
    public ResponseTransactionDTO getTransaction(@PathVariable UUID transactionId) {
        return TransactionMapper.toDTO(transactionService.getTransactionById(transactionId));
    }

    @PutMapping("/{transactionId}")
    @RequiresAuthentication
    public ResponseTransactionDTO updateTransaction(@PathVariable UUID transactionId, @RequestBody CreateTransactionDTO createTransactionDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        createTransactionDTO.setUserId(userId);

        Transaction transaction = transactionService.updateTransaction(transactionId, createTransactionDTO);
        return TransactionMapper.toDTO(transaction);
    }

    @DeleteMapping("/{transactionId}")
    @RequiresAuthentication
    public void deleteTransaction(@PathVariable UUID transactionId) {
        transactionService.deleteTransactionById(transactionId);
    }
}
