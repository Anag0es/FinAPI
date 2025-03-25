package com.finapi.infra.in.web;

import com.finapi.application.dto.request.CreateCardDTO;
import com.finapi.application.dto.response.ResponseCardDTO;
import com.finapi.application.service.CardService;
import com.finapi.config.RequiresAuthentication;
import com.finapi.domain.model.Card;
import com.finapi.infra.out.mapper.CardMapper;
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
    public ResponseCardDTO createCard(@RequestBody CreateCardDTO createCardDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        createCardDTO.setUser(userId);

        Card card = cardService.createCard(createCardDTO);
        return CardMapper.toDTO(card);
    }

    @GetMapping
    @RequiresAuthentication
    public List<ResponseCardDTO> getCards() {
        return CardMapper.toDTOList(cardService.getCards());
    }

    @GetMapping("/{cardId}")
    @RequiresAuthentication
    public ResponseCardDTO getCard(@PathVariable UUID cardId) {

        return CardMapper.toDTO(cardService.getCardById(cardId));
    }

    @PutMapping("/{cardId}")
    @RequiresAuthentication
    public ResponseCardDTO updateCard(@PathVariable UUID cardId, @RequestBody CreateCardDTO createCardDTO, HttpServletRequest request) {
        String token = request.getHeader("Authorization").substring(7);
        UUID userId = jwtUtil.getUserIdFromToken(token);

        createCardDTO.setUser(userId);

        Card card = cardService.updateCard(cardId, createCardDTO);
        return CardMapper.toDTO(card);
    }

    @DeleteMapping("/{cardId}")
    @RequiresAuthentication
    public void deleteCard(@PathVariable UUID cardId) {
        cardService.deleteCardById(cardId);
    }
}