package dungeon;

import java.util.Scanner;
import java.util.Random;

public class Dungeon 
{

    public static void main(String[] args) 
    {
        //Generation + Call-outs
        EPlayer player = new EPlayer();
        Scanner in = new Scanner(System.in);
        Scanner pName = new Scanner(System.in);
        Random rnd = new Random();

        //Calls out from files			
        int HP = player.HP;
        int round = player.round;
        int koffe = player.koffe;
        int coins = player.coins;
        
        //PLAYER NAME
        if(round == 1)
        {
        System.out.print("What is your name: ");
        player.name = pName.nextLine();
        }
        String name = player.name;
        
        //GAME STARTS
        boolean running = true;
        
        //WELCOME MESSAGE
        System.out.println("Welcome " + name+ ", to the programming dungeon."
                       + "\nYou are the hero prophesied in ancient time by the great prophet known as J."
                       + "\nThe prophet foretold that you would venture into this dungeon and slay the mad king Lynus."
                       + "\nWell, I wish you luck brave adventurer. And please dont die on me, we don't have the resources to recover your belongings."
                       + "\n");
        
        //COMBAT
        start:
        while(running) 
        {
            //MOVED THIS HERE CUZ WHEN ITS IN "Generation + Call-outs" NAMES AND HP DONT CHANGE FOR ENEMYS
            EEnemy enemy = new EEnemy();
            EBoss boss = new EBoss();
            int EHP = enemy.HP;
            int BHP = boss.HP;
            String challenger = enemy.names;
            String Bchallenger = boss.names;
            
            if(round % 5 == 0)
            {
                System.out.println("\tOut of the darkness a " + Bchallenger + " has appeared!");
            }
            else
            {
                System.out.println("\tA wild " + challenger + " has appeared!");
            }
            
            while(EHP > 0 && BHP > 0) 
            {
                System.out.println("\t" + name + "'s HP: " + HP + "(" + koffe + ") ♥");
                if(round % 5 == 0)
                {
                    System.out.println("\t" + Bchallenger + "'s HP: " + BHP+" ♥");
                }
                else
                {
                    System.out.println("\t" + challenger + "'s HP: " + EHP+" ♥");
                }
                System.out.println("\n\tWhat do you do?:");
                System.out.println("\t[1] Solve the problem.");
                System.out.println("\t[2] Drink a cup of Köffe™.");
                System.out.println("\t[3] Turn it off and on again.");
                
                String input = in.nextLine();
                //BOSS FIGHT
                if(input.equals("1") && round % 5 == 0) 
                {
                    int dmgD = rnd.nextInt(player.AD);
                    int dmgT = rnd.nextInt(boss.AD);
                    
                    BHP -= dmgD;
                    HP -= dmgT;
                    
                    System.out.println("\t" + name + " has hit " + Bchallenger + " causing " + dmgD + " damage.");
                    System.out.println("\t" + name + " has lost " + dmgT + "HP.\n");
                    if(HP <= 0)
                    {
                        System.out.println("\n\t☠ " + name + " has fallen in battle, slayin by the mighty "+Bchallenger+".☠");
                        break;
                    }
                }
                //FIGHT
                else if(input.equals("1")) 
                {
                    int dmgD = rnd.nextInt(player.AD);
                    int dmgT = rnd.nextInt(enemy.AD);
                    
                    EHP -= dmgD;
                    HP -= dmgT;
                    
                    System.out.println("\t" + name + " has hit " + challenger + " causing " + dmgD + " damage.");
                    System.out.println("\t" + name + " has lost " + dmgT + "HP.\n");
                    if(HP <= 0)
                    {
                        System.out.println("\n\t☠ " + name + " has fallen in battle.☠");
                        break;
                    }
                }
                //HEALTH REGEN
                else if(input.equals("2"))
                {
                    if(koffe > 0) 
                    {
                        HP += player.koffeheal;
                        koffe--;
                        System.out.println("\t" + name + " takes the Köffe™ and gulps it down with vigor, thus healing " + player.koffeheal + "HP."
                                           + "\n\tCurent health: " + HP);
                    }
                    else
                    {
                        System.out.println("\tYou're all out of Köffe™, you can restock every 5 floors at office kitchen.");
                    }
                }
                //ESCAPE
                else if(input.equals("3") && round % 5 == 0)
                {
                    System.out.println("\tYou cannot escape from " +Bchallenger+ ".");
                }
                else if(input.equals("3"))
                {
                    System.out.println("\tYou restart your PC to solve the " +challenger+ " issue.");
                    continue start;
                }
                else
                {
                    System.out.println("\tINVALID INPUT");
                }
            }
            
            //FINISH + RESET
            if(HP <= 0)
            {
                System.out.println("\tThough you have perished, the forces of Lynus must be defeated, another warrior will take your place and save these lands.");
                player.setHP(100);
                player.setKoffe(3);
                player.setCoins(0);
                player.setName("John Doe");
                player.setRound(1);
                break;
            }
            
            //BOSS REWARDS
            if(round % 5 == 0)
            {
                System.out.println("ﾟ*°★ " +Bchallenger+ " was defeated. ★°*ﾟ");
                System.out.println("♥ You have "+HP+"HP left. ♥");
                int coindrop = rnd.nextInt(25);
                coins += coindrop;
                System.out.println("♦ You have found "+coindrop+" coins, you have "+coins+" in total. ♦");
            }
            //REWARDS
            else
            {
            System.out.println("ﾟ*°★ " +challenger+ " was defeated. ★°*ﾟ");
            System.out.println("♥ You have "+HP+"HP left. ♥");
            int coindrop = rnd.nextInt(10);
            coins += coindrop;
            System.out.println("♦ You have found "+coindrop+" coins, you have "+coins+" in total. ♦");
            }
            //SHOP
            while(round % 5 == 0)
            {
                System.out.println("\nYou have found a office kitchen and in it a vending machine.");
                System.out.println("Would you like to purchase anything?:");
                System.out.println("\t[1] Buy Köffe™ for 10 coins");
                System.out.println("\t[2] No thanks.");

                String Sinput = in.nextLine();

                while(!Sinput.equals("1") && !Sinput.equals("2"))
                {
                    System.out.println("INVALID INPUT");
                    Sinput = in.nextLine();
                }
                
                if(Sinput.equals("1") && coins >= 10)
                {
                   coins=coins-10;
                   System.out.println("\n\t♦You have gained Köffe™.♦");
                   System.out.println("\t♦ "+coins+" coins remaining.♦");
                   koffe++;
                   System.out.println("\t♦ "+koffe+" Köffe™ in inventory.♦");
                }
                else if(Sinput.equals("1") && coins < 10)
                {
                    System.out.println("You dont have enought money, so you skip lunch brake.");
                    break;
                }
                else if(Sinput.equals("2"))
                {
                    System.out.println("You skip your lunch brake.");
                    break;
                }
            }
            //CONTINUATION
            round++;
            System.out.println("What do you do?:");
            System.out.println("[1] Head forth.");
            System.out.println("[2] ALT+F4");
            
            String input = in.nextLine();
            
            while(!input.equals("1") && !input.equals("2"))
            {
                System.out.println("INVALID INPUT");
                input = in.nextLine();
            }
            
            if(input.equals("1"))
            {
               System.out.println("\n\t♦You continue your journey to the " + round +". floor.♦"); 
            }
            //FINISH + SAVE
            else if(input.equals("2"))
            {
                System.out.println("You wake up from falling asleep at you dask and find yourself to be the onlyone still at the office,"
                        + "\nyou decide to go home, take a bath, drink some coffe and go to bed."
                        + "\n\tTHE END");
                player.setHP(HP);
                player.setKoffe(koffe);
                player.setCoins(coins);
                player.setName(name);
                player.setRound(round);
                break;
            }
        }
        int roundT = round - 1;
        System.out.println("\n");
        System.out.println("\nTotal floors defeated: "+roundT);
        System.out.println("☺ THANKS FOR PLAYING ☺");
    } 
}
