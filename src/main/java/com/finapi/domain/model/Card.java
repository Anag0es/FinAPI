package com.finapi.domain.model;

import com.finapi.domain.enums.CardType;
import com.finapi.domain.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

public class Card {

    private Long id;
    private String name;
    private CardType type;
    private String number;
    private Date expiration;
    private BigDecimal limitAmount;
    private String band;
    private User user;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
