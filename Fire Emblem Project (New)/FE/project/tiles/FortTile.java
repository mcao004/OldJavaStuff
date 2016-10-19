package FE.project.tiles;

import FE.project.gfx.Assets;

public class FortTile extends Tile {
	
	public FortTile(int id){
		super(Assets.fort, id, 2, 20, 2);
	} // also provides 20% HP recovery
}
