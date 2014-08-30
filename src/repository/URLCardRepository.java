package repository;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import model.Card;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class URLCardRepository implements CardRepository
{
    private final Map<String, Card> cards = new HashMap<>();

    public URLCardRepository()
    {

        try
        {
            final String cardsAsJson = getCardsAsJson();

            final Gson gson = new Gson();

            final JsonArray cardJsonArray = gson.fromJson(cardsAsJson, JsonArray.class);

            for (final JsonElement cardJsonObject : cardJsonArray)
            {
                final Card card = gson.fromJson(cardJsonObject, Card.class);
                cards.put(card.getName(), card);
            }

            System.out.println(cards);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private String getCardsAsJson() throws IOException
    {
        final URL url = new URL("http://hearthstoneapi.com/cards/find");
        final InputStream inputStream = url.openStream();
        final BufferedReader cardStreamReader = new BufferedReader(new InputStreamReader(inputStream));

        final StringBuilder cardsAsJson = new StringBuilder();

        String line;
        while ((line = cardStreamReader.readLine()) != null)
        {
            cardsAsJson.append(line);
        }

        return cardsAsJson.toString();
    }

    @Override
    public List<Card> getCardsByBeginningOfName(final String beginningOfName)
    {
        final List<Card> matchingCards = new ArrayList<>();

        for (final String key : cards.keySet())
        {
            if (key.startsWith(beginningOfName))
            {
                matchingCards.add(cards.get(key));
            }
        }

        return matchingCards;
    }
}
