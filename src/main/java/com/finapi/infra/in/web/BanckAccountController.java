package com.finapi.infra.in.web;

import com.finapi.application.dto.request.CreateBankAccountDTO;
import com.finapi.application.dto.response.ResponseBankAccountDTO;
import com.finapi.application.service.BankAccountService;
import com.finapi.config.RequiresAuthentication;
import com.finapi.domain.model.BankAccount;
import com.finapi.infra.out.mapper.BankAccountMapper;
import com.finapi.infra.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/bank-accounts")
public class BanckAccountController {

    private final BankAccountService bankAccountService;
    private final JwtUtil jwtUtil;

    public BanckAccountController(BankAccountService bankAccountService, JwtUtil jwtUtil) {
        this.bankAccountService = bankAccountService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    @RequiresAuthentication
    public ResponseBankAccountDTO createBankAccount(@RequestBody CreateBankAccountDTO createBankAccountDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        createBankAccountDTO.setUserId(userId);

        BankAccount bankAccount = bankAccountService.createBankAccount(createBankAccountDTO);
        return BankAccountMapper.toDTO(bankAccount);
    }

    @GetMapping
    @RequiresAuthentication
    public List<ResponseBankAccountDTO> getBankAccounts() {
        return BankAccountMapper.toDTOList(bankAccountService.getBankAccounts());
    }

    @GetMapping("/{bankAccountId}")
    @RequiresAuthentication
    public ResponseBankAccountDTO getBankAccount(@PathVariable UUID bankAccountId) {
        return BankAccountMapper.toDTO(bankAccountService.getBankAccountById(bankAccountId));
    }

    @PutMapping("/{bankAccountId}")
    @RequiresAuthentication
    public ResponseBankAccountDTO updateBankAccount(@PathVariable UUID bankAccountId, @RequestBody CreateBankAccountDTO createBankAccountDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        createBankAccountDTO.setUserId(userId);

        BankAccount bankAccount = bankAccountService.updateBank(bankAccountId, createBankAccountDTO);
        return BankAccountMapper.toDTO(bankAccount);
    }

    @DeleteMapping("/{bankAccountId}")
    @RequiresAuthentication
    public void deleteBankAccount(@PathVariable UUID bankAccountId) {
        bankAccountService.deleteBank(bankAccountId);
    }
}
