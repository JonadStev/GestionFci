package com.istartDigital.coreBussines.dto;

public class DataSets {

    private final String label = "Cuentas baneadas";
    private final String backgroundColor = "#42a5f5";
    private Integer [] datasets;

    public DataSets() {
    }

    public DataSets(Integer[] datasets) {
        this.datasets = datasets;
    }

    public String getLabel() {
        return label;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public Integer[] getDatasets() {
        return datasets;
    }

    public void setDatasets(Integer[] datasets) {
        this.datasets = datasets;
    }
}
