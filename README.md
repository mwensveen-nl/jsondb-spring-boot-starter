# jsondb-spring-boot-starter
Spring boot starter for [JsonDB](https://github.com/mwensveen-nl/jsondb-core/wiki)

The main class to use in Jsondb is: io.jsondb.JsonDBTemplate
This starter will create a JsonDBTemplate bean.

## Config
Add the config below to your application.yml
``` 
io:
   jsondb:
     template:
        dbFilesLocation: "target/dbfiles"
        baseScanPackage: "io.jsondb.spring.boot.starter.model"
        compatibilityMode: true
        schemaComparatorBean: "MySchemaVersionComparator"
        cipherBean: "MyCipher"
        collectionClassNames:
          - io.jsondb.spring.boot.starter.model.User
          - io.jsondb.spring.boot.starter.model.Address
```

### explanation
* dbFilesLocation: (Mandatory) The folder where the json files need to be stored.
* baseScanPackage: (Mandatory) The java package that needs to be scanned for the Documents (POJOs with Document annotation).
* compatibilityMode: (Optional, default false)
* schemaComparatorBean: (Optional) The name of the spring bean used to compare schema versions. If not supplied, an instance of io.jsondb.DefaultSchemaVersionComparator is used
* cipherBean: (Optional) The name of the spring bean used to encrypt secrets
* collectionClassNames: (Optional) List of class names for which a collection will be created (if not already exist)