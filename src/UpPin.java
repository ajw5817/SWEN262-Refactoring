public class UpPin implements Pin {

    @Override
    public Pin knockDown() {
        return new DownPin();
    }

    @Override
    public Pin setUp() {
        return this;
    }

    @Override
    public boolean isUp() {
        return true;
    }
}
