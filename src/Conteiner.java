import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Conteiner<E> implements List<E> {
	private Object[] elementData;
	private int size;

	public Conteiner(int initialCapacity) {
		super();
		if (initialCapacity < 0)
			throw new IllegalArgumentException("Illegal Capacity: "
					+ initialCapacity);
		this.elementData = new Object[initialCapacity];
	}

	public Conteiner() {
		this(10);
	}

	/**
	 * Increases the capacity of this Conteiner instance
	 * 
	 * @param minCapacity
	 */
	private void ensureCapacityInternal(int minCapacity) {
		if (minCapacity - elementData.length > 0)
			grow(minCapacity);
	}

	private void grow(int minCapacity) {
		int oldCapacity = elementData.length;
		int newCapacity = oldCapacity + (oldCapacity >> 1);
		if (newCapacity - minCapacity < 0)
			newCapacity = minCapacity;
		elementData = Arrays.copyOf(elementData, newCapacity);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean contains(Object o) {
		return indexOf(o) >= 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(elementData, size);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size)
			return (T[]) Arrays.copyOf(elementData, size, a.getClass());
		System.arraycopy(elementData, 0, a, 0, size);
		if (a.length > size)
			a[size] = null;
		return a;
	}

	@Override
	public boolean add(E e) {
		ensureCapacityInternal(size + 1);
		elementData[size++] = e;
		return true;
	}

	@Override
	public boolean remove(Object o) {
		if (o == null) {
			for (int index = 0; index < size; index++)
				if (elementData[index] == null) {
					remove(index);
					return true;
				}
		} else {
			for (int index = 0; index < size; index++)
				if (o.equals(elementData[index])) {
					remove(index);
					return true;
				}
		}
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		for (Object e : c) 
			if (!contains(e))
				return false;
		return true;

	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		 boolean modified = false;
	        for (E e : c)
	            if (add(e))
	                modified = true;
	        return modified;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		rangeCheck(index);
		 Object[] temp = c.toArray();
	        int numNew = temp.length;
	        ensureCapacityInternal(size + numNew);  
	        int numMoved = size - index;
	        if (numMoved > 0)
	            System.arraycopy(elementData, index, elementData, index + numNew,
	                             numMoved);

	        System.arraycopy(temp, 0, elementData, index, numNew);
	        size += numNew;
	        return numNew != 0;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		 boolean modified = false;
	        if (size() > c.size()) {
	            for (Iterator<?> i = c.iterator(); i.hasNext(); )
	            	if (remove(i.next())) modified = true;
	        } else {
	            for (Iterator<?> i = iterator(); i.hasNext(); ) {
	                if(c.contains(i.next())) {
	                	remove(i);
	                    modified = true;
	                }
	            }
	        }
	        return modified;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		 boolean modified = false;
		 for(Object o2:c) {
			 for(Object o:elementData) {
				 if(o2!=null&o2.equals(o)) {
					 remove(o2);
					 modified=true;
				 }
			 }
		 }
	      return modified;
	}

	@Override
	public void clear() {
		 Iterator<E> it = iterator();
	        while (it.hasNext()) {
	            it.next();
	            it.remove();
	        }
	}

	@Override
	public E get(int index) {
		rangeCheck(index);
		return elementData(index);
	}

	@Override
	public E set(int index, E element) {
		rangeCheck(index);
		elementData[index] = element;
		return elementData(index);
	}

	@Override
	public void add(int index, E element) {
		rangeCheck(index);
		Object[] temp=new Object[elementData.length+1];
		for(int i=0;i<elementData.length;i++){
			if(i<index){
				temp[i]=elementData[i];
			}else{
				temp[i+1]=elementData[i];
			}
		}
		temp[index]=element;
		elementData=temp;
	}

	@Override
	public E remove(int index) {
		rangeCheck(index);
		E oldValue = elementData(index);
		int numMoved = size - index - 1;
		if (numMoved > 0)
			System.arraycopy(elementData, index + 1, elementData, index,
					numMoved);
        elementData[--size] = null;
		return oldValue;
	}
	

	private E elementData(int index) {
		return (E) elementData[index];
	}

	private void rangeCheck(int index) {
		if (index >= size)
			throw new IndexOutOfBoundsException();

	}

	@Override
	public int indexOf(Object o) {
		if (o == null) {
			for (int i = 0; i < size; i++)
				if (elementData[i] == null)
					return i;
		} else {
			for (int i = 0; i < size; i++)
				if (o.equals(elementData[i]))
					return i;
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		if (o == null) {
            for (int i = size-1; i >= 0; i--)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = size-1; i >= 0; i--)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		List<E> temp=new Conteiner<E>();
		int numMoved=toIndex-fromIndex+1;
		Object[] tt=new Object[numMoved];
		System.arraycopy(elementData, fromIndex, tt, 0, numMoved);
		for(Object o:tt) {
			temp.add((E)o);
		}
		return temp;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		if (elementData != null) {
			for (int i = 0; i < this.elementData.length; i++) {
				str.append(elementData[i]).append(" ");
			}
		} else {
			throw new NullPointerException();
		}
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println("New conteiner is created");
		Conteiner<Object> c = new Conteiner<Object>();
		System.out.println("14 elements was added");
		c.add(new String("ads"));
		c.add(new String("avs"));
		c.add(new String("ads"));
		c.add(new String("avs"));
		c.add(new String("ads"));
		c.add(new String("avs"));
		c.add(new String("ads"));
		c.add(new String("avs"));
		c.add(new String("ads"));
		c.add(new String("avs"));
		c.add(new String("ads"));
		c.add(new String("avs"));
		c.add(new String("ads"));
		c.add(new String("avs"));
		System.out.println("Check if conteiner is empty ==>" + c.isEmpty());
		System.out.println("Size ==>" + c.size);
		System.out.println("All container's elements ==>");
		System.out.println(c);
		String[] s = new String[c.size()];
		s = c.toArray(s);
		System.out.println("Copy conteiner's elements to array ==>");
		for (int i = 0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
		System.out.println();
		System.out.println("Create new ArrayList c2==>");
		ArrayList<String> c2=new ArrayList<String>();
		c2.add(new String("ads"));
		c2.add(new String("avs"));
		c2.add(new String("Hi"));
		System.out.println(c2);
		System.out.println("Check if conteiner conteins all arrailist ==>"+c.containsAll(c2));
		ArrayList<String> str2=new ArrayList<String>();
		str2.add("Hi");
		System.out.println("New list ==>"+str2);
		System.out.println("Insert str2 to the end of container ==>");
		c.addAll(str2);
		System.out.println(c);
		System.out.println("Insert str2 on 2d position ==>");
		c.addAll(2, str2);
		System.out.println(c);
		System.out.println("Remove all ==>"+c.removeAll(str2));
		System.out.println(c);
		System.out.println("retainAll ==>"+c.retainAll(c2));
		System.out.println(c);
		System.out.println("SubList ==>"+c.subList(0, 3));
		System.out.println("New element added by index ==>");
		c.add(0, new String("mama mula ramu"));
		System.out.println(c);
		System.out.println("Get element buy index ==>"+c.get(2));
		System.out.println(c.set(2, new String("piiiiii")));
		System.out.println(c);
	}

}