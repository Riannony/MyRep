
public class Tree extends GardenPlant {
	private String GroundType;
	public Tree() {
		super();
	}
	public Tree (String grType, int max,String name,int height) {
		super(max,name,height);
		this.GroundType = grType;
	}
	public String getGroundType() {
		return GroundType;
	}
	public void setGroundType(String groundType) {
		GroundType = groundType;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof Tree))
			return false;
		Tree other = (Tree) obj;
		if (GroundType == null) {
			if (other.GroundType != null)
				return false;
		} else if (!GroundType.equals(other.GroundType))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Tree [GroundType=" + GroundType + ", MaxHeight="
				+ getMaxHeight() + ", Height=" + getHeight()
				+ ", Name=" + getName() + "]"+System.lineSeparator();
	}
	
	

}
