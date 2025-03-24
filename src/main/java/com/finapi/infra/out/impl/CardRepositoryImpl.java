package com.finapi.infra.out.impl;

import com.finapi.application.port.out.CardRepository;
import com.finapi.domain.model.Card;
import com.finapi.infra.out.entity.CardEntity;
import com.finapi.infra.out.mapper.CardMapper;
import com.finapi.infra.out.repository.CardJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class CardRepositoryImpl implements CardRepository {

    @Autowired
    private CardJpaRepository cardJpaRepository;

    @Override
    public Card save(Card card) {
        CardEntity cardEntity = CardMapper.toEntity(card);
        CardEntity savedCardEntity = cardJpaRepository.save(cardEntity);

        return CardMapper.toDomain(savedCardEntity);
    }

    @Override
    public Card findById(UUID id) {
        CardEntity cardEntity = cardJpaRepository.findById(id).orElse(null);

        return CardMapper.toDomain(cardEntity);
    }

    @Override
    public List<Card> findAll() {
        List<CardEntity> entities = cardJpaRepository.findAll();

        return entities.stream().map(CardMapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public Card updateCard(UUID id, Card card) {
        CardEntity cardEntity = cardJpaRepository.findById(id).orElse(null);
        if (cardEntity == null) {
            return null;
        }

        // Only update fields that are not null
        if (card.getName() != null) cardEntity.setName(card.getName());
        if (card.getType() != null) cardEntity.setType(card.getType());
        if (card.getNumber() != null) cardEntity.setNumber(card.getNumber());
        if (card.getBand() != null) cardEntity.setBand(card.getBand());
        if (card.getExpiration() != null) cardEntity.setExpiration(card.getExpiration());
        if (card.getLimitAmount() != null) cardEntity.setLimitAmount(card.getLimitAmount());
        if (card.getStatus() != null) cardEntity.setStatus(card.getStatus());

        cardEntity.setUpdatedAt(LocalDateTime.now());

        CardEntity updatedCardEntity = cardJpaRepository.save(cardEntity);
        return CardMapper.toDomain(updatedCardEntity);
    }

    @Override
    public Card findByName(String name) {
        return Optional.ofNullable(cardJpaRepository.findByName(name))
                .map(CardMapper::toDomain)
                .orElse(null);
    }

    @Override
    public void deleteById(UUID id) {
        cardJpaRepository.deleteById(id);
    }
}
