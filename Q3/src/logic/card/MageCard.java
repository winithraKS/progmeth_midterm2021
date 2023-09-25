package logic.card;

import logic.player.Player;
public class MageCard extends BaseCard{
    Element mageType;

    public MageCard(String name, int power, int health, Element mageType) {
        super(name, power, health);
        this.mageType = mageType;
    }

    public Element getMageType() {
        return mageType;
    }

    public void setMageType(Element mageType) {
        this.mageType = mageType;
    }

    @Override
    public void play(Player player) {
        int n=0;
        for(BaseCard bc:player.getField()){
            if(bc instanceof OrbCard) {
                if(((OrbCard) bc).getOrbType()==this.mageType) n+=1 ;
            }
        }
        this.setPower(this.getPower()+n);
    }

    @Override
    public boolean canPlay(Player player) {
        for(BaseCard bc: player.getField()){
            if(bc instanceof OrbCard) {
                if(((OrbCard) bc).getOrbType()==this.mageType) return true;
            }
        }
        return false;
    }
}
