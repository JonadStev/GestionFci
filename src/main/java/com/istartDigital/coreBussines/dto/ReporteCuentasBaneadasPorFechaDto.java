package com.istartDigital.coreBussines.dto;

public class ReporteCuentasBaneadasPorFechaDto {

    private String [] labels;
    private DataSets datasets;

    public ReporteCuentasBaneadasPorFechaDto() {
    }

    public ReporteCuentasBaneadasPorFechaDto(String[] labels, DataSets datasets) {
        this.labels = labels;
        this.datasets = datasets;
    }

    public String[] getLabels() {
        return labels;
    }

    public void setLabels(String[] labels) {
        this.labels = labels;
    }

    public DataSets getDatasets() {
        return datasets;
    }

    public void setDatasets(DataSets datasets) {
        this.datasets = datasets;
    }
}
