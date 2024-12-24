package io.jsondb.spring.boot.starter;

import jakarta.validation.constraints.NotBlank;
import java.util.List;

public class JsonDBTemplateProperties {
    @Override
    public String toString() {
        return "JsonDBTemplateProperties [" + dbFilesLocation + ", " + baseScanPackage + ", " + compatibilityMode + ", " + schemaComparatorBean + ", " + cipherBean + ", " + collectionClassNames + "]";
    }

    @NotBlank
    private String dbFilesLocation;
    @NotBlank
    private String baseScanPackage;
    private boolean compatibilityMode = false;
    private String schemaComparatorBean;
    private String cipherBean;
    private List<String> collectionClassNames;

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

    public List<String> getCollectionClassNames() {
        return collectionClassNames;
    }

    public void setCollectionClassNames(List<String> collectionClassNames) {
        this.collectionClassNames = collectionClassNames;
    }

}
