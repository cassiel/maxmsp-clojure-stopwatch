# A stopwatch for MaxMSP, written in Clojure

This is a demo of a simple stopwatch for MaxMSP. (It's so simple that
it doesn't even stop: it simply reports the time in milliseconds
between consecutive bangs.) It was coded as a proof-of-concept that
the Clojure system's ability to compile its code into "real" Java
class files allows Clojure programs to target MaxMSP directly, without
any other machinery.

This distribution is a [Leiningen][lein] project with a single source
file: if you're impatient, you can see the source [here][gist].

## Usage

To get started, do a Git checkout on this project and install
Leiningen according to the [README][lein-readme].

The project is linked against `max.jar`, MaxMSP's library for Java
interoperability. In order for Leiningen to find and link against
this file, it'll need to be installed into your local Maven
repository. On OS X (or Linux) you'd do something like this:

	cd /Applications/Max5/Cycling\ \'74/java/lib/

	mvn install:install-file \
		-Dfile=max.jar \
		-DgroupId=com.cycling74 \
		-DartifactId=com-cycling74-max \
		-Dversion=5.1.9 \
		-Dpackaging=jar \
		-DgeneratePom=true

This is mostly boilerplate: it creates a `com-cycling74-max` resource
with version `5.1.9` (chosen merely to match the release of MaxMSP).

Once that's done, setup the dependencies and compile everything:

	lein deps
	lein compile

MaxMSP needs the Clojure system: if you look in the directory `lib`,
you'll see a `clojure-x.x.x.jar` - copy that to Max's `Cycling
'74/java/lib` directory.

The directory `classes` contains the compiled class files. You can edit
Max's `max.java.config.txt` to place this directory into the
CLASSPATH, but it must be in the *system* path, not the dynamic one
(otherwise the Clojure system won't be able to find the classes
belonging to this project). If that all sounds too complicated, just do a

	lein jar

to make a JAR file for the project - it'll create a
`maxmsp-clojure-stopwatch-1.0.0.jar` - and put this into `Cycling
'74/java/lib` as well.

That should be it: open the enclosed patcher and push the button.

## License

Copyright (C) 2011 Nick Rothwell, nick@cassiel.com

Distributed under the Eclipse Public License, the same as Clojure.

[lein]: https://github.com/technomancy/leiningen
[gist]: https://gist.github.com/1117219
[lein-readme]: https://github.com/technomancy/leiningen/blob/master/README.md
