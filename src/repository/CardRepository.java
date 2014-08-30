package repository;

import model.Card;

import java.util.List;

public interface CardRepository
{
    List<Card> getCardsByBeginningOfName(final String beginningOfName);
}
