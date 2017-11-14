package Model;
import java.util.ArrayList;
import java.util.Collections;

import Cards.Card00;
import Cards.Card01;
import Cards.Card02;
import Cards.Card03;
import Cards.Card04;
import Cards.Card05;
import Cards.Card06;
import Cards.Card07;
import Cards.Card08;
import Cards.Card09;
import Cards.Card10;
import Cards.Card11;
import Cards.Card12;
import Cards.Card13;
import Cards.Card14;
import Cards.Card15;
import Cards.Card16;
import Cards.Card17;
import Cards.Card18;
import Cards.Card19;
import Cards.Card20;
import Cards.Card21;
import Cards.Card22;
import Cards.Card23;
import Cards.Card24;
import Cards.Card25;
import Cards.Card26;
import Cards.Card27;
import Cards.Card28;
import Cards.Card29;
import Cards.Card30;
import Cards.Card31;
import Cards.Card32;
import Cards.Card33;
import Cards.Card34;
import Cards.Card35;
import Cards.Card36;
import Cards.Card37;
import Cards.Card38;
import Cards.Card39;
/**
 * 
 * @author Sotheanith Sok
 *
 *This is deck used to initialize and store all cards. It is also contains function for add and remove card from the deck.
 */
public class Deck {
	private ArrayList<Card> inPlayCardDeck;
	private ArrayList<Card> discardCardDeck;
	public Deck() {
		inPlayCardDeck = new ArrayList<Card>();
		discardCardDeck = new ArrayList<Card>();
		instantiateDeck();
	}

	public void instantiateDeck() {
		inPlayCardDeck.add(new Card00());
		inPlayCardDeck.add(new Card01());
		inPlayCardDeck.add(new Card02());
		inPlayCardDeck.add(new Card03());
		inPlayCardDeck.add(new Card04());
		inPlayCardDeck.add(new Card05());
		inPlayCardDeck.add(new Card06());
		inPlayCardDeck.add(new Card07());
		inPlayCardDeck.add(new Card08());
		inPlayCardDeck.add(new Card09());
		inPlayCardDeck.add(new Card10());
		inPlayCardDeck.add(new Card11());
		inPlayCardDeck.add(new Card12());
		inPlayCardDeck.add(new Card13());
		inPlayCardDeck.add(new Card14());
		inPlayCardDeck.add(new Card15());
		inPlayCardDeck.add(new Card16());
		inPlayCardDeck.add(new Card17());
		inPlayCardDeck.add(new Card18());
		inPlayCardDeck.add(new Card19());
		inPlayCardDeck.add(new Card20());
		inPlayCardDeck.add(new Card21());
		inPlayCardDeck.add(new Card22());
		inPlayCardDeck.add(new Card23());
		inPlayCardDeck.add(new Card24());
		inPlayCardDeck.add(new Card25());
		inPlayCardDeck.add(new Card26());
		inPlayCardDeck.add(new Card27());
		inPlayCardDeck.add(new Card28());
		inPlayCardDeck.add(new Card29());
		inPlayCardDeck.add(new Card30());
		inPlayCardDeck.add(new Card31());
		inPlayCardDeck.add(new Card32());
		inPlayCardDeck.add(new Card33());
		inPlayCardDeck.add(new Card34());
		inPlayCardDeck.add(new Card35());
		inPlayCardDeck.add(new Card36());
		inPlayCardDeck.add(new Card37());
		inPlayCardDeck.add(new Card38());
		inPlayCardDeck.add(new Card39());
		Collections.shuffle(inPlayCardDeck);
	}
	public Card removeCard() {
		if(getInPlayCardDeckSize()<5) {

			inPlayCardDeck.addAll(discardCardDeck);
			discardCardDeck.clear();
			Collections.shuffle(inPlayCardDeck);
		}
		Card c = inPlayCardDeck.remove(0);
		return c;
	}
	
	public int getInPlayCardDeckSize() {
		return inPlayCardDeck.size();
	}
	public int getDiscardCardDeckSize() {
		return discardCardDeck.size();
	}
	public void discardCard(Card c) {
		discardCardDeck.add(c);
	}

}
