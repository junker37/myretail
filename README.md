# myRetail
## Testing
Run the tests using maven
```
cd maven
mvn clean test
[INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] parent
[INFO] api
[INFO] webservices
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building parent 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.3:clean (default-clean) @ parent ---
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building api 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.3:clean (default-clean) @ api ---
[INFO] Deleting file set: /home/jeremy/Dropbox/workspaces/myRetail/maven/api/target (included: [**], excluded: [])
[INFO] 
[INFO] --- maven-resources-plugin:2.3:resources (default-resources) @ api ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ api ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 8 source files to /home/jeremy/Dropbox/workspaces/myRetail/maven/api/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.3:testResources (default-testResources) @ api ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ api ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 6 source files to /home/jeremy/Dropbox/workspaces/myRetail/maven/api/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.10:test (default-test) @ api ---
[INFO] Surefire report directory: /home/jeremy/Dropbox/workspaces/myRetail/maven/api/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.myretail.api.pricing.PricingDataTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.179 sec
Running com.myretail.api.ProductAPIResultTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running com.myretail.api.MyRetailAPIImplTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.159 sec
Running com.doapps.myretail.api.info.ProductInfoTest
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.401 sec

Results :

Tests run: 14, Failures: 0, Errors: 0, Skipped: 0

[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building webservices 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.3:clean (default-clean) @ webservices ---
[INFO] Deleting file set: /home/jeremy/Dropbox/workspaces/myRetail/maven/webservices/target (included: [**], excluded: [])
[INFO] 
[INFO] --- maven-resources-plugin:2.3:resources (default-resources) @ webservices ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ webservices ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 3 source files to /home/jeremy/Dropbox/workspaces/myRetail/maven/webservices/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.3:testResources (default-testResources) @ webservices ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ webservices ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/jeremy/Dropbox/workspaces/myRetail/maven/webservices/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.10:test (default-test) @ webservices ---
[INFO] Surefire report directory: /home/jeremy/Dropbox/workspaces/myRetail/maven/webservices/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.myretail.api.resource.ProductsResourceTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.14 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO] 
[INFO] parent ............................................ SUCCESS [0.514s]
[INFO] api ............................................... SUCCESS [10.094s]
[INFO] webservices ....................................... SUCCESS [1.807s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 12.659s
[INFO] Finished at: Wed Apr 08 19:24:03 CDT 2015
[INFO] Final Memory: 26M/309M
[INFO] ------------------------------------------------------------------------
``` [INFO] Scanning for projects...
[INFO] ------------------------------------------------------------------------
[INFO] Reactor Build Order:
[INFO] 
[INFO] parent
[INFO] api
[INFO] webservices
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building parent 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.3:clean (default-clean) @ parent ---
[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building api 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.3:clean (default-clean) @ api ---
[INFO] Deleting file set: /home/jeremy/Dropbox/workspaces/myRetail/maven/api/target (included: [**], excluded: [])
[INFO] 
[INFO] --- maven-resources-plugin:2.3:resources (default-resources) @ api ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ api ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 8 source files to /home/jeremy/Dropbox/workspaces/myRetail/maven/api/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.3:testResources (default-testResources) @ api ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ api ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 6 source files to /home/jeremy/Dropbox/workspaces/myRetail/maven/api/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.10:test (default-test) @ api ---
[INFO] Surefire report directory: /home/jeremy/Dropbox/workspaces/myRetail/maven/api/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.myretail.api.pricing.PricingDataTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.179 sec
Running com.myretail.api.ProductAPIResultTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 sec
Running com.myretail.api.MyRetailAPIImplTest
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 5.159 sec
Running com.doapps.myretail.api.info.ProductInfoTest
Tests run: 6, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.401 sec

Results :

Tests run: 14, Failures: 0, Errors: 0, Skipped: 0

[INFO]                                                                         
[INFO] ------------------------------------------------------------------------
[INFO] Building webservices 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- maven-clean-plugin:2.3:clean (default-clean) @ webservices ---
[INFO] Deleting file set: /home/jeremy/Dropbox/workspaces/myRetail/maven/webservices/target (included: [**], excluded: [])
[INFO] 
[INFO] --- maven-resources-plugin:2.3:resources (default-resources) @ webservices ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ webservices ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 3 source files to /home/jeremy/Dropbox/workspaces/myRetail/maven/webservices/target/classes
[INFO] 
[INFO] --- maven-resources-plugin:2.3:testResources (default-testResources) @ webservices ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ webservices ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/jeremy/Dropbox/workspaces/myRetail/maven/webservices/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.10:test (default-test) @ webservices ---
[INFO] Surefire report directory: /home/jeremy/Dropbox/workspaces/myRetail/maven/webservices/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.myretail.api.resource.ProductsResourceTest
Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.14 sec

Results :

Tests run: 2, Failures: 0, Errors: 0, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] Reactor Summary:
[INFO] 
[INFO] parent ............................................ SUCCESS [0.514s]
[INFO] api ............................................... SUCCESS [10.094s]
[INFO] webservices ....................................... SUCCESS [1.807s]
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 12.659s
[INFO] Finished at: Wed Apr 08 19:24:03 CDT 2015
[INFO] Final Memory: 26M/309M
[INFO] ------------------------------------------------------------------------
```


