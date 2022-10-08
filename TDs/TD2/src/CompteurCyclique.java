public class CompteurCyclique {
    private final int sup;
    private int value;

    public CompteurCyclique(int sup, int index){
        this.value = index % sup;
        this.sup = sup;
    }

    public CompteurCyclique(int sup){
        this(sup,0);
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int n){
        if (n < 0) this.value = sup - ((-n)%sup);
        else this.value = n % sup;
    }

    public void reinitialiser(){
        this.value = 0;
    }

    public boolean incrementer(){
        this.setValue(this.value + 1);
        return this.value == 0;
    }


    public String toString(){
        return String.format("%0" + ((int)Math.log10(this.sup)+1) +"d", this.value);
    }
}
