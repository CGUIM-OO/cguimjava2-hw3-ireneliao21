import java.util.*;

public class Deck {

	private ArrayList<Card> cards;
	private ArrayList<Card> usedCard;
	public int nUsed;
	
	
	
    /**
     * s = the suit of card , z = the value of card
     * put c1(s,z) into array list : cards
     * @param nDeck
     */
	
	public Deck(int nDeck) 
	{
		cards = new ArrayList<Card>();
		usedCard = new ArrayList<Card>();
		for (int i = 0; i < nDeck; i++) 
		{
			for (Card.Suit s : Card.Suit.values()) 
			{
				for (int z = 1; z <= 13; z++) 
				{
					Card c1 = new Card(s, z);
					cards.add(c1);
				}
			}
		}
		shuffle();
	}
	

	/**
	 * shuffle cards
	 */
	
	public void shuffle() 
	{
		cards.addAll(usedCard);
		Random rnd = new Random();
		
		for (int i = 0; i < 52; i++) 
		{
			int j = rnd.nextInt(i + 1);
			cards.add(cards.get(j));
			cards.remove(cards.get(j));
		}
		usedCard.clear();
		nUsed = 0;
	}

	/**
	 * deal = the first card take out from cards
	 * @return
	 */
	
	public Card getOneCard() 
	{
		if(nUsed==52)
		{
			shuffle();
			nUsed=0;
		}
		Card deal = cards.get(0);
		cards.remove(0);
		usedCard.add(deal);
		nUsed++;
		return deal;
	}

	
	
	public void printDeck() 
	{

		for (int i = 0; i < cards.size(); i++) 
		{
			Card c1 = cards.get(i);
			c1.printCard();
		}

	}

	public ArrayList<Card> getAllCards() 
	{
		return cards;
	}
}