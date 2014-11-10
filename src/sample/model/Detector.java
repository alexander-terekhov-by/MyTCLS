package sample.model;


import sample.view.DetectorView;

public class Detector {

    private int unitCounts;
    private DetectorView view;

    public void setView(DetectorView view) {
        this.view = view;
    }

    public void addUnit() {
        unitCounts++;
        view.setText(Integer.toString(unitCounts));
    }

    public void removeUnit() {
        unitCounts--;
        view.setText(Integer.toString(unitCounts));
    }

    public int getUnitCounts() {
        return unitCounts;
    }
}