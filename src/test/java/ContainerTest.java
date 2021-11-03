import junit.framework.TestCase;

public class ContainerTest extends TestCase {

    public void testAdd() {
        Container cnt = new Container();
        cnt.add(cnt,4);
        cnt.add(cnt,3);
        cnt.add(cnt,67);
    }

    public void testDelete_by_position() {
        Container cnt = new Container();
        cnt.add(cnt,4);
        cnt.add(cnt,3);
        cnt.delete_by_position(cnt,2);
        cnt.delete_by_position(cnt,0);
    }

    public void testDelete_by_value() {
        Container cnt = new Container();
        cnt.add(cnt,4);
        cnt.add(cnt,4);
        cnt.add(cnt,3);
        cnt.add(cnt,67);
        cnt.delete_by_value(cnt,4);
        cnt.delete_by_value(cnt,34);
    }

    public void testPrint() {
        Container cnt = new Container();
        cnt.print(cnt);
        cnt.add(cnt,4);
        cnt.add(cnt,4);
        cnt.add(cnt,3);
        cnt.add(cnt,67);
        cnt.print(cnt);
    }
}