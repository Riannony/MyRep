
public class GardenPlant extends Plant{
	private int maxHeight;
	public GardenPlant() {
		super();
	}
	public GardenPlant (int max,String name,int height) {
		super(height,name);
		this.maxHeight = max;
	}
	public int getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	  
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof GardenPlant))
			return false;
		GardenPlant other = (GardenPlant) obj;
		if (maxHeight != other.maxHeight)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "GardenPlant [maxHeight=" + maxHeight + ", Height ="
				+ getHeight() + ", Name=" + getName() + "]";
	}
	


}

