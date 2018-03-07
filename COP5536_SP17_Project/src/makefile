sourcefiles = \
	encoder.java \
	decoder.java \
	BinaryHeap.java \
	FourWayHeap.java \
	PackToBinary.java \
	PairingHeap.java \
	PairNode.java \
	TreeNode.java \
	Unpack.java
 
classfiles  = $(sourcefiles:.java=.class)
 
all: $(classfiles)
%.class: %.java
	javac -d . -classpath . $<

clean:
	rm -f *.class