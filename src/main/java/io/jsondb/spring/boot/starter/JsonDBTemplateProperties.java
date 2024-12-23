package io.jsondb.spring.boot.starter;

public class JsonDBTemplateProperties {

    private String dbFilesLocation;
    private String baseScanPackage;
    private boolean compatibilityMode = false;
    private String schemaComparatorBean;
    private String cipherBean;

    public String getDbFilesLocation() {
        return dbFilesLocation;
    }

    public void setDbFilesLocation(String dbFilesLocationString) {
        this.dbFilesLocation = dbFilesLocationString;
    }

    public String getBaseScanPackage() {
        return baseScanPackage;
    }

    public void setBaseScanPackage(String baseScanPackage) {
        this.baseScanPackage = baseScanPackage;
    }

    public boolean isCompatibilityMode() {
        return compatibilityMode;
    }

    public void setCompatibilityMode(boolean compatibilityMode) {
        this.compatibilityMode = compatibilityMode;
    }

    public String getSchemaComparatorBean() {
        return schemaComparatorBean;
    }

    public void setSchemaComparatorBean(String schemaComparatorBean) {
        this.schemaComparatorBean = schemaComparatorBean;
    }

    public String getCipherBean() {
        return cipherBean;
    }

    public void setCipherBean(String cipherBean) {
        this.cipherBean = cipherBean;
    }

}
