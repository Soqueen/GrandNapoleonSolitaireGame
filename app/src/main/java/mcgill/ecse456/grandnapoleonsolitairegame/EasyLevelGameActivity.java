package mcgill.ecse456.grandnapoleonsolitairegame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

/**
 * GNS Android Game Application
 * EasyLevelGameActivity.java
 * Purpose: Contains the logic of the game page features.
 *
 * @author Sok Heng Lim
 * @author Andrew Lin
 * @version 1.0 03/15/2017
 */
public class EasyLevelGameActivity extends AppCompatActivity {
	private float dx, dy, x, y, initialX, initialY;
	private int stackHeight, stackWidth;
	private int[] stackX = new int[2], stackY = new int[2];
	private int[] location = new int[2], locationCard = new int[2], location2 = new int[2];
	Stack[] stacks = new Stack[53];
	Card[] cards = new Card[52];


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_easy_game_page);

		// Create 53 stacks
		for (int index = 0; index < stacks.length; index++) {
			stacks[index] = new Stack(index);
		}

		// create 52 cards
		int index = 0;
		for (int suit = 1; suit < 5; suit++) {
			for (int num = 1; num < 14; num++) {
				cards[index] = new Card(suit, num);
				index++;
			}
		}

		// Shuffle Cards
		cards = shuffleCard(cards);

		// Set stacks to stacks views
		setStackView(stacks);

		// Display cards  over the stacks
		setCardViewOnStack(cards);

		// Detect touch motion
		cards[0].getImageView().setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return myTouch(v, event, cards[0], stacks[0], stacks[1]);
			}
		});

		cards[1].getImageView().setOnTouchListener(new View.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				return myTouch(v, event, cards[1], stacks[0], stacks[1]);
			}
		});
	}

	/**
	 * Shuffle the cards to randomly display the game layout.
	 *
	 * @return cardDeck Array of Card after shuffle
	 * @params cardDeck Array of Card before shuffle
	 */
	private Card[] shuffleCard(Card[] cardDeck) {
		for (int i = 0; i < cardDeck.length; i++) {
			// Generate random number
			Random r = new Random();
			int randomCard = r.nextInt(cardDeck.length);
			// Swap the cards
			Card tempCard = cardDeck[i];
			cardDeck[i] = cardDeck[randomCard];
			cardDeck[randomCard] = tempCard;
		}
		return cardDeck;
	}

	/**
	 * Set view for all the 53 stacks.
	 *
	 * @return None
	 * @params stack Array of stacks
	 */
	private void setStackView(Stack[] stacks) {
		stacks[0].setImageView((ImageView) findViewById(R.id.stack0));
		stacks[1].setImageView((ImageView) findViewById(R.id.stack1));
		stacks[2].setImageView((ImageView) findViewById(R.id.stack2));
		stacks[3].setImageView((ImageView) findViewById(R.id.stack3));
		stacks[4].setImageView((ImageView) findViewById(R.id.stack4));
		stacks[5].setImageView((ImageView) findViewById(R.id.stack5));
		stacks[6].setImageView((ImageView) findViewById(R.id.stack6));
		stacks[7].setImageView((ImageView) findViewById(R.id.stack7));
		stacks[8].setImageView((ImageView) findViewById(R.id.stack8));
		stacks[9].setImageView((ImageView) findViewById(R.id.stack9));
		stacks[10].setImageView((ImageView) findViewById(R.id.stack10));
		stacks[11].setImageView((ImageView) findViewById(R.id.stack11));
		stacks[12].setImageView((ImageView) findViewById(R.id.stack12));
		stacks[13].setImageView((ImageView) findViewById(R.id.stack13));
		stacks[14].setImageView((ImageView) findViewById(R.id.stack14));
		stacks[15].setImageView((ImageView) findViewById(R.id.stack15));
		stacks[16].setImageView((ImageView) findViewById(R.id.stack16));
		stacks[17].setImageView((ImageView) findViewById(R.id.stack17));
		stacks[18].setImageView((ImageView) findViewById(R.id.stack18));
		stacks[19].setImageView((ImageView) findViewById(R.id.stack19));
		stacks[20].setImageView((ImageView) findViewById(R.id.stack20));
		stacks[21].setImageView((ImageView) findViewById(R.id.stack21));
		stacks[22].setImageView((ImageView) findViewById(R.id.stack22));
		stacks[23].setImageView((ImageView) findViewById(R.id.stack23));
		stacks[24].setImageView((ImageView) findViewById(R.id.stack24));
		stacks[25].setImageView((ImageView) findViewById(R.id.stack25));
		stacks[26].setImageView((ImageView) findViewById(R.id.stack26));
		stacks[27].setImageView((ImageView) findViewById(R.id.stack27));
		stacks[28].setImageView((ImageView) findViewById(R.id.stack28));
		stacks[29].setImageView((ImageView) findViewById(R.id.stack29));
		stacks[30].setImageView((ImageView) findViewById(R.id.stack30));
		stacks[31].setImageView((ImageView) findViewById(R.id.stack31));
		stacks[32].setImageView((ImageView) findViewById(R.id.stack32));
		stacks[33].setImageView((ImageView) findViewById(R.id.stack33));
		stacks[34].setImageView((ImageView) findViewById(R.id.stack34));
		stacks[35].setImageView((ImageView) findViewById(R.id.stack35));
		stacks[36].setImageView((ImageView) findViewById(R.id.stack36));
		stacks[37].setImageView((ImageView) findViewById(R.id.stack37));
		stacks[38].setImageView((ImageView) findViewById(R.id.stack38));
		stacks[39].setImageView((ImageView) findViewById(R.id.stack39));
		stacks[40].setImageView((ImageView) findViewById(R.id.stack40));
		stacks[41].setImageView((ImageView) findViewById(R.id.stack41));
		stacks[42].setImageView((ImageView) findViewById(R.id.stack42));
		stacks[43].setImageView((ImageView) findViewById(R.id.stack43));
		stacks[44].setImageView((ImageView) findViewById(R.id.stack44));
		stacks[45].setImageView((ImageView) findViewById(R.id.stack45));
		stacks[46].setImageView((ImageView) findViewById(R.id.stack46));
		stacks[47].setImageView((ImageView) findViewById(R.id.stack47));
		stacks[48].setImageView((ImageView) findViewById(R.id.stack48));
		stacks[49].setImageView((ImageView) findViewById(R.id.stack49));
		stacks[50].setImageView((ImageView) findViewById(R.id.stack50));
		stacks[51].setImageView((ImageView) findViewById(R.id.stack51));
		// Cellar place at stack52
		stacks[52].setImageView((ImageView) findViewById(R.id.stack52));
	}


	/**
	 * Set all 52 cards Image on the 52 stacks in the view.
	 *
	 * @return None
	 * @params cardDecks Array of cards images
	 */
	private void setCardViewOnStack(Card[] cardDeck) {
		cardDeck[0].setImageView((ImageView) findViewById(R.id.stack0));
		cardDeck[1].setImageView((ImageView) findViewById(R.id.stack1));
		cardDeck[2].setImageView((ImageView) findViewById(R.id.stack2));
		cardDeck[3].setImageView((ImageView) findViewById(R.id.stack3));
		cardDeck[4].setImageView((ImageView) findViewById(R.id.stack4));
		cardDeck[5].setImageView((ImageView) findViewById(R.id.stack5));
		cardDeck[6].setImageView((ImageView) findViewById(R.id.stack6));
		cardDeck[7].setImageView((ImageView) findViewById(R.id.stack7));
		cardDeck[8].setImageView((ImageView) findViewById(R.id.stack8));
		cardDeck[9].setImageView((ImageView) findViewById(R.id.stack9));
		cardDeck[10].setImageView((ImageView) findViewById(R.id.stack10));
		cardDeck[11].setImageView((ImageView) findViewById(R.id.stack11));
		cardDeck[12].setImageView((ImageView) findViewById(R.id.stack12));
		cardDeck[13].setImageView((ImageView) findViewById(R.id.stack13));
		cardDeck[14].setImageView((ImageView) findViewById(R.id.stack14));
		cardDeck[15].setImageView((ImageView) findViewById(R.id.stack15));
		cardDeck[16].setImageView((ImageView) findViewById(R.id.stack16));
		cardDeck[17].setImageView((ImageView) findViewById(R.id.stack17));
		cardDeck[18].setImageView((ImageView) findViewById(R.id.stack18));
		cardDeck[19].setImageView((ImageView) findViewById(R.id.stack19));
		cardDeck[20].setImageView((ImageView) findViewById(R.id.stack20));
		cardDeck[21].setImageView((ImageView) findViewById(R.id.stack21));
		cardDeck[22].setImageView((ImageView) findViewById(R.id.stack22));
		cardDeck[23].setImageView((ImageView) findViewById(R.id.stack23));
		cardDeck[24].setImageView((ImageView) findViewById(R.id.stack24));
		cardDeck[25].setImageView((ImageView) findViewById(R.id.stack25));
		cardDeck[26].setImageView((ImageView) findViewById(R.id.stack26));
		cardDeck[27].setImageView((ImageView) findViewById(R.id.stack27));
		cardDeck[28].setImageView((ImageView) findViewById(R.id.stack28));
		cardDeck[29].setImageView((ImageView) findViewById(R.id.stack29));
		cardDeck[30].setImageView((ImageView) findViewById(R.id.stack30));
		cardDeck[31].setImageView((ImageView) findViewById(R.id.stack31));
		cardDeck[32].setImageView((ImageView) findViewById(R.id.stack32));
		cardDeck[33].setImageView((ImageView) findViewById(R.id.stack33));
		cardDeck[34].setImageView((ImageView) findViewById(R.id.stack34));
		cardDeck[35].setImageView((ImageView) findViewById(R.id.stack35));
		cardDeck[36].setImageView((ImageView) findViewById(R.id.stack36));
		cardDeck[37].setImageView((ImageView) findViewById(R.id.stack37));
		cardDeck[38].setImageView((ImageView) findViewById(R.id.stack38));
		cardDeck[39].setImageView((ImageView) findViewById(R.id.stack39));
		cardDeck[40].setImageView((ImageView) findViewById(R.id.stack40));
		cardDeck[41].setImageView((ImageView) findViewById(R.id.stack41));
		cardDeck[42].setImageView((ImageView) findViewById(R.id.stack42));
		cardDeck[43].setImageView((ImageView) findViewById(R.id.stack43));
		cardDeck[44].setImageView((ImageView) findViewById(R.id.stack44));
		cardDeck[45].setImageView((ImageView) findViewById(R.id.stack45));
		cardDeck[46].setImageView((ImageView) findViewById(R.id.stack46));
		cardDeck[47].setImageView((ImageView) findViewById(R.id.stack47));
		cardDeck[48].setImageView((ImageView) findViewById(R.id.stack48));
		cardDeck[49].setImageView((ImageView) findViewById(R.id.stack49));
		cardDeck[50].setImageView((ImageView) findViewById(R.id.stack50));
		cardDeck[51].setImageView((ImageView) findViewById(R.id.stack51));
	}

	/**
	 * Calculate touch event on card respective to card's location and on screen
	 *
	 * @return None
	 * @param v not used. event used to get type of touch event
     * @param event
     * @param i ImageView of card being dragged
	 */
	private void actionDown(View v, MotionEvent event, ImageView i) {
		initialX = i.getX();
		initialY = i.getY();
		x = event.getRawX();
		y = event.getRawY();
		dx = x - i.getX();
		dy = y - i.getY();
	}

	/**
	 * Update the card's position to follow touch
	 *
	 * @return None
	 * @params i ImageView of card being dragged.
	 */
	private void actionMove(ImageView i) {
		i.setX(x - dx);
		i.setY(y - dy);
	}

	/**
	 * Set card to a stack's position depending on where the touch event is
	 * If touch is in stack 1, set card to stack 1 if valid. otherwise,
	 * back to original position.
	 *
	 * @return None
	 * @params card
     * @param stack The first stack
     * @param stack2 The second stack
	 */
	private void actionUp(Card card, Stack stack, Stack stack2) {
		// check if touch event is in the location of stack
		if ((x > location[0] + 15 && x < location[0] + stackWidth) && (y > location[1] && y < location[1] + stackHeight)) {
			// check if card belongs to this stack
			if (card.getCurrentStackID() != stack.getStackID()) {
				// check if there is no card in the stack
				if (stack.getLastCard() == null) {
					stack.addCardToStack(card);
					card.getImageView().setX(stackX[0]);
					card.getImageView().setY(stackY[0]);
				// if there is, check suits
				} else if (stack.getLastCard().getSuit() == card.getSuit()) {
					// check all possibilities of sequence
					if (stack.getLastCard().getNumber() == 13 && card.getNumber() == 1) {
						stack.addCardToStack(card);
						card.getImageView().setX(stackX[0]);
						card.getImageView().setY(stackY[0]);
					} else if (stack.getLastCard().getNumber() == 1 && card.getNumber() == 13) {
						stack.addCardToStack(card);
						card.getImageView().setX(stackX[0]);
						card.getImageView().setY(stackY[0]);
					} else if (Math.abs(card.getNumber() - stack.getLastCard().getNumber()) == 1) {
						stack.addCardToStack(card);
						card.getImageView().setX(stackX[0]);
						card.getImageView().setY(stackY[0]);
					// cannot stack, move card back to original position
					} else {
						card.getImageView().setX(initialX);
						card.getImageView().setY(initialY);
					}
				// move card back to original position
				} else {
					card.getImageView().setX(initialX);
					card.getImageView().setY(initialY);
				}
			}
			// print first card in stack
			String a = "The first card of the stack is the " + stack.getFirstCard().convertToString();
		// check if touch event is in the location of stack2
		} else if ((x > location2[0] + 15 && x < location2[0] + stackWidth) && (y > location2[1] && y < location2[1] + stackHeight) && card.getCurrentStackID() != stack2.getStackID()) {
			// check if there is no card in the stack
			if (stack2.getLastCard() == null) {
				stack2.addCardToStack(card);
				card.getImageView().setX(stackX[1]);
				card.getImageView().setY(stackY[1]);
			// if there is, check if same suit
			} else if (stack2.getLastCard().getSuit() == card.getSuit()) {
				// check all possibilities of sequence
				if (stack2.getLastCard().getNumber() == 13 && card.getNumber() == 1) {
					stack2.addCardToStack(card);
					card.getImageView().setX(stackX[1]);
					card.getImageView().setY(stackY[1]);
				} else if (stack2.getLastCard().getNumber() == 1 && card.getNumber() == 13) {
					stack2.addCardToStack(card);
					card.getImageView().setX(stackX[1]);
					card.getImageView().setY(stackY[1]);
				} else if (Math.abs(card.getNumber() - stack2.getLastCard().getNumber()) == 1) {
					stack2.addCardToStack(card);
					card.getImageView().setX(stackX[1]);
					card.getImageView().setY(stackY[1]);
				// cannot stack, move card back to orignal position
				} else {
					card.getImageView().setX(initialX);
					card.getImageView().setY(initialY);
				}
			// cannot stack, move card back to orignal position
			} else {
				card.getImageView().setX(initialX);
				card.getImageView().setY(initialY);
			}
			// print first card in stack
			String a = "The first card of the stack is the " + stack2.getFirstCard().convertToString();
		} else {
			// cannot drop outside of stack, move card back to stack
			if (card.getCurrentStackID() != 0) {
				card.getImageView().setX(stackX[card.getCurrentStackID() - 1]);
				card.getImageView().setY(stackY[card.getCurrentStackID() - 1]);
			}
		}
	}

	/**
	 * Find the positions of the stacks on screen
	 *
	 * @return None
	 * @params i ImageView of card being dragged
     * @param  s ImageView of stack
     * @param s2 ImageView of stack
	 */    
	private void findStackLocation(ImageView i, ImageView s, ImageView s2) {
		i.getLocationOnScreen(locationCard);
		s.getLocationOnScreen(location);
		s2.getLocationOnScreen(location2);
		stackHeight = s.getHeight();
		stackWidth = s.getWidth();
		stackX[0] = s.getLeft();
		stackY[0] = s.getTop();
		stackX[1] = s2.getLeft();
		stackY[1] = s2.getTop();
	}

	/**
	 * Drag and drop function for cards
	 *
	 * @return None
	 * @param 	v ImageView of card being dragged
     * @param   s2 The stacks
     * @param   s1 The stacks
     * @param   e MotionEvent to get touch event
     * @param   c is the card the user wants to move
	 */
	private boolean myTouch(View v, MotionEvent e, Card c, Stack s1, Stack s2) {
		// show card in front of all
		v.bringToFront();
		x = e.getRawX();
		y = e.getRawY();
		findStackLocation(c.getImageView(), s1.getImageView(), s2.getImageView());
		// check which action is being done
		switch (e.getAction()) {
			case MotionEvent.ACTION_DOWN:
				actionDown(v, e, c.getImageView());
				break;
			case MotionEvent.ACTION_MOVE:
				actionMove(c.getImageView());
				break;
			case MotionEvent.ACTION_UP:
				actionUp(c, s1, s2);
				break;
			default:
				return false;
		}
		return true;
	}
}