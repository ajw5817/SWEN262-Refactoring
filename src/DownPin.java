public class DownPin implements Pin {

    @Override
    public Pin knockDown() {
        return this;
    }

    @Override
    public Pin setUp() {
        return new UpPin();
    }

    @Override
    public boolean isUp() {
        return false;
    }
}
