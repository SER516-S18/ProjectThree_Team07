# SER-516, Spring 2018 (ASU) : Project 3 - Team 007

## Open Source Initiative of the EMOTIV Control Panel Project

### Team Members

* Abhishek Parmar - 87
* Aditya Kumar - 80
* Dileep Pandey - 84
* Gopika Sreedhara Pai - 82
* Isidro Perez - 90
* Jay Patel - 88
* Meet Patel - 89
* Namratha Olety Venkatesh - 81
* Raam Prashanth Namakkal Sudhakar - 79
* Saurabh Prakash - 91
* Shipra Panwar - 85
* Suman Parlapalli - 86
* Tejasi Palkar - 83

## How to Compile Project

### Mac/Linux

Make build.sh executable

    chmod +x build.sh

Compile

    ./build.sh
    
### Windows

Compile

    build.bat

## How to Run Project

    java -jar client.jar
    
<div style="color:red;font-size:1.5em;">Please compile the project before executing the jar.</div>

#### Things to note
    Smile > 0.5
    clench > 0.5
    smirk left > 0
    smirk right > 0
    laugh > 0
    eyebrows raise > 0
    eyebrow furrow > 0

blink, wink left, wink right, look right, look left are boolean and work when Active is clicked.

The option to change the facial expression in image view or emoji view will only work when next calls reach the client