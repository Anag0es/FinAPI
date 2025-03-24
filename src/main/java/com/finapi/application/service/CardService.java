package com.finapi.application.service;

import com.finapi.application.dto.request.CreateCardDTO;
import com.finapi.application.exception.ApiException;
import com.finapi.application.port.in.card.CreateCardUseCase;
import com.finapi.application.port.in.card.DeleteCardUseCase;
import com.finapi.application.port.in.card.GetCardUseCase;
import com.finapi.application.port.in.card.UpdateCardUseCase;
import com.finapi.application.port.out.CardRepository;
import com.finapi.domain.model.Card;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class CardService implements CreateCardUseCase, GetCardUseCase, UpdateCardUseCase, DeleteCardUseCase {

    private final CardRepository cardRepository;
    private final UserService userService;


    public CardService(CardRepository cardRepository, UserService userService) {
        this.cardRepository = cardRepository;
        this.userService = userService;
    }

    @Override
    public Card createCard(CreateCardDTO createCardDTO) {
        if (cardRepository.findByName(createCardDTO.getName()) != null) {
            throw new ApiException("Já existe um cartão com esse nome", HttpStatus.BAD_REQUEST);
        }

        Card card = new Card();
        card.setName(createCardDTO.getName());
        card.setBand(createCardDTO.getBand());
        card.setExpiration(createCardDTO.getExpiration());
        card.setLimitAmount(createCardDTO.getLimitAmount());
        card.setName(createCardDTO.getName());
        card.setNumber(createCardDTO.getNumber());
        card.setStatus(createCardDTO.getStatus());
        card.setType(createCardDTO.getType());
        card.setUser(userService.getUserById(createCardDTO.getUser()));
        card.setCreatedAt(LocalDateTime.now());
        card.setUpdatedAt(LocalDateTime.now());

        return cardRepository.save(card);

    }

    @Override
    public Card getCardById(UUID id) {
        Card card = cardRepository.findById(id);
        if (card == null) {
            throw new ApiException("Cartão não encontrado", HttpStatus.NOT_FOUND);
        }

        return card;
    }

    @Override
    public List<Card> getCards() {
        return cardRepository.findAll();
    }

    @Override
    public Card updateCard(UUID cardId, CreateCardDTO card) {
        Card cardToUpdate = cardRepository.findById(cardId);

        if (cardToUpdate == null) {
            throw new ApiException("Cartão não encontrado", HttpStatus.NOT_FOUND);
        }

        cardToUpdate.setName(card.getName());
        cardToUpdate.setType(card.getType());
        cardToUpdate.setNumber(card.getNumber());
        cardToUpdate.setBand(card.getBand());
        cardToUpdate.setExpiration(card.getExpiration());
        cardToUpdate.setLimitAmount(card.getLimitAmount());
        cardToUpdate.setStatus(card.getStatus());
        cardToUpdate.setUpdatedAt(LocalDateTime.now());

        return cardRepository.updateCard(cardId, cardToUpdate);
    }

    @Override
    public void deleteCardById(UUID id) {
        Card card = cardRepository.findById(id);
        if (card == null) {
            throw new ApiException("Cartão não encontrado", HttpStatus.NOT_FOUND);
        }

        cardRepository.deleteById(id);
    }
}
