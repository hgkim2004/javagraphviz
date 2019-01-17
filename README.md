# javagraphviz

A very simple Graphviz Java API.

## Requirements

* Java 1.5+
* Maven (https://maven.apache.org/)
* Graphviz (www.graphviz.org/)

## Quick Start

#### Example 1
```java
		DiGraph dot = new DiGraph();
		
		dot.node("1", "CSTMesher2D");
		dot.node("2", "CSTSolver");
		dot.node("3", "CSTSolver");
		
		dot.edge("1", "2");
		dot.edge("1", "3");
		
		dot.render("split_workflow");

```

##### Result
![Example 1](https://github.com/hgkim2004/javagraphviz/blob/master/split_workflow.png)

## compile and run
```bash
mvn clean dependency:copy-dependencies package
java -classpath target/javagraphviz-0.0.1-SNAPSHOT.jar:target/dependency/commons-exec-1.3.jar javagraphviz.App
```
