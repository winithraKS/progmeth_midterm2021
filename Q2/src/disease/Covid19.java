package disease;

import util.R0;
import util.SevereLevel;

public class Covid19 extends Disease{
    private R0 reproductionNumber;
    private String countryOfFirstAppearance;

    //constructor

    public Covid19() {
        setCountryOfFirstAppearance("China");
        R0 r0 = new R0(2,3);
        setReproductionNumber(r0);
    }

    //getter&setter
    public R0 getReproductionNumber() {
        return reproductionNumber;
    }

    public void setReproductionNumber(R0 reproductionnumber) {
        this.reproductionNumber = reproductionnumber;
    }

    public String getCountryOfFirstAppearance() {
        return countryOfFirstAppearance;
    }

    public void setCountryOfFirstAppearance(String countryOfFirstAppearance) {
        this.countryOfFirstAppearance = countryOfFirstAppearance;
    }

    public SevereLevel severeLevel(boolean isVaccinated){
        if(isVaccinated) return SevereLevel.Less;
        return SevereLevel.SevereIllness;
    }

    public int minimumInfectionSpread(int n){
        int m = getReproductionNumber().getMin();
        return (int) (m*(1-Math.pow(m,n))/(1-m));
    }

    @Override
    public String toString() {
        return "Covid19";
    }
}
