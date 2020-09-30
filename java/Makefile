JFLAGS = -cp
JC = javac
JAR = javax.mail.jar

Main.class: Main.java
	$(JC) $(JFLAGS) '.:$(JAR)' Main.java

send:
	java $(JFLAGS) '.:$(JAR)' Main

clean:
	$(RM) *.class