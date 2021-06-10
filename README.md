
#### **Pre-requisites**
1. JDK 11
2. Maven 3.6.3 or higher

### **How to Run the app**
1. Clone the project
2. Go to the Project root folder
3. Make sure you have your `$JAVA_HOME` set to your SDK folder version 11
   if not you can use `$export JAVA_HOME="/your_java_sdk_directory"`
4. Run `./mvnw clean compile package`
5. Run `java -jar target/graph-1.0-SNAPSHOT.jar graphData.txt`


