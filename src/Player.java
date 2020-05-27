import java.util.Scanner;

public class Player {

    //create player attributes
    private int id;
    private int money;//player's total cash money
    private int totalDebt;//player's debt to bank and other players
    private Property[] propertyArr = new Property[40];//player's properties
    private int totalAssetPrice;//player's total asset value including cash and property values
    private int debtToPlayers;//player's debt to other players
    private int debtToBanks;//player'S debt to bank
    private int currentLocation = 0;//player's current location
    private boolean isJail = false;//is that player in jail or not
    private boolean isBankruptcy = false;//is that player has bankrupted or not
    private int propertyCounter = 0;
    private boolean allowToUpgrade = false;




    public Player(int id, int money) {
        this.id = id;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTotalDebt() {
        return totalDebt;
    }

    public void setTotalDebt(int totalDebt) {
        this.totalDebt = totalDebt;
    }

    public Property[] getPropertyArr() {
        return propertyArr;
    }

    public void setPropertyArr(Property property) {
        this.propertyArr[propertyCounter] = property;
        propertyCounter++;
    }

    public int getTotalAssetPrice() {
        return totalAssetPrice;
    }

    public void setTotalAssetPrice(int totalAssetPrice) {
        this.totalAssetPrice = totalAssetPrice;
    }

    public int getDebtToPlayers() {
        return debtToPlayers;
    }

    public void setDebtToPlayers(int debtToPlayers) {
        this.debtToPlayers = debtToPlayers;
    }

    public int getDebtToBanks() {
        return debtToBanks;
    }

    public void setDebtToBanks(int debtToBanks) {
        this.debtToBanks = debtToBanks;
    }

    public int getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(int currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isJail() {
        return isJail;
    }

    public void setJail(boolean jail) {
        isJail = jail;
    }

    public boolean isBankruptcy(Player player) {
        if (player.getMoney() <= 0) {
            isBankruptcy = true;
            return isBankruptcy;
        }
        return isBankruptcy;
    }

    public void setBankruptcy(boolean bankruptcy) {
        isBankruptcy = bankruptcy;
    }

    public String[] colorCounter(Property[] propertyArr) {
        int purple = 0;
        int blue = 0;
        int pink = 0;
        int orange = 0;
        int red = 0;
        int yellow = 0;
        int green = 0;
        int navyBlue = 0;
        String color[]=new String[8];

        for (int i = 0; i < propertyArr.length; i++) {
            Property currentProperty = propertyArr[i];
            switch (currentProperty.getColor()) {
                case "purple":
                    purple++;
                    if (purple == 2) {
                        for (int y = 0; i < propertyArr.length; i++) {
                            if (propertyArr[y].getColor().equals("purple"))
                                propertyArr[y].setUpgraded(true);
                            color[0]="purple";
                        }
                    }
                    break;
                case "blue":
                    blue++;
                    if (blue == 3) {
                        for (int y = 0; i < propertyArr.length; i++) {
                            if (propertyArr[y].getColor().equals("blue"))
                                propertyArr[y].setUpgraded(true);
                            color[1]="blue";
                        }
                    }
                    break;
                case "pink":
                    pink++;
                    if (pink == 3) {
                        for (int y = 0; i < propertyArr.length; i++) {
                            if (propertyArr[y].getColor().equals("pink"))
                                propertyArr[y].setUpgraded(true);
                            color[2]="pink";
                        }
                    }
                    break;
                case "orange":
                    orange++;
                    if (orange == 3) {
                        for (int y = 0; i < propertyArr.length; i++) {
                            if (propertyArr[y].getColor().equals("orange"))
                                propertyArr[y].setUpgraded(true);
                            color[3]="orange";
                        }
                    }
                    break;
                case "red":
                    if (red == 3) {
                        for (int y = 0; i < propertyArr.length; i++) {
                            if (propertyArr[y].getColor().equals("red"))
                                propertyArr[y].setUpgraded(true);
                            color[4]="red";
                        }
                    }
                    red++;
                    break;
                case "yellow":
                    if (yellow == 3) {
                        for (int y = 0; i < propertyArr.length; i++) {
                            if (currentProperty.getColor().equals("yellow"))
                                currentProperty.setUpgraded(true);
                            color[5]="yellow";
                        }
                    }
                    yellow++;
                    break;
                case "green":
                    if (green == 3) {
                        for (int y = 0; i < propertyArr.length; i++) {
                            if (currentProperty.getColor().equals("green"))
                                currentProperty.setUpgraded(true);
                            color[6]="green";
                        }
                    }
                    green++;
                    break;
                case "navyBlue":
                    if (navyBlue == 3) {
                        for (int y = 0; i < propertyArr.length; i++) {
                            if (currentProperty.getColor().equals("navyBlue"))
                                currentProperty.setUpgraded(true);
                            color[7]="navyBlue";
                        }
                    }
                    navyBlue++;
                    break;
            }

        }
return color;
    }
    public void askForBuildHotel(Player currentPlayer) {
        String color[]=new String[8];
        color=colorCounter(propertyArr);

        Scanner input = new Scanner(System.in);

        for(int i=0;i<color.length;i++){

            if(color[i].equals("purple")) {
                System.out.println("Player " + this.getId() + " has all purple lands.Do you want to build hotel?");
                String answer = input.nextLine();
                if(answer.equals("y")){
                    int mn=0;

                    for(int j=0; j<getPropertyArr().length; j++){


                           if(mn++==0)
                               currentPlayer.setMoney(currentPlayer.getMoney() - getPropertyArr()[j].getHousePrice());
                            getPropertyArr()[j].setRent(getPropertyArr()[j].getRent() * 3);


                    }

                }


            }


            if(color[i].equals("blue")){
                System.out.println("Player "+ this.getId()+"has all blue lands.Do you want to build hotel?");
            String answer = input.nextLine();
            if(answer.equals("y")){
                int mn=0;
                for(int j=0; j<getPropertyArr().length; j++){
                    if(getPropertyArr()[j].getColor().equals("blue")){
                        if(mn++==0)
                            currentPlayer.setMoney(currentPlayer.getMoney() - getPropertyArr()[j].getHouse());
                        getPropertyArr()[j].setRent(getPropertyArr()[j].getRent() * 3);
                    }

                }

            }}
            if(color[i].equals("pink")){
                System.out.println("Player "+ this.getId()+"has all pink lands.Do you want to build hotel?");
            String answer = input.nextLine();
            if(answer.equals("y")){
                int mn=0;

                for(int j=0; j<getPropertyArr().length; j++){
                    if(getPropertyArr()[j].getColor().equals("pink")){
                        if(mn++==0)
                            currentPlayer.setMoney(currentPlayer.getMoney() - getPropertyArr()[j].getHouse());
                        getPropertyArr()[j].setRent(getPropertyArr()[j].getRent() * 3);
                    }

                }

            }}
            if(color[i].equals("orange")){
                System.out.println("Player "+ this.getId()+"has all orange lands.Do you want to build hotel?");
            String answer = input.nextLine();
            if(answer.equals("y")){
                int mn=0;

                for(int j=0; j<getPropertyArr().length; j++){
                    if(getPropertyArr()[j].getColor().equals("orange")){
                        if(mn++==0)
                            currentPlayer.setMoney(currentPlayer.getMoney() - getPropertyArr()[j].getHouse());
                        getPropertyArr()[j].setRent(getPropertyArr()[j].getRent() * 3);
                    }

                }

            }}
            if(color[i].equals("red")){
                System.out.println("Player "+ this.getId()+"has all red lands.Do you want to build hotel?");
            String answer = input.nextLine();
            if(answer.equals("y")){
                int mn=0;
                for(int j=0; j<getPropertyArr().length; j++){
                    if(getPropertyArr()[j].getColor().equals("red")){
                        if(mn++==0)
                            currentPlayer.setMoney(currentPlayer.getMoney() - getPropertyArr()[j].getHouse());
                        getPropertyArr()[j].setRent(getPropertyArr()[j].getRent() * 3);
                    }

                }

            }}
                if(color[i].equals("yellow")){
                    System.out.println("Player "+ this.getId()+"has all yellow lands.Do you want to build hotel?");
            String answer = input.nextLine();
            if(answer.equals("y")){
                int mn=0;

                for(int j=0; j<getPropertyArr().length; j++){

                    if(getPropertyArr()[j].getColor().equals("yellow")){
                        if(mn++==0)
                            currentPlayer.setMoney(currentPlayer.getMoney() - getPropertyArr()[j].getHouse());
                        getPropertyArr()[j].setRent(getPropertyArr()[j].getRent() * 3);
                    }

                }

            }}

            if(color[i].equals("green")){
                System.out.println("Player "+ this.getId()+"has all green lands.Do you want to build hotel?");
            String answer = input.nextLine();
            if(answer.equals("y")){
                int mn=0;

                for(int j=0; j<getPropertyArr().length; j++){

                    if(getPropertyArr()[j].getColor().equals("green")){
                        if(mn++==0)
                            currentPlayer.setMoney(currentPlayer.getMoney() - getPropertyArr()[j].getHouse());
                        getPropertyArr()[j].setRent(getPropertyArr()[j].getRent() * 3);
                    }

                }

            }}
            if(color[i].equals("navyBlue")){
                System.out.println("Player "+ this.getId()+"has all navyBlue lands.Do you want to build hotel?");
            String answer = input.nextLine();
            if(answer.equals("y")){
                int mn=0;

                for(int j=0; j<getPropertyArr().length; j++){

                    if(getPropertyArr()[j].getColor().equals("navyBlue")){
                        if(mn++==0)
                            currentPlayer.setMoney(currentPlayer.getMoney() - getPropertyArr()[j].getHouse());
                        getPropertyArr()[j].setRent(getPropertyArr()[j].getRent() * 3);
                    }

                }

            }
        }}
    }

}
