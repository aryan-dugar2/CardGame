/** Class describing a deck object.
 * It consists of a list of 52 Card objects. 
 */ 

public class Deck {
   private Card[] deck;
   
   /** Constructor method. Initialises deck attribute , 
    * with 52 cards in order.
    */
   public Deck() { 
      
      int rank = 0;
      this.deck = new Card[52];
      
      for (int i = 0; i < deck.length; ++i) {
         if (i % 13 == 0) {
            ++rank;
         } 
         deck[i] = new Card(i % 13 + 1, rank);
             
      }
   }
   
   /** Return String with detail of each Card in Deck
    * outputted in order.
    * @return String in format "(rank) of (suit)\n", 
    * for ex. "2 of Clubs" ...
    */

   public String toString() { // Return string
      String str = "";
      for (int i = 0; i < this.deck.length; ++i) {
         str += this.deck[i].toString() + "\n";
      }
      return str;
   }
   
   /** Swap cards at two different indices in a deck.
    * @param index1: index of first card to be swapped.
    * @param index2: index of second card to be swapped.
    */
   private void swap(int index1, int index2) { // Swapping cards
      Card dummyCard = this.deck[index1];
      this.deck[index1] = this.deck[index2];
      this.deck[index2] = dummyCard;
   }
   
   /** Generates random integer given min, max of range.
    * @param min: minimum of range.
    * @param max: maximum of range.
    */
   private static int randInt(int min, int max) {
      return (min + (int) (Math.random() * (max - min + 1)));
   }
   
   /** Shuffles deck of cards with given algorithm.
    */
   public void shuffle() {
      int rand1;
      int rand2;
      
      for (int i = 0; i < 104; ++i) {
         rand1 = randInt(0, 51);
         rand2 = randInt(0, 51);
         swap(rand1, rand2);
      }
   }
   
   /** Sorts deck of cards with given algorithm.
    */
   public void sort() {
      Card c;
      int i;
      
      for (int j = 0; j < 52; ++j) {
         c = deck[j];
         i = j - 1;
         while ((i >= 0) && (deck[i].compareTo(c) > 0)) {
            deck[i + 1] = deck[i];
            i -= 1;
         }
         deck[i + 1] = c;
      }
   }
   
}