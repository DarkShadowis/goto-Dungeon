package dungeon;

import java.util.Random;

public class EBoss
{
    Random rnd = new Random();
    
    //BOSS
    int HP = rnd.nextInt(79) + 1;
    int AD = 20;
    String[] enemy = {"Suse, the first sinner", "Brainfuck, god of Chaos", "WinRAR, knight of the ClockTower", "John Mecha, God of Gods"};
    String names = enemy[rnd.nextInt(enemy.length)];
    
}
