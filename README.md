# javagraphviz

A very simple Graphviz Java API.

## Requirements

* Java 1.5+
* Graphviz(www.graphviz.org/)

## Quick Start

#### Example 1
```java
		DiGraph dot = new DiGraph();
		
		dot.node("1", "CSTMesher2D");
		dot.node("2", "CSTSolver");
		dot.node("3", "CSTSolver");
		
		dot.edge("1", "2");
		dot.edge("1", "3");
		
		dot.redner("split_workflow");

```

##### Result
