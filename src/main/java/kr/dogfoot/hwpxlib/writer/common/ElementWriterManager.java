package kr.dogfoot.hwpxlib.writer.common;

import kr.dogfoot.hwpxlib.writer.util.XMLStringBuilder;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class ElementWriterManager {
    private final Map<ElementWriterSort, Queue<ElementWriter>> storage;
    private final XMLStringBuilder xsb;

    public ElementWriterManager() {
        storage = new HashMap<ElementWriterSort, Queue<ElementWriter>>();
        xsb = new XMLStringBuilder();
    }

    public ElementWriter get(ElementWriterSort sort) {
        Queue<ElementWriter> queue = queue(sort);
        ElementWriter writer = queue.poll();
        if (writer == null) {
            writer = ElementWriterFactory.create(sort, this);
        }
        return writer;
    }

    private Queue<ElementWriter> queue(ElementWriterSort sort) {
        Queue<ElementWriter> queue = storage.get(sort);
        if (queue == null) {
            queue = new LinkedList<ElementWriter>();
            storage.put(sort, queue);
        }
        return queue;
    }

    public void release(ElementWriter writer) {
        Queue<ElementWriter> queue = queue(writer.sort());
        queue.offer(writer);
    }

    public XMLStringBuilder xsb() {
        return xsb;
    }
}
