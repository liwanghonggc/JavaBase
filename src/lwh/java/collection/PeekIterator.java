package lwh.java.collection;

import java.util.Iterator;

/**
 * @author lwh
 * @date 2018-09-16
 * @desp 实现一个迭代器类,有两个方法,一个是next,一个是peek
 */
public class PeekIterator implements Iterator<Integer> {

    private Integer next = null;

    private Iterator<Integer> itr;

    public PeekIterator(Iterator<Integer> itr){
        this.itr = itr;
        if(itr.hasNext()){
            next = itr.next();
        }
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }

    @Override
    public Integer next() {
        Integer res = next;
        next = itr.hasNext() ? itr.next() : null;
        return res;
    }

    public Integer peek(){
        return next;
    }
}
