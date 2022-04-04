import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {

    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private int dirHitNum;

    // Initializing Monster objects
    private Monster skeleton = new Monster("Skeleton", 10, 2);
    private Monster bat = new Monster("Bat", 5, 3);
    private Monster snake = new Monster("Snake", 3, 5);
    private Monster ghost = new Monster("Ghost", 5, 3);
    private Monster golem = new Monster("Golem", 20, 2);

    private Player player;

    // Monster objects will be stored in this ArrayList and they will be chosen for fight encounters via random number generator
    private ArrayList<Monster> monsterList;

    // Game loop: Battle encounters functions, etc.
    public Game() {
        monsterList = new ArrayList<>();
        populateList();
        System.out.println("Game start");
        System.out.println("What's your name? \n");
        player = new Player(sc.next());

        // Starts the level count, when player beats 10 levels in a row, they win
        int levelCount = 1;

        // Initial allocation of skill points
        player.firstLevel();

        int guess;

        // Game loop ends when player has no more health
        while (player.getHP() > 0) {

            // Win game statement
            if (levelCount == 11) {
                System.out.println("YOU BEAT THE GAME!");
                break;
            }

                // Randomly picks out a monster object from the monsterList array list
                Monster monster = monsterList.get(random.nextInt(monsterList.size() - 1));
                dirHitNum = random.nextInt(10) + 1;
                int origHP = monster.getHP();
//                For testing purposes
//                System.out.println(dirHitNum);
                System.out.println(player.getName() + " encounters a " + monster.getName() + "!");

            while (player.getHP() > 0 || monster.getHP() > 0) {
                if (player.getHP() <= 0) {
                    System.out.println("Game over");
                    break;
                }

                System.out.println(player.getName() + ", guess a number: ");
                guess = sc.nextInt();
                player.attack(monster);

                if (guess == dirHitNum) {
                    monster.setHP(monster.getHP() - player.getATK());
                    System.out.println(player.getName() + " lands a direct hit! Does " + player.getATK() + " damage to the " + monster.getName());
                    if (monster.getHP() <= 0) {
                        System.out.println(player.getName() + " wins!");
                        monster.setHP(origHP);
                        levelCount++;
                        break;
                    } else {
                        monster.attack(player);
                    }
                } else {
                    System.out.println(player.getName() + " missed!");

                    // Will give player hints if they guess the wrong target number
                    if (guess > dirHitNum) {
                        System.out.println("Your guess was greater than the target");
                    } else {
                        System.out.println("Your guess was lower than the target");
                    }
                    monster.attack(player);
                }
                }
        }
    }

    // Populating monster list
    public void populateList() {
        monsterList.add(skeleton);
        monsterList.add(bat);
        monsterList.add(snake);
        monsterList.add(ghost);
        monsterList.add(golem);
    }
}
