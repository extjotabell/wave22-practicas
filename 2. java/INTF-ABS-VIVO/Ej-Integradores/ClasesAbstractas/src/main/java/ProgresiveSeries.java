public class ProgresiveSeries extends Prototype {

    private int step;

    @Override
    public Number next() {

        Number nextNumber = super.getValue().intValue() + step;

        setFirstTo(nextNumber);

        return super.getValue();
    }

    @Override
    public void reset() {
        setFirstTo(0);
    }

    @Override
    public void setFirstTo(Number firstValue) {
        super.setValue(firstValue);
    }

    public ProgresiveSeries(int step) {
        this.step = step;
        reset();
    }
}
