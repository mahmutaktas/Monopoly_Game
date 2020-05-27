public class Card {

    //create card attributes

    private String name;
    private int price;//create price for cards that gives or takes price
    private int goToSquare;//create integer for how many squares player jump when the proper card pulled
    private Player player;//take player for this cards

    //getter setter
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getGoToSquare() {
        return goToSquare;
    }

    public void setGoToSquare(int goToSquare) {
        this.goToSquare = goToSquare;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
