import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{   
    private Wall wall;
    private Sound music;
    //private static final String bgImageName = "city4.jpg";    //level1
    private static final double scrollSpeed = 2;
    private static  int picWidth ;
    private GreenfootImage bgImage, bgBase;
    private int scrollPosition = 0;
    private Component compo;
    private Strategy level1;
    private ScoreBoardSubject scoreboard;
    private Player player;
    private RivalController rivalController;
    RivalX rivalXPrime;
    RivalX rivalX;
    Coin coinPrime;
    Coin coin;
    LuckyCharm charmPrime;
    LuckyCharm luckyCharm;
    private LuckyPower luckypower;
    private CharmController charmController;
    NegativePower snake;
    GifImage gifImage  = new GifImage("RivalR.gif");
    Random rand = new Random();
    
    private LuckyPower coin1;
    private LuckyPower coin2;
    private LuckyPower coin3;
    private LuckyPower coin5;
    private LuckyPower coin6;
    private LuckyPower coin7;
   
    private LuckyCharm charm;
    private LuckyCharm charm1;
   
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 600, 1, false); 
         
        music=Sound.getInstance();
        level1=new Level1();
        compo=new Composite(this,level1.getfileName());
        bgImage = ((Actor)compo).getImage();
        setBackground(bgImage);
        picWidth=bgImage.getWidth();
        bgBase = new GreenfootImage(picWidth, getHeight());
        bgBase.drawImage(bgImage, 0, 0);
        music.playgamemusic();  
        //
        /*Actor actor = new Cloud();
int x = Greenfoot.getRandomNumber(getWidth()); // random x (possible)
int y = Greenfoot.getRandomNumber(getHeight()); // random y (possible)
if (Greenfoot.getRandomNumber(2) == 0) // which edge to be on
{
    x = (getWidth()-Greenfoot.getRandomNumber(2))%getWidth(); // random edge (left or right)
}
else
{
    y = (getHeight()-Greenfoot.getRandomNumber(2))%getHeight(); // ranom edge (top or bottom)
}
addObject(actor, x, y);*/
  
   //addObject(new Cloud(), getWidth() - 1, Greenfoot.getRandomNumber(getHeight()));  

        prepare();
   }      
   public void act()
    {
      
    }   
    public void createCoins(int x) {
        coin5 = new Coin();
        coin6 = new Coin();
        coin7 = new Coin();
        coin5.getImage().scale(50,50);
        coin6.getImage().scale(50,50);
        coin7.getImage().scale(50,50);
        addObject(coin5,x,225);
        addObject(coin6,x+100,225);
        addObject(coin7,x+150,225);
    }
    public void createCharm(int x) {
        charm1 = new LuckyCharm();
        // charm2 = new LuckyCharm();
        // charm3 = new LuckyCharm();
       // charm1.getImage().scale(50,50);
        charm1.getImage().scale(50,50);
        addObject(charm1,x,296);
    }         
    public void paint(int position)
    {   
        GreenfootImage bg = getBackground();
        bg.drawImage(bgBase, position, 0);
        bg.drawImage(bgImage, position + picWidth, 0);
    }   
    public void prepare()
    {   
        level1.load(this);

        rivalXPrime = new RivalX();
        rivalXPrime.setImage(gifImage.getCurrentImage());
        rivalController = new RivalController();
        addObject(rivalController, 0,0);
        rivalController.createRivals(790,this);
        
        coinPrime = new Coin();
        luckypower = new LuckyPower();
        addObject(luckypower, 0,0);
        luckypower.createRivals(368,this);
        
       charmPrime = new LuckyCharm();
       charmController = new CharmController();
       addObject(charmController, 0,0);
       charmController.createLuckyCharm(368,this);
    }   
    public void scroll(){
        scrollPosition -= scrollSpeed;
        while(scrollSpeed > 0 && scrollPosition < -picWidth) scrollPosition += picWidth;
        while(scrollSpeed < 0 && scrollPosition > 0) scrollPosition -= picWidth;
        paint(scrollPosition);
    }   
    public void stopped()
    {
        music.pausegamemusic();
    }       
    public void wait(int n) {
        while (n > 0)
            n--;
    }
    public void started(){
        music.pauseGameOver();
        Greenfoot.setWorld(new MyWorld());
        music.playgamemusic();
    }       
    public Player getPlayer() {
        return player;
    }
}
