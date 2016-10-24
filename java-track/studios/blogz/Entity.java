package blogz;

public abstract class Entity {

	private final int UID;
	private static int totalEntity = 0;
	
	public Entity() {
		totalEntity++;
		UID = totalEntity;
	}
	
	public int getUID() {
		return UID;
	}
	
}
