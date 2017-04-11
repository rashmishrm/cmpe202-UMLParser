
[![Stories in In%20Progress](https://badge.waffle.io/rashmishrm/cmpe202-UMLParser.png?label=In%20Progress&title=In%20Progress)](https://waffle.io/rashmishrm/cmpe202-UMLParser)

[![Stories in Ready](https://badge.waffle.io/rashmishrm/cmpe202-UMLParser.png?label=Ready&title=Ready)](https://waffle.io/rashmishrm/cmpe202-UMLParser)

# UML Generator

UML Generator takes source folder as input and generates class diagram as output

## Environment setup
  1. Requires Java 8 version
  2. Requires Graphviz installed on machine
  
  Windows:
  ```
  http://www.graphviz.org/Download..php
  ```
  Mac Command:
   ```
  brew install libtool
  brew link libtool
  brew install graphviz
  brew link --overwrite graphviz
  ```
  Linux Command
  ```
  sudo apt-get install graphviz
  ```
## How to Build this Application.

 Create Jar file.
 ```
  mvn clean package
 ```

## How to Run this Application.

   ## Run Manually.
  ```
  You can find test folder under test-cases folder. 
  umlgenerator.jar can be found in Executable-Jar folder.
  Copy Executable-Jar folder in your local machine and run below command from Executable-Jar folder only.
  
  java -jar umlgenerator.jar
  usage: umlparser
 -d <arg>   directory containing java files to be parsed
 -f <arg>   output file name
 -t <arg>   which type of diagram? 1-> class, 2-> sequence
 ```

 Sample Command:
 ```
  java -jar umlgenerator.jar -d /Users/rashmisharma/Documents/Spring_2017/cmpe202/personal-project/umlparser/uml-parser-test-1 -f first -t 1
  ```
  ## With Docker
    
    a) Build Docker Image
    
    ```
    docker build -t umlparser:latest
     ```
    
    b) Run With Docker.
    
     ```
    docker run umlparser test-case-folder image_name.jpg
     ```
    
