package exam_janvier_2018;

import java.util.LinkedList;
import java.util.List;

public class Tape<T> {

    private List<T[]> mem = new LinkedList<>();

    private TapePointer head;

    private int byteSize;;
    private int lastBlockIndex = -1;

    Tape(int byteSize) {
        this.byteSize = byteSize;
        mem = new LinkedList<>();
        lastBlockIndex = 0;

        // Work around to generate an array of a generic type (Supposing T extends
        // Object...)
        mem.add((T[]) new Object[byteSize]);
    }

    private class TapePointer implements Moveable {

        int currentBlock;
        int currentBytePos;

        TapePointer(int blockPos, int bytePos) throws EOTException {
            if (blockPos > lastBlockIndex || blockPos < 0)
                throw new EOTException();

            currentBlock = blockPos;
            currentBytePos = bytePos;
        }

        TapePointer(int blockPos) throws EOTException {
            this(blockPos, 0);
        }

        @Override
        public void move(int n) throws EOTException {
            if (currentBlock + n > lastBlockIndex || currentBlock + n < 0)
                throw new EOTException();
            if (n > 0) {
                currentBytePos = (currentBytePos + n) % byteSize;
                currentBlock = (currentBytePos + n) / byteSize;
            }
        }

        @Override
        public T retrieve() {
            return mem.get(currentBlock)[currentBytePos];
        }

        public void write(T value) throws EOTException {
            move(1);
            mem.get(currentBlock)[currentBytePos] = value;
        }
    }

}
