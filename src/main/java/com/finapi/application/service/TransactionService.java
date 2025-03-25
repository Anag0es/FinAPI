package com.finapi.application.service;

import com.finapi.application.dto.request.CreateTransactionDTO;
import com.finapi.application.port.in.transaction.CreateTransactionUseCase;
import com.finapi.application.port.in.transaction.DeleteTransactionUseCase;
import com.finapi.application.port.in.transaction.GetTransactionUseCase;
import com.finapi.application.port.in.transaction.UpdateTransactionUseCase;
import com.finapi.application.port.out.*;
import com.finapi.domain.model.Transaction;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionService implements CreateTransactionUseCase, GetTransactionUseCase, UpdateTransactionUseCase, DeleteTransactionUseCase {

    private final TransactionRepository transactionRepository;
    private final TagRepository tagRepository;
    private final CardRepository cardRepository;
    private final BankAccountRepository bankRepository;
    private final UserRepository userRepository;

    public TransactionService(TransactionRepository transactionRepository, TagRepository tagRepository, CardRepository cardRepository, BankAccountRepository bankRepository, UserRepository userRepository) {
        this.transactionRepository = transactionRepository;
        this.tagRepository = tagRepository;
        this.cardRepository = cardRepository;
        this.bankRepository = bankRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Transaction createTransaction(CreateTransactionDTO createTransactionDTO) {
        Transaction transaction = new Transaction();
        transaction.setType(createTransactionDTO.getType());
        transaction.setAmount(createTransactionDTO.getAmount());
        transaction.setDescription(createTransactionDTO.getDescription());
        transaction.setPeriodicity(createTransactionDTO.getPeriodicity());
        transaction.setAvailableBalance(createTransactionDTO.isAvailableBalance());
        transaction.setBankAccount(createTransactionDTO.getBankAccountId() != null ? bankRepository.findById(createTransactionDTO.getBankAccountId()) : null);
        transaction.setCard(createTransactionDTO.getCardId() != null ? cardRepository.findById(createTransactionDTO.getCardId()) : null);
        transaction.setUser(userRepository.findById(createTransactionDTO.getUserId()));
        transaction.setTag(tagRepository.findByIds(createTransactionDTO.getTagIds()));
        transaction.setStatus(createTransactionDTO.getStatus());

        transaction.setCreatedAt(LocalDateTime.now());
        transaction.setUpdatedAt(LocalDateTime.now());


        return transactionRepository.save(transaction);
    }

    @Override
    public void deleteTransactionById(UUID id) {

    }

    @Override
    public List<Transaction> getTransactions() {
        return List.of();
    }

    @Override
    public Transaction getTransactionById(Long id) {
        return null;
    }

    @Override
    public List<Transaction> getTransactionsForUser(Long userId) {
        return List.of();
    }

    @Override
    public List<Transaction> getTransactionsForTag(Long tagId) {
        return List.of();
    }

    @Override
    public Transaction updateTransaction(UUID transactionId, CreateTransactionDTO transactionDTO) {
        return null;
    }
}
