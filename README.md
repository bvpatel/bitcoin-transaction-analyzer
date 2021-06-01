Bitcoin Transaction Analyzer
=============
Version number: 1.0 R1

The Bitcoin Transaction Analyzer allows a user to analyze bitcoin block by block height and returns the top N transactions that have the largest ancestry.

Tools and Technologies used
---------------------------
* Java
* Maven

Prerequisite
-------------
1. Java (11.0.11)
2. Maven (3.6.3)

Getting started
---------------
1. Goto Project folder
2. Install maven dependencies
   ```sh
   mvn install
   ```
2. To run application. Please pass input file path and output file path in args.
   ```sh
   mvn package
   mvn exec:java -Dexec.args="-b 680000 -n 10"