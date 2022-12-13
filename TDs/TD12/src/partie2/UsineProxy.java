package partie2;

public class UsineProxy<T extends Usine> implements Usine {

    T usine;

    UsineProxy(T usine) {
        this.usine = usine;
    }

    @Override
    public void setAddress(String address) {
        System.out.println(usine.getAddress() + "-->" + address);
        usine.setAddress(address);
    }

    @Override
    public void setName(String name) {
        System.out.println(usine.getName() + "-->" + name);
        usine.setName(name);
    }

    @Override
    public String getName() {
        return usine.getName();
    }

    @Override
    public String getAddress() {
        return usine.getAddress();
    }

}
