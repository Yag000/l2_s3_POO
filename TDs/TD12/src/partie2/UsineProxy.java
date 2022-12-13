package partie2;

public class UsineProxy extends MonUsine {

    @Override
    public void setAddress(String address) {
        System.out.println(getAddress() + "-->" + address);
        super.setAddress(address);
    }

    @Override
    public void setName(String name) {
        System.out.println(getName() + "-->" + name);
        super.setName(name);
    }

}
