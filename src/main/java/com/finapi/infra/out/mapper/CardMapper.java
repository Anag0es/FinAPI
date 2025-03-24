package com.finapi.infra.out.mapper;

import com.finapi.domain.model.Card;
import com.finapi.infra.out.entity.CardEntity;

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
}
