class Property {

    //create propety attributes
    private String propertyName;//property name
    private int price;//property value
    private int rent;//property rent price
    private int housePrice;//property rent price with houses
    private int house;//property house building price
    private int mortgagePrice;//property bank mortgage price
    String color;//property color
    boolean isMortgage=false;//is that property mortgaged or not
    boolean hasOwner=false;//is that property has owner
    private Player player;
    private boolean upgraded = false;

    //constructors
    public Property(){

    }

    public Property(int price, int rent, int housePrice, int mortgagePrice, String color) {
        this.price = price;
        this.rent = rent;
        this.housePrice = housePrice;
        this.house = house;
        this.mortgagePrice = mortgagePrice;
        this.color = color;
    }

    public Property(int price, int rent, int mortgagePrice, String color) {
        this.price = price;
        this.rent = rent;
        this.mortgagePrice = mortgagePrice;
        this.color = color;
    }

    //getter setter
    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getHousePrice() {
        return housePrice;
    }

    public void setHousePrice(int housePrice) {
        this.housePrice = housePrice;
    }

    public int getHouse() {
        return house;
    }

    public void setHouse(int house) {
        this.house = house;
    }

    public int getMortgagePrice() {
        return mortgagePrice;
    }

    public void setMortgagePrice(int mortgagePrice) {
        this.mortgagePrice = mortgagePrice;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isMortgage() {
        return isMortgage;
    }

    public void setMortgage(boolean mortgage) {
        isMortgage = mortgage;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }


    public Player getOwner() {
        return player;
    }

    public void setOwner(Player player) {
        this.player = player;
        hasOwner = true;
    }

    public boolean isUpgraded() {
        return upgraded;
    }

    public void setUpgraded(boolean upgraded) {
        this.upgraded = upgraded;
    }
}
