import java.util.Scanner;

public class Player implements LevelUp {

    private Scanner sc = new Scanner(System.in);
    private String name;
    private int HP = 10; // Base health is 10 points, goes up by 3 for every point added to the healthSP skill.
    private int healthSP = 0;
    private int ATK = 3; // = How much damage you do on direct hits (correct guesses), is cut in half or less if you're only in surrounding range of numbers (close guesses)
    private int SP = 10; // (Skill points) Start with 10 at beginning

    public Player(String name) {
        this.name = name;
    }

    public void attack(Monster monster) {
        System.out.println(name + " attacks " + monster.getName());
    }

    @Override
    public void firstLevel() {
        System.out.println("Allocate your skill points " + name + ": ");
        while (SP > 0) {
            System.out.println("1: HP skill points: " + healthSP);
            System.out.println("2: ATK skill points: " + ATK);
            System.out.println("You have " + SP + " skill points to allocate: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    healthSP += 1;
                    HP += 3;
                    break;
                case 2:
                    ATK += 1;
                    break;
            }
            SP -= 1;
        }

    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getATK() {
        return ATK;
    }

}
