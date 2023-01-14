/* Name: Jiayi He, Xuchen Huang
 * NetID: jhe36, xhuang41
 * Assignment Number: Project2
 * Lab Hours: TR 11:05 -12:20 (Jiayi He), TR 9:40-10:55 (Xuchen Huang)
 * We did not collaborate with anyone on this assignment.
 */

We have Card.java, Deck.java, Rank.java , Suit.java, Classify.java and four driver classes in out program.

In Card.java, we have three instance variables: rank, suit, and picked. For rank and suit of the card, we create two separate classes: Rank.java and Suit.java. In Rank.java, we use enumerated type to define the values of rank. Also, we have different methods such as getValue to return the value of the rank. We will call these methods in other classes to return the value of the rank directly. In Suit.java,  we return the value of the suit by calling getSuit method. Also, we will call getSuit method in other classes to return the value of the suit. 

In Deck.java, we first generate the new deck with cards inside by calling method generate. Also, we call pickHand method to pick 5 cards for each hand randomly.  Then, we shuffle the cards in each hand by calling shuffle method. After shuffling, we can use show method to show the cards in each hand. The swapCards method in Deck.java is called in shuffle method to shuffle the cards in the deck. 

In Classify.java, we have two major method, compareTo method and judge method. We first make the rank of the 5 cards’ ranks. This means that no matter which category the cards in each hand belongs to, we put the cards in each hand in order. Then, we use judge method to identify the categories of the cards in each hand. If cards in two hands are in the same categories, we return to the different cases in compareTo method and find the highest card in order to determine the winner. The other methods written in Classify.java are explained in detail with the comments in the code.

For 4 Driver classes, question 1 is tested with Driver1.java.Question 2 is tested with Driver2.java. Question 3 is tested with Driver3.java. Question 4 is tested with Driver4.java. Also, for question 4, because the question says that in the driver program, we should reads pairs of 10-character hands from the terminal, so when we run Driver4.java, we need to input 10-character hands (we list them in line 4 of the Driver4.java) inside the argument of the run configuration. 
