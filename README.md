Example for using Java library with LabView
====================

Example of using java code within LabView.

A full write up on how to accomplish this can be found at <http://www.summitsystemsinc.com/programming/java-with-labview>.

Please see the project documentation at <http://summitsystemsinc.github.com/labview-java-example/>

NOTES:
- Project is built with Maven 3 from http://maven.apache.org/
- The current version of the IKVM-maven-plugin explicitly adds System.Core.dll, 
  which does not exist in my .NET 2.0 framework, so I have to compile using mono, 
  which works great. Or this can be compiled using MS .NET 4
- Documentation for the IKVM-maven-plugin is at <http://github.com/samskivert/ikvm-maven-plugin>
