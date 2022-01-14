/** Class describing a card object with some rank 
 * (Ace,1,2...Queen,King) and some suit
 * (Club, Diamond etc.) encoded as integer attributes.
 */ 
 
public class Card {
   private int rank;
   private int suit;
   
   /** Constructor method. Initialises rank and suit attributes, 
    * checking they are valid or invalid.
    * @param rank of card, coded as integer. 
    * @param suit of card. 1,2,3,4 = club, diamond, heart, spade
    */

   public Card(int rank, int suit) { //Constructor
      if (((1 <= rank) && (rank <= 13)) && ((1 <= suit) && (suit <= 4))) { 
         this.rank = rank; 
         this.suit = suit;
      } else {
         this.rank = 0;
         this.suit = 0;
      }  
   }   
   
   /** Getter function. Returns rank of card.
    * @return the card's rank attribute
    */
   public int getRank() { 
      return this.rank; 
   }
   
   /** Getter function. Returns suit of card.
    * @return the card's suit attribute
    */
   public int getSuit() { 
      return this.suit; 
   }
   
   /** Helper function for toString. Returns 
    * String of card's suit given the integer suit.
    * @param numSuit, which is the integer suit attribute of the Card.
    * @return String with card's suit.
    */
   private String numToSuit(int numSuit) { // Returns suit given number
      switch (numSuit) {
         case 1:
            return "Clubs";
         case 2:
            return "Diamonds";
         case 3: 
            return "Hearts";
         case 4: 
            return "Spades";
         default:
            return "N/A";
      }
   } 
   
   /** Helper function for toString. Returns String 
    * of card's rank given the integer rank.
    * @param numRank, which is the integer rank attribute of the Card.
    * @return String with card's rank.
    */
   private String numToRank(int numRank) { 
      switch (numRank) {
         case 1:
            return "Ace";
         case 11:
            return "Jack";
         case 12: 
            return "Queen";
         case 13: 
            return "King";
         default:
            return " " + numRank;
      }
   } 
   
   /** Return string for a given card.
    * @return String in format "(rank) of (suit)", for ex. "2 of Clubs".
    */
   public String toString() { 
      String strSuit = numToSuit(this.suit);
      String strRank = numToRank(this.rank);
      return strRank + " of " +  strSuit;  
   }
   
   /**
    * See if two cards are equal based on rank and suit.
    * @param other the other Card object to be compared.
    * @return boolean, true if cards are equal and false otherwise.
    */
   public boolean equals(Object other) { 
      Card oc = (Card) other;
      return ((oc.getRank() == this.rank) && (oc.getSuit() == this.suit));
           
   }
   
      /**
    * Compare this Card with the specified otherCard for order, based on suit.
    * @param otherCard the other Card object to be compared.
    * @return a negative integer, zero, or a positive integer as
    * this object is less than, equal to, or greater than the otherCard.
    */
   public int compareTo(Card otherCard) { 
      int suitDiff = this.suit - otherCard.getSuit(); 
      
      if (suitDiff != 0) { // Prioritising difference in rank.  
         return suitDiff;
      } else {
         return this.rank - otherCard.getRank();
      }   
   }
}
   
