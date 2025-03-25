package com.finapi.infra.out.mapper;

import com.finapi.application.dto.response.ResponseCardDTO;
import com.finapi.domain.model.Card;
import com.finapi.infra.out.entity.CardEntity;

import java.util.List;
import java.util.stream.Collectors;

public class CardMapper {

    public static Card toDomain(CardEntity cardEntity) {
        if (cardEntity == null) {
            return null;
        }

        return new Card(
                cardEntity.getId(),
                cardEntity.getName(),
                cardEntity.getType(),
                cardEntity.getNumber(),
                cardEntity.getExpiration(),
                cardEntity.getLimitAmount(),
                cardEntity.getBand(),
                UserMapper.toDomain(cardEntity.getUser()),
                cardEntity.getStatus(),
                cardEntity.getCreatedAt(),
                cardEntity.getUpdatedAt()
        );
    }

    public static CardEntity toEntity(Card card) {
        if (card == null) {
            return null;
        }

        return new CardEntity(
                card.getId(),
                card.getName(),
                card.getNumber(),
                card.getExpiration(),
                card.getLimitAmount(),
                card.getBand(),
                card.getCreatedAt(),
                card.getUpdatedAt(),
                card.getStatus(),
                card.getType(),
                UserMapper.toEntity(card.getUser())
        );
    }

    public static ResponseCardDTO toDTO(Card card) {
        if (card == null) return null;

        return new ResponseCardDTO(
                card.getName(),
                card.getType(),
                card.getNumber(),
                card.getExpiration(),
                card.getLimitAmount(),
                card.getBand(),
                card.getUser().getId(),
                card.getStatus()
        );
    }

    public static List<ResponseCardDTO> toDTOList(List<Card> card) {
        return card.stream()
                .map(CardMapper::toDTO)
                .collect(Collectors.toList());
    }
}
