Unfiltered Scalate Google App Engine example
============================================

This example shows how to use Unfiltered & Scalate on Google App Engine. This
demonstrates, among other things:

* Using [Unfiltered](http://unfiltered.databinder.net/Unfiltered.html "Unfiltered") in combination with [Scalate](http://scalate.fusesource.org/ "Scalate")
* [Precompiling](http://scalate.fusesource.org/documentation/user-guide.html#precompiling_templates "Precompiling Scalate templates") [Scalate](http://scalate.fusesource.org/ "Scalate") [templates](http://scalate.fusesource.org/documentation/user-guide.html#Template_Languages "Scalate template languages") - necessary for GAE as you can't create files
* Using [Scalate layouts](http://scalate.fusesource.org/documentation/user-guide.html#layouts "Scalate layouts")
* Using the [GAE Maven plugin](http://code.google.com/p/maven-gae-plugin/ "GAE Maven plugin") for integration testing/running locally/deploying
* [Reserving ports](http://mojo.codehaus.org/build-helper-maven-plugin/reserve-network-port-mojo.html "Reserve network ports") for integration testing - no hardcoded ports for portability
