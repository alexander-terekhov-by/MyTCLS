package sample.model;


import sample.view.DetectorView;

public class Detector {

    private int unitCounts;
    private DetectorView view;

    public void setView(DetectorView view) {
        this.view = view;
        view.setText(Integer.toString(unitCounts));
    }

    public void addUnit() {
        unitCounts++;
        view.setText(Integer.toString(unitCounts));
    }

    public void skipUnit() {
        if(unitCounts != 0) {
            unitCounts--;
            view.setText(Integer.toString(unitCounts));
        }
    }

    public void setUnitCounts(int unitCounts) {
        this.unitCounts = unitCounts;

    }

    public int getUnitCounts() {
        return unitCounts;
    }
}