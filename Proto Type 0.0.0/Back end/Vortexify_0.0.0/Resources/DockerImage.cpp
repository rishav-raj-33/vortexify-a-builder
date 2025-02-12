#include <iostream.h>
#include <fstream>
using namespace std;

string projectName;
string path;

void writeData(ofstream &write)
{

    write.open(path + "Dockerfile", ios::app);
    write << "FROM maven:3-openjdk-17 AS build" << "\n ";
    write << "COPY . ." << "\n";
    write << "RUN mvn clean package -DskipTests" << "\n";
    write << "FROM openjdk:17.0.1-jdk-slim" << "\n";
    write << "COPY --from=build /target/Jobmatic-0.0.1-SNAPSHOT.jar Jobmatic.jar" << "\n";
    write << "EXPOSE 8080" << "\n";
    write << "ENTRYPOINT [\"java\", \"-jar\", \"Jobmatic.jar\"]" << "\n";
    write.close();
}

int main(int argc, char *argv[])
{
    ofstream w;
    projectName = string(argv[1]);
    path = string(argv[2]);
    writeData(w);
}
