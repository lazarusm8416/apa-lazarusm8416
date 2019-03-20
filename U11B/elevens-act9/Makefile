JFLAGS = -g
JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $(JFLAGS) $*.java

CLASSES = \
	ElevensGUIRunner.java \
	CardGameGUI.java \
	ElevensBoard.java \
	Board.java \
	Deck.java \
	Card.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
