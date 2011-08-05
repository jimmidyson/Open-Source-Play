Open Source Play
=====================

This is simply a list of projects to try playign with different open source projects
to evaluate their usefulness - and have a bit of fun at the same time :-)

These are all fairly simple and in no way are trying to demonstrate best practices -
they are mostly just hacked together. They can be used as a base to further explore
their capabilties of course :-)

Unfiltered Scalate Google App Engine example
--------------------------------------------

This example shows how to use Unfiltered & Scalate on Google App Engine. This
demonstrates, among other things:

* [Precompiling](http://scalate.fusesource.org/documentation/user-guide.html#precompiling_templates "Precompiling Scalate templates") [Scalate](http://scalate.fusesource.org/ "Scalate") [templates](http://scalate.fusesource.org/documentation/user-guide.html#Template_Languages "Scalate template languages") - necessary for GAE as you can't create files
* Using [Scalate layouts](http://scalate.fusesource.org/documentation/user-guide.html#layouts "Scalate layouts")
* Using the [GAE Maven plugin](http://code.google.com/p/maven-gae-plugin/ "GAE Maven plugin") for integration testing/running locally/deploying
* [Reserving ports](http://mojo.codehaus.org/build-helper-maven-plugin/reserve-network-port-mojo.html "Reserve network ports") for integration testing - no hardcoded ports for portability
