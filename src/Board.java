public class Board {

    private Square[] squares = new Square[40];

    private Card goToJail = new Card();
    private Card threeBackSquare = new Card();
    private Card gain100Dollars = new Card();

    //create community cards
    private Card doctorFee = new Card();
    private Card lottery = new Card();
    private Card goToStart = new Card();


    private Property istiklalCaddesi = new Property(50 ,25, 200, 200, "purple");
    private Property baltikCaddesi = new Property(60, 30, 240 ,240, "purple");
    private Property hizliTrenIstasyonu = new Property(300, 100, 400,"white");
    private Property ismetPasaCaddesi = new Property(100, 50, 200, 200, "blue");
    private Property milletCaddesi = new Property(100, 50, 200, 200, "blue");
    private Property akdenizCaddesi = new Property(120, 60, 240, 480, "blue");
    private Property eyup = new Property(140, 70, 280, 560, "pink");
    private Property elektrikSirketi = new Property(150, 75,600, "white");
    private Property kadikoy = new Property(140, 70, 280, 500, "pink");
    private Property uskudar = new Property(160, 80, 320, 700, "pink");
    private Property metroIstasyonu = new Property(200, 100, 400, "white");
    private Property umraniye = new Property(180, 90, 360, 700, "orange");
    private Property maltepe = new Property(180, 90, 360, 600, "orange");
    private Property pendik = new Property(200, 100, 400, 650, "orange");
    private Property besiktas = new Property(200,100,400,400,"red");
    private Property ortakoy = new Property(220,110,440,440,"red");
    private Property bebek = new Property(240,120,480,480,"red");
    private Property marmaray = new Property(200,100,400,"white");
    private Property beylikduzu = new Property(260,130,520,520,"yellow");
    private Property avcilar = new Property(260,130,520,520,"yellow");
    private Property iski = new Property(150,75,300,"white");
    private Property kucukcekmece = new Property(280,140,560,560,"yellow");
    private Property fatih = new Property(300,150,600,600,"green");
    private Property taksim = new Property(300,150,600,600,"green");
    private Property karakoy = new Property(300,150,600,600,"green");
    private Property durak = new Property(200,100,400,"white");
    private Property dudullu = new Property(350,175,700,700,"navyBlue");
    private Property tuzla = new Property(400,200,400,800,"navyBlue");



    public void initializeGame(){


        goToJail.setName("Go To Jail Card");
        threeBackSquare.setName("Three Back Square Card");
        gain100Dollars.setName("Gain 100 Dollars Card");
        doctorFee.setName("Doctor Fee Card (-50$)");
        lottery.setName("Lottery Card (75$)");
        goToStart.setName("Go To Start Card");

        //put the chance and community cards in two array to pull them randomly when user come to them
        Card[] chanceCards = new Card[3];
        chanceCards[0] = goToJail;
        chanceCards[1] = threeBackSquare;
        chanceCards[2] = gain100Dollars;

        Card[] communityCards = new Card[3];
        communityCards[0] = doctorFee;
        communityCards[1] = lottery;
        communityCards[2] = goToStart;


        //create the square object
        for(int i=0; i < 40; i++){
            squares[i] = new Square();
        }

        //assign description and property or card attributes to indicate the what that square doing
        squares[0].setDescription("Go collect Money");

        squares[1].setDescription("Ä°stiklal Caddesi ($80) - Purple");
        squares[1].setProperty(istiklalCaddesi);//match the property with square

        squares[2].setDescription("Community Chest");
        squares[2].setCard(pullRandomCard(communityCards));//get randomly community and chance cards

        squares[3].setDescription("BaltÄ±k Caddesi ($60) - Purple");
        squares[3].setProperty(baltikCaddesi);

        squares[4].setDescription("Income Tax (Pay $200)");

        squares[5].setDescription("HÄ±zlÄ± Tren Ä°stasyonu ($300)");
        squares[5].setProperty(hizliTrenIstasyonu);

        squares[6].setDescription("Ä°smet PaÅŸa Caddesi ($100) - Blue");
        squares[6].setProperty(ismetPasaCaddesi);

        squares[7].setDescription("Chance");
        squares[7].setCard(pullRandomCard(chanceCards));

        squares[8].setDescription("Millet Caddesi ($100) - Blue");
        squares[8].setProperty(milletCaddesi);

        squares[9].setDescription("Akdeniz Caddesi ($120) - Blue");
        squares[9].setProperty(akdenizCaddesi);

        squares[10].setDescription("Jail/Just visiting");
        squares[10].setCard(goToJail);

        squares[11].setDescription("EyÃ¼p ($140) - Pink");
        squares[11].setProperty(eyup);

        squares[12].setDescription("Elektrik ÅŸirketi ($150)");
        squares[12].setProperty(elektrikSirketi);

        squares[13].setDescription("KadÄ±kÃ¶y ($140) - Pink");
        squares[13].setProperty(kadikoy);

        squares[14].setDescription("ÃœskÃ¼dar ($160) - Pink");
        squares[14].setProperty(uskudar);

        squares[15].setDescription("Metro istasyonu ($200)");
        squares[15].setProperty(metroIstasyonu);

        squares[16].setDescription("Ãœmraniye ($180) - Orange");
        squares[16].setProperty(umraniye);

        squares[17].setDescription("Community Chest");
        squares[17].setCard(pullRandomCard(communityCards));

        squares[18].setDescription("Maltepe ($180) - Orange");
        squares[18].setProperty(maltepe);

        squares[19].setDescription("Pendik ($200) - Orange");
        squares[19].setProperty(pendik);

        squares[20].setDescription("Free Parking");

        squares[21].setDescription("BeÅŸiktaÅŸ ($220) - Red");
        squares[21].setProperty(besiktas);

        squares[22].setDescription("Chance");
        squares[22].setCard(pullRandomCard(chanceCards));

        squares[23].setDescription("OrtakÃ¶y ($220) - Red");
        squares[23].setProperty(ortakoy);

        squares[24].setDescription("Bebek ($240) - Red");
        squares[24].setProperty(bebek);

        squares[25].setDescription("Marmaray istasyonu ($200)");
        squares[25].setProperty(marmaray);

        squares[26].setDescription("BeylikdÃ¼zÃ¼ ($260) - Yellow");
        squares[26].setProperty(beylikduzu);

        squares[27].setDescription("AvcÄ±lar ($260) - Yellow");
        squares[27].setProperty(avcilar);

        squares[28].setDescription("Ä°ski ($150)");
        squares[28].setProperty(iski);

        squares[29].setDescription("KÃ¼Ã§Ã¼kÃ§ekmece ($280) - Yellow");
        squares[29].setProperty(kucukcekmece);

        squares[30].setDescription("Chance Cards");
        squares[30].setCard(pullRandomCard(chanceCards));

        squares[31].setDescription("Fatih($300) - Green");
        squares[31].setProperty(fatih);

        squares[32].setDescription("Taksim($300) - Green");
        squares[32].setProperty(taksim);

        squares[33].setDescription("Community Chest");
        squares[33].setCard(pullRandomCard(communityCards));

        squares[34].setDescription("KarakÃ¶y($300) - Green");
        squares[34].setProperty(karakoy);

        squares[35].setDescription("Durak ($200)");
        squares[35].setProperty(durak);

        squares[36].setDescription("Chance");
        squares[36].setCard(pullRandomCard(chanceCards));

        squares[37].setDescription("Dudullu($350) - NavyBlue");
        squares[37].setProperty(dudullu);

        squares[38].setDescription("Government Tax ($75)");

        squares[39].setDescription("Tuzla($400) - NavyBlue");
        squares[39].setProperty(tuzla);

    }

    public static Card pullRandomCard(Card[] cards){

        int randomNumber = (int)(2*Math.random());

        return cards[randomNumber];
    }

    public Square[] getSquares() {
        return squares;
    }

}
