
public class Plant {
	private int height;
	private String name;
	
	public Plant() {
		height = 1;
		name = "plant";
	}
	public Plant(int height,String name) {
			this.height = height;
			this.name = name;
		
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Plant))
			return false;
		Plant other = (Plant) obj;
		if (height != other.height)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Plant [height=" + height + ", name=" + name + "]";
	}
	
	

}
