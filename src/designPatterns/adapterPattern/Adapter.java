package designPatterns.adapterPattern;

public class Adapter extends Adaptee implements Target {
    private Adaptee adaptee = new Adaptee();

    @Override
    public void request() {
        adaptee.adapteeRequest();
        System.out.println("Adapter实现了Target接口中的request方法，现在被调用啦！");
    }
}
