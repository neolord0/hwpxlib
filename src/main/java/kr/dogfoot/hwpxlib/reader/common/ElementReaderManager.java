package kr.dogfoot.hwpxlib.reader.common;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ElementReaderManager {
    private Map<ElementReaderSort, Queue<ElementReader>> storage;

    public ElementReaderManager() {
        storage = new HashMap<ElementReaderSort, Queue<ElementReader>>();
    }

    public ElementReader get(ElementReaderSort sort) {
        Queue<ElementReader> queue = queue(sort);
        ElementReader reader = queue.poll();
        if (reader == null) {
            reader = ElementReaderFactory.create(sort);
        }
        return reader;
    }

    private Queue<ElementReader> queue(ElementReaderSort sort) {
        Queue<ElementReader> queue = storage.get(sort);
        if (queue == null) {
            queue = new LinkedList<ElementReader>();
            storage.put(sort, queue);
        }
        return queue;
    }

    public void release(ElementReader reader) {
        Queue<ElementReader> queue = queue(reader.sort());
        queue.offer(reader);
    }
}
