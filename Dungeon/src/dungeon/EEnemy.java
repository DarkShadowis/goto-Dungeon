package dungeon;

import java.util.Random;

public class EEnemy 
{
        Random rnd = new Random();

        //BOSS
        int HP = rnd.nextInt(39) + 1;
        int AD = 15;
        String[] enemy = {"goto", "JavaScript", "Windows Vista", "Scoliosis"};
        String names = enemy[rnd.nextInt(enemy.length)];

}
