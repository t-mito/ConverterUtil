mkdir bin
javac -cp .;src -d bin -encoding UTF-8 src/util/converter/CamelToSnakeConverter.java
javac -cp .;src -d bin -encoding UTF-8 src/util/converter/SnakeToCamelConverter.java
javac -cp .;src -d bin -encoding UTF-8 src/util/generator/ContainerFieldJavadocGenerator.java
