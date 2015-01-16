package AppPackage;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MainClass 
{
 
    
    FileInputStream FIS;  // returns the files in bytes
    
    BufferedInputStream BIS; 
    
    public long pauseLocation;
    
    public long totalLengthOfSong;
    
    String filelocation;
    
    
    public Player player ;
    
     public void stop(){
         //This is method will stop playing the song !! ..
        
         // we check with if statement if the song is playing or not..
         
         if(player!=null){ // if player has something to play ..
             
             player.close(); // this is stop player for playing that song
             
         }
         
         
         
     }
     
     
     public void pause(){
         //This is method will pause song where we left of  !! ..
        
         // we check with if statement if the song is playing or not..
         
         if(player!=null){ try {
             // if player has something to play ..
             
             
           pauseLocation=  FIS.available(); // this method will get how much song is left 
             
             player.close(); // this is stop player for playing that song
             } catch (IOException ex) {
                 
             }
             
         }
         
         
         
     }
     
     
     
     
     public void play(String pathOfMusic){ try {
         // will pass the path of music in this method ..
         
         //This method will play the song 
         
         
         FIS = new FileInputStream(pathOfMusic);
         BIS = new BufferedInputStream(FIS);
         
         filelocation = pathOfMusic+"";
         
         
         try {
             player = new Player(BIS);
         } catch (JavaLayerException ex) {
             
             
             
         }
         
         
        } catch (FileNotFoundException ex) {
            
        }
         
        
        new Thread(){
            
            @Override
            public void run(){
                
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    
                }
                
            }
            
        }.start();
     
         
     }
     
     
     
     
      public void resume(){  try {
         // will pass the path of music in this method ..
         
         //This method will play the song 
         
         
         FIS = new FileInputStream(filelocation);
         BIS = new BufferedInputStream(FIS);
         
         totalLengthOfSong =FIS.available();
         
         
         FIS.skip(totalLengthOfSong - pauseLocation);
         
         
         try {
             player = new Player(BIS);
         } catch (JavaLayerException ex) {
             
             
             
         }
         
         
        } catch (FileNotFoundException ex) {
            
        } catch (IOException ex) {
            Logger.getLogger(MainClass.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        new Thread(){
            
            @Override
            public void run(){
                
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    
                }
                
            }
            
        }.start();
     
         
     }
     
    
    
}
