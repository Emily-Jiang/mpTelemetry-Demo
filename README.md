Clone the repo 

Navigate to the system directory and start the server 

`cd system`

`mvn liberty:run`

Navigate to the inventory directory and start the server

`cd inventory`

`mvn liberty:run`

Without changes, the java agent will be collecting and exporting them to zipkin. You can change the service names and exporters etc... in the `jvm.options` files: 

https://github.com/yasmin-aumeeruddy/mpTelemetry-Demo/blob/main/system/src/main/liberty/config/jvm.options
https://github.com/yasmin-aumeeruddy/mpTelemetry-Demo/blob/main/inventory/src/main/liberty/config/jvm.options

You can disable the java agent with the option `-Dotel.javaagent.enabled=false`

To enable automatic instrumentation, change the `otel.sdk.disabled` property in the config properties files: 

https://github.com/yasmin-aumeeruddy/mpTelemetry-Demo/blob/main/system/src/main/resources/META-INF/microprofile-config.properties
https://github.com/yasmin-aumeeruddy/mpTelemetry-Demo/blob/main/inventory/src/main/resources/META-INF/microprofile-config.properties

Manual instrumentation will be enabled if you uncomment the following: 

https://github.com/yasmin-aumeeruddy/mpTelemetry-Demo/blob/main/system/src/main/java/io/openliberty/guides/system/SystemResource.java#L34-L38 

and 
https://github.com/yasmin-aumeeruddy/mpTelemetry-Demo/blob/main/system/src/main/java/io/openliberty/guides/system/SystemResource.java#L43-L44

Navigate to the following endpoints to create events to see spans: 

`http://localhost:9080/system/properties`

`http://localhost:9081/inventory/systems/localhost`
