
public class Flouwer extends GardenPlant {
	private String color;
	public Flouwer() {
		super();
	}
	public Flouwer (int max,String name,int height,String color ) {
		super(max, name, height);
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Flouwer))
			return false;
		Flouwer other = (Flouwer) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flouwer [color=" + color + ", MaxHeight=" + getMaxHeight()
				+ ", Height=" + getHeight() + ", Name=" + getName()
				+ "]"+System.lineSeparator();
	}
	
}
