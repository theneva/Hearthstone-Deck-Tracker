import controller.DeckTrackingController;
import view.DeckTrackingView;

public class Main {

    public static void main(String[] args) {

        final DeckTrackingController deckTrackingController = new DeckTrackingController();
        final DeckTrackingView deckTrackingView = new DeckTrackingView("Hearthstone deck tracker");

        // Talk to each other, damn it.
        deckTrackingController.addObserver(deckTrackingView);
        deckTrackingView.getObservable().addObserver(deckTrackingController);
    }
}
