package logic.card;

import logic.player.Player;

public abstract class BaseCard {
    private String name;
    private int power;
    private int health;

    public BaseCard(String name,int power,int health){
        setPower(power);
        setHealth(health);
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = Math.max(0,power);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(0,health);
    }

    public abstract void play(Player player);

    public abstract boolean canPlay(Player player);

    public int attack(BaseCard target){
        int n = target.getHealth();
        target.setHealth(n-this.power);
        return Math.max(0,this.power-n);
    }
}
