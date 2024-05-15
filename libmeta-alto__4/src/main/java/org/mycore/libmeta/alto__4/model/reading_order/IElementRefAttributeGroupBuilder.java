package org.mycore.libmeta.alto__4.model.reading_order;

/**
    * Build for Attributes of ElementRef
    * 
    * @author Robert Stephan
    * @version Alto 4.4
    *
    */
   public interface IElementRefAttributeGroupBuilder<T extends IElementRefAttributeGroup, B>{
       public T _target();

       public B _self();

       public default B ID(String id) {
           _target().setID(id);
           return _self();
       }

       public default B REFS(String refs) {
           _target().setREFS(refs);
           return _self();
       }

       public default B TAGREFS(String tagrefs) {
           _target().setTAGREFS(tagrefs);
           return _self();
       }
}
