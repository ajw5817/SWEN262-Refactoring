public interface Pinsetter {

    void ballThrown();
    void reset();
    void resetPins();
    void subscribe(PinsetterObserver subscriber);
    void handleThrow(boolean throwAgain, boolean tenthFrameStrike);
    boolean getCanThrowAgain();
    boolean getTenthFrameStrike();

}
