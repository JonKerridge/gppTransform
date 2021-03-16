The application gppTransform can be downloaded as a runnable jar which
can be executed using:   
java -jar gppTransform.jar  

The application opens a file chooser which opens files with type extension cgpp and gpp.
The gppTransform then transforms definitional scripts that use the groovy_parallel_patterns
library, into the required Groovy scripts that can be executed. The resultant files are stored
in the same folder as the original script.

Files with extension cgpp create applications that can be executed on a cluster of multi-core 
workstations.  
Files with extension gpp create applications that run on a single multi-core workstation.  

The repositories and dependencies used in the build.gradle file for gppTransform are:
<pre>
repositories {
    mavenCentral()
    maven { // to download the jonkerridge.groovy_jcsp library
        name = "GitHub"
        url = "https://maven.pkg.github.com/JonKerridge/groovyJCSP"
        credentials {
            username = project.findProperty("gpr.user")
            password = project.findProperty("gpr.key")
        }
    }
    maven { // to download the cspforjava.jcsp library
        name = "GitHub"
        url = "https://maven.pkg.github.com/CSPforJAVA/jcsp"
        credentials {
            username = project.findProperty("gpr.user")
            password = project.findProperty("gpr.key")
        }
    }
    maven { // to download the jonkerridge.groovy_parallel_patterns library
        name = "GitHub"
        url = "https://maven.pkg.github.com/JonKerridge/GPP_Library"
        credentials {
            username = project.findProperty("gpr.user")
            password = project.findProperty("gpr.key")
        }
    }
    maven { // to download the jonkerridge.gpp_builder library
        name = "GitHub"
        url = "https://maven.pkg.github.com/JonKerridge/GPP_Builder"
        credentials {
            username = project.findProperty("gpr.user")
            password = project.findProperty("gpr.key")
        }
    }
    maven { // to download the jonkerridge.gpp_cluster_builder library
        name = "GitHub"
        url = "https://maven.pkg.github.com/JonKerridge/gppClusterBuilder"
        credentials {
            username = project.findProperty("gpr.user")
            password = project.findProperty("gpr.key")
        }
    }
}

dependencies {
    compile 'org.codehaus.groovy:groovy-all:3.0.7'
    compile 'cspforjava:jcsp:1.1.9'
    compile 'jonkerridge:groovy_jcsp:1.1.9'
    compile "jonkerridge:gpp_builder:1.1.12"
    compile 'jonkerridge:groovy_parallel_patterns:1.1.12'
    compile "jonkerridge:gpp_cluster_builder:1.1.0"
}
</pre>

The gppTransform.jar file contains all the above libraries and can be used without having to 
download each of the libraries.