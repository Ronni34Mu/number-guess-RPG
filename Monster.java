public class Monster {

    private String name;
    private int HP;
    private int ATK;

    public Monster(String name, int HP, int ATK) {
        this.name = name;
        this.HP = HP;
        this.ATK = ATK;
    }

    public void attack(Player player) {
        System.out.println(name + " attacks " + player.getName() + " for " + this.ATK + " damage.");
        player.setHP(player.getHP() - this.ATK);
        System.out.println(player.getName() + " now has " + player.getHP() + " HP");
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
}
