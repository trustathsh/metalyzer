![Metalyzer logo](http://trust.f4.hs-hannover.de/img/logos/metalyzer.png)

# Metalyzer

Metalyzer is a extension to the IF-MAP visualization suite VisITMeta (works with version 0.2.0 or newer).

It extends the VisITMeta dataservice to perform statistical methods and semantic(-like) queries on MAP graphs and visualize the results within a GUI. With the use of VisITMeta’s history of MAP data, time-variant analysis can be done.

The software was developed during a [students project][11] at Hochschule Hannover.

## Background: VisITMeta

For more information about VisITMeta, take a look at its [project page][visitmetaproject] or the [Github repository][visitmetagithub].

# Prerequisites and pre-setup

## Maven

In order to build Metalyzer with Maven you need to install
[Maven 3][4] manually or via the package manager of your
operating system.

## Installation of R engine

The dataservice module of Metalyer uses the [R project][r] for some of its statistical analysis.
Prior to building Metalyzer you must install a R runtime on your system and set (at-least) the following environmental variables 

### Windows

`R_HOME` should be something like `C:\Program Files\R\R-<version>`

### Linux

	export R_HOME=/usr/lib/R
	export CLASSPATH=.:/usr/lib/R/site-library/rJava/jri

### Apple Mac OSX

	export R_HOME=/Library/Frameworks/R.framework/Resources
	export CLASSPATH=.:/Library/Frameworks/R.framework/Resources/library/rJava/jri

# Building

This section describes, how to build Metalyer from scratch.

## Build Metaylzer

Now you can build Metalyzer via `$ mvn package` in the root directory of the Metalyzer project (the directory
containing this `README` file). Maven should download all further needed dependencies for you.
After a successful build you there are two important artifacts:

1. *metalyzer-dataservice-module-distribution*:
Copy the file `target/metalyzer-dataservice-module-distribution-<version>-bundle.zip` to a new folder called `dataservice-modules` within the VisITMeta application root directory and unzip it there.

2. *metalyzer-visualization-distribution*:
Unzip the file `target/metalyzer-visualization-distribution-<version>-bundle.zip` to a arbitrary place.

# Running

1. Start a MAP server, e.g. irond (Download section at [Trust@HsH website] [10] or via
[Github] [6]

2. Change your working directory to the root directory of the VisITMeta project.

3. Start the VisITMeta dataservice via `$ sh start-dataservice.sh`.
This will try to load the Metalyzer dataservice module.
If successfully loaded, you should see somethink like `[main] INFO  de.hshannover.f4.trust.metalyzer.api.MetalyzerModule  - Metalyzer dataservice module v0.1.0 started successfully` in the log output.

4. Start the Metalyzer GUI via `$ sh start-metalyzer.sh` from within the directory containing the `metalyzer-visualization-distribution`.

5. Publish some data. Within the `scripts` directory of VisITMeta, you will find some Shell scripts that work with our
ifmapcli-tools and will publish and delete some metadata, so that you can test the
statistical and semantical analysis functionality of Metalyzer.

# Feedback

If you have any questions, problems or comments, please contact
	trust@f4-i.fh-hannover.de

# License

Metalyzer is licensed under the [Apache License, Version 2.0][7].

----

[1]: http://www.trustedcomputinggroup.org/resources/tnc_ifmap_binding_for_soap_specification
[2]: http://www.hs-hannover.de/start/index.html
[3]: http://trust.f4.hs-hannover.de/projects/visitmeta.html
[4]: https://maven.apache.org/download.html
[5]: https://github.com/trustathsh/irondemo.git
[6]: https://github.com/trustathsh/irond.git
[7]: http://www.apache.org/licenses/LICENSE-2.0.html
[8]: http://www.bmbf.de/en/index.php
[9]: http://www.neo4j.org/
[10]: http://trust.f4.hs-hannover.de
[11]: http://trust.f4.hs-hannover.de/2013/10/31/metalyzer-analysis-of-map-graphs.html
[visitmetaproject]: http://trust.f4.hs-hannover.de/projects/visitmeta.html
[visitmetagithub]: https://github.com/trustathsh/visitmeta
[r]: http://www.r-project.org/