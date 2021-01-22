# TextToXmlConverter
This is a simple application with the purpose of converting row based text into xml. The input data for the application is located in the resources folder and must be placed in input.txt for the application to work. The XML output is located in the output directory in the output.xml file.

The input data is structured as follows:

P|firstname|lastname<br />
T|mobilenumber|landlinenumber<br />
A|street|city|zipcode<br />
F|name|birthyear<br />

P rows can be followed by T,A and F<br />
F rows can be followed by T and A<br />

Example:<br />
P|Carl Gustaf|Bernadotte<br />
T|0768-101801|08-101801<br />
A|Drottningholms slott|Stockholm|10001<br />
F|Victoria|1977<br />
A|Haga Slott|Stockholm|10002<br />
F|Carl Philip|1979<br />
T|0768-101802|08-101802<br />
P|Barack|Obama<br />
A|1600 Pennsylvania Avenue|Washington, D.C<br />

Which gives the following XML output:

![converter](https://user-images.githubusercontent.com/21289637/105467007-5d4ad580-5c95-11eb-86fc-cbd20f611329.PNG)


#Compiling
Class files was comiled from the root directory with the following command: 

Jar file was compiled from the build directory with the following command:
