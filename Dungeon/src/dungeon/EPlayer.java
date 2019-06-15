package dungeon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EPlayer 
{
    //PLAYER INFO READ
        public static int Health()
        {
            int result;
            String line = "", fileContent = "";
            Path local = Paths.get("C:\\Dungeon - Save\\HP.txt");
            try 
            {
                BufferedReader file = Files.newBufferedReader(local, Charset.forName("UTF-8"));
                line = file.readLine();
                fileContent = line;
                while(line != null) 
                {
                    line = file.readLine();
                    if(line != null)
                    fileContent += line;
                }
                result = Integer.parseInt(fileContent);
                file.close();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result = Integer.parseInt(fileContent);
        }
        public static int Koffe()
        {
            int result;
            String line = "", fileContent = "";
            Path local = Paths.get("C:\\Dungeon - Save\\KOFFE.txt");
            try 
            {
                BufferedReader file = Files.newBufferedReader(local, Charset.forName("UTF-8"));
                line = file.readLine();
                fileContent = line;
                while(line != null) 
                {
                    line = file.readLine();
                    if(line != null)
                    fileContent += line;
                }
                result = Integer.parseInt(fileContent);
                file.close();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result = Integer.parseInt(fileContent);
        }
        public static int Coins()
        {
            int result;
            String line = "", fileContent = "";
            Path local = Paths.get("C:\\Dungeon - Save\\COINS.txt");
            try 
            {
                BufferedReader file = Files.newBufferedReader(local, Charset.forName("UTF-8"));
                line = file.readLine();
                fileContent = line;
                while(line != null) 
                {
                    line = file.readLine();
                    if(line != null)
                    fileContent += line;
                }
                result = Integer.parseInt(fileContent);
                file.close();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result = Integer.parseInt(fileContent);
        }
        public static int Round()
        {
            int result;
            String line = "", fileContent = "";
            Path local = Paths.get("C:\\Dungeon - Save\\ROUND.txt");
            try 
            {
                BufferedReader file = Files.newBufferedReader(local, Charset.forName("UTF-8"));
                line = file.readLine();
                fileContent = line;
                while(line != null) 
                {
                    line = file.readLine();
                    if(line != null)
                    fileContent += line;
                }
                result = Integer.parseInt(fileContent);
                file.close();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return result = Integer.parseInt(fileContent);
        }
        public static String Name()
        {
            String line = "", fileContent = "";
            Path local = Paths.get("C:\\Dungeon - Save\\NAME.txt");
            try 
            {
                BufferedReader file = Files.newBufferedReader(local, Charset.forName("UTF-8"));
                line = file.readLine();
                fileContent = line;
                while(line != null) 
                {
                    line = file.readLine();
                    if(line != null)
                    fileContent += line;
                }
                
                file.close();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
            }
            return fileContent;
        }
    
    //VALUES
    int HP = Health();
    Random rnd = new Random();
    int AD = 20;
    int koffe = Koffe();
    int koffeheal = 20;
    int coins = Coins();
    String name = Name();
    int round = Round();
    
    //PLAYER INFO SAVE
    public void setHP(int health)
    {
        try 
        {
            PrintWriter bw = new PrintWriter("C:\\Dungeon - Save\\HP.txt");
            bw.write(Integer.toString(health));          
            bw.close();            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setKoffe(int koffe)
    {
        try 
        {
            PrintWriter bw = new PrintWriter("C:\\Dungeon - Save\\KOFFE.txt");
            bw.write(Integer.toString(koffe));          
            bw.close();            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setCoins(int coins)
    {
        try 
        {
            PrintWriter bw = new PrintWriter("C:\\Dungeon - Save\\COINS.txt");
            bw.write(Integer.toString(coins));          
            bw.close();            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setName(String TextName)
    {
        try 
        {
            PrintWriter bw = new PrintWriter("C:\\Dungeon - Save\\NAME.txt");
            bw.write(TextName);          
            bw.close();            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void setRound(int rounds)
    {
        try 
        {
            PrintWriter bw = new PrintWriter("C:\\Dungeon - Save\\ROUND.txt");
            bw.write(Integer.toString(rounds));          
            bw.close();            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Dungeon.class.getName()).log(Level.SEVERE, null, ex);
        }    }
}
