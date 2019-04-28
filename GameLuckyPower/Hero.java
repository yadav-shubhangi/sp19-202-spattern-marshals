import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hero extends Actor
{
    /**
     * Act - do whatever the Hero wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
     private int dir = -1;
     private int speed = 4;
    public Hero()
    
    {
        GreenfootImage image = getImage();
        image.scale(image.getWidth() + 50, image.getHeight() + 50);
        setImage(image);
    }
    public void act()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            if(this.getX()+this.getImage().getWidth() < getWorld().getWidth())
                this.setLocation(this.getX() + 10,this.getY());
        }
        else if(Greenfoot.isKeyDown("left"))
        {  
            if(this.getX()-this.getImage().getWidth()> 0)
                this.setLocation(this.getX() - 5, this.getY());
        }
        else if(Greenfoot.isKeyDown("up"))
        {
            if(this.getY()-this.getImage().getHeight() > 0)
                this.setLocation(this.getX(), this.getY() - 5);
        }
        else if(Greenfoot.isKeyDown("down"))
        { 
            if(this.getY()+this.getImage().getHeight() < getWorld().getHeight())
               this.setLocation(this.getX(), this.getY() + 5);
        }
        
    }   
}
