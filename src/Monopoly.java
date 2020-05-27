import java.util.Scanner;

public class Monopoly {
    public static void main(String[] args) {

        //initialize the scanner to get input from user
        Scanner input = new Scanner(System.in);

        Board board = new Board();
        Dice dice = new Dice();

        board.initializeGame();

        //getting input from user to indicate how many players they are
        System.out.print("How many players you want to play: "); //prompt user to get input
        int playerNumber = input.nextInt();//get the input

        Player[] playerArray = new Player[playerNumber];//create input sized player array

        //create the objects of player for each player and give them $2000 for beginning
        for(int i=0; i < playerNumber; i++){
            playerArray[i] = new Player(i, 2000);
        }


        //create a while loop to game continue until the user ends
        outerloop://label the while loop to break it when user wants
        while(true) {

            //create a for loop to loop for the number of players
            for (int playerCounter = 0; playerCounter < playerArray.length; playerCounter++) {

                Player currentPlayer = playerArray[playerCounter];

                if (currentPlayer.isBankruptcy(currentPlayer)){
                    continue ;
                }

                if(currentPlayer.isJail()){
                    System.out.println("You are in jail. In order to free yourself from jail, pay 50$ or roll dice." +
                            "If the dices are equal to each other you can be free. To pay 50$ press y");
                    String answer = input.next();
                    if (answer.contentEquals("y")){
                        currentPlayer.setMoney(currentPlayer.getMoney() - 50);
                        System.out.println("You have paid 50$ now you are free. Your current money is: " + currentPlayer.getMoney());
                        currentPlayer.setJail(false);
                    }
                    else{
                        continue;
                    }

                }

           /*     if(currentPlayer.getPropertyArr()[0]!=null){
                currentPlayer.askForBuildHotel(currentPlayer);}*/
                int currentDice = dice.roll();//roll the dice and assign to a local variable

                System.out.println("Dice 1 is: " + dice.getDice1() + " Dice 2 is: " + dice.getDice2());

                if(dice.getDice1() == dice.getDice2() && currentPlayer.isJail()){
                    System.out.println("Congratulations you roll the even dice. You can leave the jail now ");
                }else if(currentPlayer.isJail()){
                    continue;
                }

                System.out.println("Player" + (playerCounter+1) + "'s turn. Player's dice is " + currentDice);//print the current player and his/her dice

                //move the player by the number of dice and print which square she/he is on
                currentPlayer.setCurrentLocation(currentPlayer.getCurrentLocation() + currentDice);

                //if player exceeds the number of squares. he come to the start point and start again. and earn $200
                if (playerArray[playerCounter].getCurrentLocation() > 39) {
                    playerArray[playerCounter].setCurrentLocation(playerArray[playerCounter].getCurrentLocation() - 40);
                    playerArray[playerCounter].setMoney(playerArray[playerCounter].getMoney() + 200);
                    System.out.println("You have just passed the start point and earned 200 dollars");
                }

                System.out.println("Player " + playerCounter + " is current on " + board.getSquares()[currentPlayer.getCurrentLocation()].getDescription() + " square");

                //when player come to a property square.
                if (board.getSquares()[playerArray[playerCounter].getCurrentLocation()].getProperty().getColor() != null) {//property check

                    Property currentProperty = board.getSquares()[currentPlayer.getCurrentLocation()].getProperty();

                    System.out.println("Your money before the purchase is: " + playerArray[playerCounter].getMoney());//print the players money before the purchase

                    if(!currentProperty.isHasOwner()) {
                        System.out.println("Do you want to purchase this property. Press y for yes");//prompt the user if she/he wants to buy this property
                        String answer = input.next();//get the answer

                        //if player accept the purchase. the cost of the property will be taken from the player
                        if (answer.contentEquals("y")) {

                            currentPlayer.setPropertyArr(currentProperty);
                            currentProperty.setOwner(currentPlayer);
                            currentPlayer.setMoney(currentPlayer.getMoney() - currentProperty.getPrice());//take the player's money
                            System.out.println("Your money after the purchase is: " + playerArray[playerCounter].getMoney());//print the players money after the purchase

                            if (currentPlayer.isBankruptcy(currentPlayer)) {
                                System.out.println("YOU HAVE BANKRUPTED. IT'S NICE TO PLAYING WITH YOU");
                                continue;
                            }

                        }






                    }
                    else if(currentProperty.isHasOwner()){
                        System.out.println("This property is owned by Player " + currentProperty.getOwner().getId() +
                                ". This location has " + currentProperty.getRent() + "$ rent.");
                        currentPlayer.setMoney(currentPlayer.getMoney() - currentProperty.getRent());
                        System.out.println("Your money after rent is: " + currentPlayer.getMoney());
                    }
                }//end property check
                else if(board.getSquares()[playerArray[playerCounter].getCurrentLocation()].getCard().getName() != null) {//card check
                    Card currentCard = board.getSquares()[currentPlayer.getCurrentLocation()].getCard();
                    System.out.println("You drew the " + currentCard.getName());

                    switch (currentCard.getName()){
                        case "Go To Jail Card":
                            currentPlayer.setJail(true);
                            break;
                        case "Three Back Square Card":
                            board.getSquares()[currentPlayer.getCurrentLocation()].goToSquare(currentPlayer);
                            break;
                        case "Gain 100 Dollars Card":
                            board.getSquares()[currentPlayer.getCurrentLocation()].gain100Dollars(currentPlayer);
                            break;
                        case "Doctor Fee Card (-50$)":
                            board.getSquares()[currentPlayer.getCurrentLocation()].doctorFee(currentPlayer);
                            break;
                        case "Lottery Card (75$)":
                            board.getSquares()[currentPlayer.getCurrentLocation()].lottery(currentPlayer);
                            break;
                        case "Go To Start Card":
                            board.getSquares()[currentPlayer.getCurrentLocation()].goToStart(currentPlayer);

                    }

                }//end card check
                else{

                    switch (board.getSquares()[currentPlayer.getCurrentLocation()].getDescription()){
                        case "Income Tax (Pay $200)":
                            currentPlayer.setMoney(currentPlayer.getMoney() - 200);
                            System.out.println("You pay the Income Tax 200$. Your money after payment is: "
                                    + currentPlayer.getMoney());
                            break;
                        case "Free Parking":
                            System.out.println("You are on the free parking area.");
                            break;
                        case "Government Tax ($75)":
                            currentPlayer.setMoney(currentPlayer.getMoney() - 75);
                            System.out.println("You pay the Government Tax 75$. Your money after payment is: "
                                    + currentPlayer.getMoney());
                            break;

                    }

                }

                //ask players at the end of each turn if they want to finish the gamae
                System.out.println("If you want to finish the game type 'end' otherwise press anykey");
                String endGame = input.next();

                //when user typed end
                if (endGame.contentEquals("end")) {

                    //print the each players money
                    for (int playerNum = 0; playerNum<playerArray.length; playerNum++){
                        System.out.println("Player " + playerArray[playerNum].getId() + " money is $" + playerArray[playerNum].getMoney());
                    }

                    //break the while loop and terminate the game
                    break outerloop;
                }

                System.out.println("* * * * * * * * * * *");
            }

        }

    }


    //method for the pull randomly card when chance of community squares come
    public static Card pullRandomCard(Card[] cards){

        int randomNumber = (int)(2*Math.random());

        return cards[randomNumber];
    }

}


