package controller;

import middle.GetCardsByBeginningOfNameRequest;
import repository.CardRepository;
import repository.URLCardRepository;

import java.util.Observable;
import java.util.Observer;

public class DeckTrackingController extends Observable implements Observer
{
    final CardRepository cardRepository = new URLCardRepository();

    public DeckTrackingController()
    {
    }

    /**
     * @param observable the (for now JFrame) view we're observing.
     * @param payload    the request from the view.
     */
    @Override
    public void update(final Observable observable, final Object payload)
    {
        System.out.println("DeckTrackingController.update called, observable=" + observable + ", payload=" + payload);

        if (payload instanceof GetCardsByBeginningOfNameRequest)
        {
            final String beginningOfName = ((GetCardsByBeginningOfNameRequest) payload).getNameSubstring();

            setChanged();
            notifyObservers(cardRepository.getCardsByBeginningOfName(beginningOfName));
        }
    }
}
