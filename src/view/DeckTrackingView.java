package view;

import middle.GetCardsByBeginningOfNameRequest;
import model.Card;
import view.util.ObservableJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.List;

public class DeckTrackingView extends JFrame implements Observer, ObservableJFrame
{
    private Observable observable = new Observable();
    private final JList deckList;

    private Vector<String> deckListData = new Vector<>();

    public DeckTrackingView(final String title)
    {
        super(title);

        final JPanel deckPanel = new JPanel(new BorderLayout());
        add(deckPanel, BorderLayout.EAST);

        deckList = new JList();
        deckPanel.add(deckList);

        final JPanel deckManipulationPanel = buildDeckManipulationPanel();
        deckPanel.add(deckManipulationPanel, BorderLayout.SOUTH);

        setUpFrame();
    }

    private JPanel buildDeckManipulationPanel()
    {
        final JPanel deckManipulationPanel = new JPanel(new GridLayout(3, 0));

        final JTextField cardTitleTextField = new JTextField();
        deckManipulationPanel.add(cardTitleTextField);

        final JButton insertCardButton = new JButton("Find cards beginning with ^ text");
        deckManipulationPanel.add(insertCardButton);

        insertCardButton.addActionListener(new ActionListener()
        {

            @Override
            public void actionPerformed(final ActionEvent e)
            {
                setObservableChanged();
                observable.notifyObservers(new GetCardsByBeginningOfNameRequest()
                {
                    @Override
                    public String getNameSubstring()
                    {
                        return cardTitleTextField.getText();
                    }
                });
            }
        });

        final JButton removeCardButton = new JButton("Remove card");
        deckManipulationPanel.add(removeCardButton);

        return deckManipulationPanel;
    }

    private void setUpFrame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);

        setVisible(true);
    }

    @Override
    public void update(final Observable observable, final Object payload)
    {
        if (payload instanceof List)
        {
            final List<Card> cards = (List<Card>) payload;

            if (cards.size() == 1)
            {
                final Card card = cards.get(0);
                deckListData.add(card.getName() + " | " + card.getAttack() + "-" + card.getHealth());

                deckList.setListData(deckListData);

                // Focus the newest entry.
                deckList.setSelectedIndex(deckListData.size() - 1);

                deckList.revalidate();
                deckList.repaint();
            }
            else
            {

                // Build an array of the matching card names (and reverse the list for the options to go alphabetical).
                final String[] cardNames = new String[cards.size()];

                for (int i = 0; i < cards.size(); i++)
                {
                    final Card card = cards.get(i);
                    cardNames[i] = card.getName();
                }

                // TODO: Actually display these to the user.
                JOptionPane.showOptionDialog(
                        DeckTrackingView.this,
                        "Please select a card",
                        "Cards matching the input",
                        0, 0, null,
                        cardNames,
                        0
                );
            }
        }
    }

    @Override
    public Observable getObservable()
    {
        return observable;
    }

    private void setObservableChanged()
    {
        try
        {
            final Method setChanged = Observable.class.getDeclaredMethod("setChanged");
            setChanged.setAccessible(true);
            setChanged.invoke(observable);
        }
        catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}
