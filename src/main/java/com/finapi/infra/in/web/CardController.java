package com.finapi.infra.in.web;

import com.finapi.application.dto.request.CreateCardDTO;
import com.finapi.application.service.CardService;
import com.finapi.config.RequiresAuthentication;
import com.finapi.domain.model.Card;
import com.finapi.infra.security.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/cards")
public class CardController {

    private final CardService cardService;
    private final JwtUtil jwtUtil;


    public CardController(CardService cardService, JwtUtil jwtUtil) {
        this.cardService = cardService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    @RequiresAuthentication
    public Card createCard(@RequestBody CreateCardDTO createCardDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        createCardDTO.setUser(userId);

        return cardService.createCard(createCardDTO);
    }

    @GetMapping
    @RequiresAuthentication
    public List<Card> getCards() {
        return cardService.getCards();
    }

    @GetMapping("/{cardId}")
    @RequiresAuthentication
    public Card getCard(@PathVariable UUID cardId) {

        return cardService.getCardById(cardId);
    }

    @PutMapping("/{cardId}")
    @RequiresAuthentication
    public Card updateCard(@PathVariable UUID cardId, @RequestBody CreateCardDTO createCardDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        createCardDTO.setUser(userId);

        return cardService.updateCard(cardId, createCardDTO);
    }

    @DeleteMapping("/{cardId}")
    @RequiresAuthentication
    public void deleteCard(@PathVariable UUID cardId) {
        cardService.deleteCardById(cardId);
    }
}