import java.util.Iterator;
import java.util.NoSuchElementException;




public class Parser<T> implements Iterable<T> {
	Conteiner<Plant> conteiner;
	Plant plant;
	int count = 0;
	private static final int CRITERION = 10;
	public Parser(Conteiner<Plant> conteiner) {
		this.conteiner = conteiner;
	}
	@Override
	public Iterator<T> iterator() {
		return new ParserIterator();
	}
	
	
	private class ParserIterator implements Iterator<T> {

		@Override
		public boolean hasNext() {
			if (count < conteiner.size())
				return true;
			return false;
		}

		@Override
		public T next() {
			if (count == conteiner.size()) {
				throw new NoSuchElementException();
			}
			return (T) (plant = isElementIneed(conteiner.get(count++)));
		}
		
		private Plant isElementIneed(Plant pl) {
			Plant plant=pl;
			int value = pl.getHeight();
			if (value<CRITERION) {
				return plant;
			}
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
