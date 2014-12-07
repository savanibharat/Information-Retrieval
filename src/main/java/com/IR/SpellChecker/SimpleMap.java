package com.IR.SpellChecker;

public interface SimpleMap {
    public void clear();
    public int dataSize();      
    public int tableSize();
    public Object get( Object key ); 
    public Object remove( Object key ); 
    public Object put( Object key, Object value ); 
}
