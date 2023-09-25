package disease;

import util.R0;
import util.SevereLevel;

public class Delta extends Covid19{
    private int spikeProtein;

    public int getSpikeProtein() {
        return spikeProtein;
    }

    public void setSpikeProtein(int spikeProtein) {
        this.spikeProtein = spikeProtein;
    }

    @Override
    public String toString() {
        return "Delta";
    }

    public Delta(){
        setCountryOfFirstAppearance("India");
        R0 r0 = new R0(5,7);
        setReproductionNumber(r0);
        setSpikeProtein(10);
    }

    public SevereLevel severeLevel(boolean isVaccinated){
        if(isVaccinated) return SevereLevel.MildOrLess;
        return SevereLevel.SevereIllness;
    }

    @Override
    public int minimumInfectionSpread(int n) {
        return super.minimumInfectionSpread(n);
    }
}
